/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Mentor;

import Until.Cover;
import admin.AdminDAO;
import dal.DAO;
import dal.MentorDAO;
import dal.TimeScheduleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.ScheduleRequest;
import model.SkillMentor;
import model.TimeSchedule;
import model.Time_Slot;
import model.ViewScheduleOfAllMentor;

/**
 *
 * @author admin
 */
public class ViewMentorScheduleController extends HttpServlet {

    private Cover cover = new Cover();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewMentorScheduleController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewMentorScheduleController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        int idMentor = a.getId();

        MentorDAO dao = new MentorDAO();
        Mentor list = dao.getIDMentor(idMentor);
        request.setAttribute("mentor", list);
        List<Have_SKill> hskill = dao.getidhaveskill(idMentor);
        request.setAttribute("cf", hskill);
        Account account = dao.getAccountByid(idMentor);
        request.setAttribute("cx", account);
        List<SkillMentor> skill = dao.getAllskill();
        request.setAttribute("skill", skill);

        AdminDAO addao = new AdminDAO();
// Lọc các lịch trình có trạng thái là 1 cho từng mentor và thêm vào danh sách filteredSchedules
        List<ViewScheduleOfAllMentor> listSchedule = addao.getViewScheduleOfAllMentor();
        List<ViewScheduleOfAllMentor> mentorSchedules1 = addao.getViewScheduleOfAllMentorsWithStatus(listSchedule, idMentor, 1);
        List<ViewScheduleOfAllMentor> mentorSchedules2 = addao.getViewScheduleOfAllMentorsWithStatus(listSchedule, idMentor, 2);
        System.out.println(mentorSchedules1.toString());

        MentorDAO mdao = new MentorDAO();
        List<Time_Slot> timeSlot = mdao.listTimeSlot();
        request.setAttribute("timeSlot", timeSlot);
        if (mentorSchedules1.size() == 0 && mentorSchedules2.size() == 0) {
            request.getRequestDispatcher("Mentor/Schedule.jsp").forward(request, response);
            return;
        } else if (mentorSchedules1.size() == 0) {
            String[] Startdates = cover.getDatesOfWeek(mentorSchedules2.get(0).getYear(), mentorSchedules2.get(0).getWeek());
            String[] Enddates = cover.getDatesOfWeek(mentorSchedules2.get(mentorSchedules2.size() - 1).getYear(), mentorSchedules2.get(mentorSchedules2.size() - 1).getWeek());
            String time = String.format(" %s - %s", Startdates[0], Enddates[1]);
            String status = cover.CoverStatus(mentorSchedules2.get(0).getStatus());
            request.setAttribute("scheduleList", mentorSchedules2);
            request.setAttribute("time", time);
            request.setAttribute("status", status);
            request.getRequestDispatcher("Mentor/ViewMentorSchedule.jsp").forward(request, response);
        } else {
            String[] Startdates = cover.getDatesOfWeek(mentorSchedules1.get(0).getYear(), mentorSchedules1.get(0).getWeek());
            String[] Enddates = cover.getDatesOfWeek(mentorSchedules1.get(mentorSchedules1.size() - 1).getYear(), mentorSchedules1.get(mentorSchedules1.size() - 1).getWeek());
            String time = String.format(" %s - %s", Startdates[0], Enddates[1]);
            String status = cover.CoverStatus(mentorSchedules1.get(0).getStatus());
            request.setAttribute("scheduleList", mentorSchedules1);
            request.setAttribute("time", time);
            request.setAttribute("status", status);
            request.getRequestDispatcher("Mentor/ViewMentorSchedule.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MentorDAO dao = new MentorDAO();
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        int idMentor = dao.getAccountByid(a.getId()).getId();
        TimeScheduleDAO timeScheduleDAO = new TimeScheduleDAO();

        int year = Integer.parseInt(request.getParameter("year"));
        int startWeekNumber = Integer.parseInt(request.getParameter("startWeek"));
        int endWeekNumber = Integer.parseInt(request.getParameter("endWeek"));

        // Debugging: Kiểm tra giá trị của startWeekNumber và endWeekNumber
        System.out.println("Start Week Number: " + startWeekNumber);
        System.out.println("End Week Number: " + endWeekNumber);

        String[] schedules = request.getParameterValues("schedule");
        if ("draft".equalsIgnoreCase(request.getParameter("draft"))) {
            if (schedules != null) {
                dao.deleteRequestSchedule(idMentor);
                for (String schedule : schedules) {
                    String[] parts = schedule.split("-");
                    if (parts.length == 2) {
                        String day = parts[0];
                        int timeSlotID = Integer.parseInt(parts[1]);
                        for (int i = startWeekNumber; i <= endWeekNumber; i++) {
                            TimeSchedule timeSchedule = new TimeSchedule(year, i, day, timeSlotID);
                            timeScheduleDAO.addTimeSchedule(timeSchedule);
                            ScheduleRequest scheduleRequest = new ScheduleRequest(idMentor, timeScheduleDAO.getSlotID(timeSchedule), 0);
                            dao.addScheduleRequest(scheduleRequest);
                        }
                    }
                }
                request.getRequestDispatcher("Succesfull.jsp").forward(request, response);
            } else {
                // Xử lý trường hợp không có checkbox nào được chọn
                System.out.println("No schedule selected");
                // Bạn có thể redirect đến một trang lỗi hoặc xử lý lỗi khác ở đây
                response.sendRedirect("error.jsp");
            }
        } else {
            if (schedules != null) {
                dao.deleteRequestSchedule(idMentor);
                for (String schedule : schedules) {
                    String[] parts = schedule.split("-");
                    if (parts.length == 2) {
                        String day = parts[0];
                        int timeSlotID = Integer.parseInt(parts[1]);
                        for (int i = startWeekNumber; i <= endWeekNumber; i++) {
                            TimeSchedule timeSchedule = new TimeSchedule(year, i, day, timeSlotID);
                            timeScheduleDAO.addTimeSchedule(timeSchedule);
                            ScheduleRequest scheduleRequest = new ScheduleRequest(idMentor, timeScheduleDAO.getSlotID(timeSchedule), 1);
                            dao.addScheduleRequest(scheduleRequest);
                        }
                    }
                }
                response.sendRedirect("viewMentorSchedule");
            } else {
                // Xử lý trường hợp không có checkbox nào được chọn
                System.out.println("No schedule selected");
                // Bạn có thể redirect đến một trang lỗi hoặc xử lý lỗi khác ở đây
                response.sendRedirect("error.jsp");
            }
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
