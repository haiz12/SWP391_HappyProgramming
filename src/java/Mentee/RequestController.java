/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Mentee;

import Until.Cover;
import admin.AdminDAO;
import dal.MenteeDAO;
import dal.MentorDAO;
import dal.RequestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.Request;
import model.Skill;
import model.SkillMentor;
import model.Time_Slot;
import model.ViewScheduleOfAllMentor;

/**
 *
 * @author admin
 */
@WebServlet(name = "RequestController", urlPatterns = {"/Request"})
public class RequestController extends HttpServlet {

    private Cover cover = new Cover();
    AdminDAO adminDao = new AdminDAO();
    private RequestDAO requestDAO;

    public void init() {
        requestDAO = new RequestDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idMentor = Integer.parseInt(request.getParameter("idMentor"));
        String skillId = request.getParameter("idSkill");
        MentorDAO mdao = new MentorDAO();
        AdminDAO addao = new AdminDAO();
        List<Time_Slot> timeSlot = mdao.listTimeSlot();
        request.setAttribute("timeSlot", timeSlot);
        List<ViewScheduleOfAllMentor> listSchedule = new ArrayList<>();
        listSchedule = addao.getViewScheduleOfAllMentorsWithStatus(addao.getViewScheduleOfAllMentor(), idMentor, 2);
        request.setAttribute("listSchedule1", listSchedule);

        String action = request.getParameter("action");

        int idSkill;
        if (skillId != null) {
            idSkill = Integer.parseInt(skillId);
        } else {
            idSkill = -1;
        }
        switch (action) {
            case "list":
                listRequests(request, response);
                break;
            case "create":
                showRequestForm(idMentor, idSkill, request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                listRequests(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        System.out.println("action post " + action);
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createRequest(request, response);
                break;
            case "update":
                updateRequest(request, response);
                break;
            default:
                listRequests(request, response);
        }
    }

    private void listRequests(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Request> requests = requestDAO.getAllRequests();
        request.setAttribute("requests", requests);
        request.getRequestDispatcher("request-list.jsp").forward(request, response);
    }

    private void showRequestForm(int idMentor, int idSkill, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Account account = (Account) request.getSession().getAttribute("account");
        if (account == null) {
            response.sendRedirect("signin");
            return;
        }
        AdminDAO addao = new AdminDAO();
        List<ViewScheduleOfAllMentor> listSchedule = addao.getViewScheduleOfAllMentor();
        List<ViewScheduleOfAllMentor> mentorSchedules2 = addao.getViewScheduleOfAllMentorsWithStatus(listSchedule, idMentor, 2);
        String[] Startdates = cover.getDatesOfWeek(mentorSchedules2.get(0).getYear(), mentorSchedules2.get(0).getWeek());
        String[] Enddates = cover.getDatesOfWeek(mentorSchedules2.get(mentorSchedules2.size() - 1).getYear(), mentorSchedules2.get(mentorSchedules2.size() - 1).getWeek());
        String time = String.format(" %s - %s", Startdates[0], Enddates[1]);     
        request.setAttribute("time", time);
        
        MentorDAO dao = new MentorDAO();
        AdminDAO adminDao = new AdminDAO();
        SkillMentor skill = new SkillMentor();
        Mentor m = dao.getIDMentor(idMentor);

        if (idSkill > 0) {
            skill = adminDao.getSkillById(idSkill);
            request.setAttribute("skillMentor", skill);
        } else {
            skill = null;
            List<Have_SKill> listHaveS = dao.getidhaveskill(idMentor);
            request.setAttribute("listHaveSkill", listHaveS);
        }

        request.setAttribute("mentor", m);

        request.getRequestDispatcher("view/create-request.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idRequest = Integer.parseInt(request.getParameter("idRequest"));
        Request requestToEdit = requestDAO.getRequestById(idRequest);
        request.setAttribute("request", requestToEdit);
        request.getRequestDispatcher("edit-request.jsp").forward(request, response);
    }

    private void createRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //System.out.println("Not available");
        try {
            // Retrieve form data
          HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        int idMentor=a.getId();
        
                AdminDAO addao = new AdminDAO();
        List<ViewScheduleOfAllMentor> listSchedule = addao.getViewScheduleOfAllMentor();
        List<ViewScheduleOfAllMentor> mentorSchedules2 = addao.getViewScheduleOfAllMentorsWithStatus(listSchedule, idMentor, 2);
        String[] Startdates = cover.getDatesOfWeek(mentorSchedules2.get(0).getYear(), mentorSchedules2.get(0).getWeek());
        String[] Enddates = cover.getDatesOfWeek(mentorSchedules2.get(mentorSchedules2.size() - 1).getYear(), mentorSchedules2.get(mentorSchedules2.size() - 1).getWeek());

            String title = request.getParameter("title");

            String content = request.getParameter("content");
            int idSkill = Integer.parseInt(request.getParameter("idSkill"));
            AdminDAO adminDao = new AdminDAO();
            SkillMentor skill = adminDao.getSkillById(idSkill);
            String nameSkill = skill.getSkillName();
            int totalCost = Integer.parseInt(request.getParameter("totalCost"));
            // Assuming you have a method to get the current Mentee ID
            Account account = (Account) request.getSession().getAttribute("account");
            int idMentee = new MenteeDAO().getMenteeByAccountId(account.getId()).getIdMentee();

            // Convert deadline date and hour to java.util.Date
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //String deadlineDate = dateFormat.format(deadlineDateStr);


            // Create a new Request object
///            Request newRequest = new Request(0, idMentee, idMentor, title, content, nameSkill, "Open", Startdates[0], Enddates[1], deadlineHour, totalCost);
//
//            // Save the new request to the database
//            RequestDAO requestDAO1 = new RequestDAO();
//            requestDAO1.createRequest(newRequest);
//            String msg = "success";
//            request.setAttribute("msg", msg);
///            request.getRequestDispatcher("view/create-request.jsp").forward(request, response);
//        if (result) {
//            // Redirect to a success page
//            response.sendRedirect("Request?action=list&success");
//        } else {
//            // Handle error case
//            response.sendRedirect("Request?action=create&fail");
//        }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Request?action=create&fail");
        }

    }

    private void updateRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Retrieve form data
            int idRequest = Integer.parseInt(request.getParameter("idRequest"));
            String title = request.getParameter("title");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            String hour = request.getParameter("deadlineHour");
            String content = request.getParameter("content");
            int totalCost = Integer.parseInt(request.getParameter("totalCost"));

            int idSkill = Integer.parseInt(request.getParameter("idSkill"));
            SkillMentor skill = adminDao.getSkillById(idSkill);

            RequestDAO requestDao = new RequestDAO();
            String msg;
            boolean a = requestDao.UpdateRequest(idRequest, title, content, skill.getSkillName(), startDate, endDate, Float.parseFloat(hour), totalCost);
            if (a) {
                msg = "ok";
            } else {
                msg = "fail";
            }
            request.setAttribute("msg", msg);
            request.getRequestDispatcher("view/updatereq.jsp").forward(request, response);
//            response.sendRedirect("updatereq?idrequest="+idRequest);
        } catch (Exception e) {
            // Handle parsing error
            response.getWriter().println(e.toString());
        }
    }

}
