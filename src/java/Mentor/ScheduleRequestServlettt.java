/////*
//// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
//// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
//// */
////
////package Mentor;
////
////import dal.MentorDAO;
////import dal.*;
////import java.io.IOException;
////import java.io.PrintWriter;
////import jakarta.servlet.ServletException;
////import jakarta.servlet.annotation.WebServlet;
////import jakarta.servlet.http.HttpServlet;
////import jakarta.servlet.http.HttpServletRequest;
////import jakarta.servlet.http.HttpServletResponse;
////import jakarta.servlet.http.HttpSession;
////import java.text.ParseException;
////import java.text.SimpleDateFormat;
////import java.util.Calendar;
////import java.util.Date;
////import java.util.Enumeration;
////import java.util.List;
////import java.util.logging.Level;
////import java.util.logging.Logger;
////import model.*;
////
/////**
//// *
//// * @author lvha0
//// */
////@WebServlet(name="ScheduleRequestServlettt", urlPatterns={"/scheduleRequest"})
////public class ScheduleRequestServlettt extends HttpServlet {
////
////    /**
////     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
////     * methods.
////     *
////     * @param request servlet request
////     * @param response servlet response
////     * @throws ServletException if a servlet-specific error occurs
////     * @throws IOException if an I/O error occurs
////     */
////    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        response.setContentType("text/html;charset=UTF-8");
////        try (PrintWriter out = response.getWriter()) {
////            /* TODO output your page here. You may use following sample code. */
////            out.println("<!DOCTYPE html>");
////            out.println("<html>");
////            out.println("<head>");
////            out.println("<title>Servlet MentorScheduleServlet</title>");
////            out.println("</head>");
////            out.println("<body>");
////            out.println("<h1>Servlet MentorScheduleServlet at " + request.getContextPath() + "</h1>");
////            out.println("</body>");
////            out.println("</html>");
////        }
////    }
////
////    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
////    /**
////     * Handles the HTTP <code>GET</code> method.
////     *
////     * @param request servlet request
////     * @param response servlet response
////     * @throws ServletException if a servlet-specific error occurs
////     * @throws IOException if an I/O error occurs
////     */
////    @Override
////    protected void doGet(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        HttpSession session = request.getSession();
////        Account a = (Account) session.getAttribute("account");
////        String idMen = request.getParameter("idMentor");
////        int idMentor = Integer.parseInt(idMen);
////
////        MentorDAO dao = new MentorDAO();
////        Mentor list = dao.getIDMentor(idMentor);
////        request.setAttribute("mentor", list);
////        System.out.println(list);
////        List<Have_SKill> hskill = dao.getidhaveskill(idMentor);
////        System.out.println(hskill);
////        request.setAttribute("cf", hskill);
////
////        Account account = dao.getAccountByid(idMentor);
////        request.setAttribute("cx", account);
////        List<SkillMentor> skill = dao.getAllskill();
////        request.setAttribute("skill", skill);
////        System.out.println(skill);
////        String year = request.getParameter("year");
////        String startWeek = request.getParameter("startWeek");
////        String endWeek = request.getParameter("endWeek");
////
////        request.getRequestDispatcher("Mentor/Schedule.jsp").forward(request, response);
////    }
////
////    /**
////     * Handles the HTTP <code>POST</code> method.
////     *
////     * @param request servlet request
////     * @param response servlet response
////     * @throws ServletException if a servlet-specific error occurs
////     * @throws IOException if an I/O error occurs
////     */
////    @Override
////    protected void doPost(HttpServletRequest request, HttpServletResponse response)
////            throws ServletException, IOException {
////        HttpSession session = request.getSession();
////        Account a = (Account) session.getAttribute("account");
////        String idMen = request.getParameter("idMentor");
////        int idMentor = Integer.parseInt(idMen);
////        TimeScheduleDAO timeScheduleDAO = new TimeScheduleDAO();
////
////        MentorDAO dao = new MentorDAO();
////        Mentor list = dao.getIDMentor(idMentor);
////        request.setAttribute("mentor", list);
////        System.out.println(list);
////        List<Have_SKill> hskill = dao.getidhaveskill(idMentor);
////        System.out.println(hskill);
////        request.setAttribute("cf", hskill);
////
////        Account account = dao.getAccountByid(idMentor);
////        request.setAttribute("cx", account);
////        List<SkillMentor> skill = dao.getAllskill();
////        request.setAttribute("skill", skill);
////        System.out.println(skill);
////        int year = Integer.parseInt(request.getParameter("year"));
////        String startWeek = request.getParameter("startWeek");
////        String endWeek = request.getParameter("endWeek");
////        int startWeekNumber = 1;
////        int endWeekNumber = 1;
////        request.getRequestDispatcher("Mentor/Schedule.jsp").forward(request, response);
////        
////        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
////
////        try {
////            // Tách ngày bắt đầu và ngày kết thúc từ chuỗi
////            String[] parts = startWeek.split(" to ");
////            Date startDate = dateFormat.parse(parts[0]);
////            Date endDate = dateFormat.parse(parts[1]);
////
////            // Tính tuần từ ngày bắt đầu
////            Calendar cal = Calendar.getInstance();
////            cal.setTime(startDate);
////            startWeekNumber = cal.get(Calendar.WEEK_OF_YEAR);
////
////            // In ra kết quả
////            System.out.println("Week number: " + startWeekNumber);
////
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////
////        try {
////            // Tách ngày bắt đầu và ngày kết thúc từ chuỗi
////            String[] parts = endWeek.split(" to ");
////            Date startDate = dateFormat.parse(parts[0]);
////            Date endDate = dateFormat.parse(parts[1]);
////
////            // Tính tuần từ ngày bắt đầu
////            Calendar cal = Calendar.getInstance();
////            cal.setTime(startDate);
////            endWeekNumber = cal.get(Calendar.WEEK_OF_YEAR);
////
////            // In ra kết quả
////            System.out.println("Week number: " + endWeekNumber);
////
////        } catch (ParseException e) {
////            e.printStackTrace();
////        }
////
////        String[] schedules = request.getParameterValues("schedule");
////
////        if (schedules != null) {
////            for (String schedule : schedules) {
////                // Split giá trị để lấy thông tin thứ và slot
////                String[] parts = schedule.split("-");
////                if (parts.length == 2) {
////                    String day = parts[0]; // Thứ (mon, tue, wed, ...)
////                    int timeSlot = Integer.parseInt(parts[1]) ; // Slot (giá trị thời gian)
////                    
////                    // Xử lý dữ liệu (ví dụ: in ra console)
////                    System.out.println("Day: " + day + ", Time Slot: " + timeSlot);
////
////                    // Để lưu vào cơ sở dữ liệu hoặc thực hiện các xử lý khác, bạn có thể sử dụng day và timeSlot ở đây
////                    // Ví dụ: gọi hàm xử lý lưu vào DB với day và timeSlot
////                    for (int i = startWeekNumber; i <= endWeekNumber; i++) {
////                        TimeSchedule timeSchedule = new TimeSchedule(year, startWeekNumber, day, timeSlot);
////                        timeScheduleDAO.addTimeSchedule(timeSchedule);
////                        
////                        ScheduleRequest scheduleRequest = new ScheduleRequest(idMentor, timeSlot);
////                        dao.addScheduleRequest(scheduleRequest);
////                        
////                        
////                    }
////                }
////                request.getRequestDispatcher("Succesfull.jsp").forward(request, response);
////            }
////        }
////
////        // Redirect hoặc forward tới một trang khác sau khi xử lý xong
////        // Ví dụ: response.sendRedirect("success.jsp");
////    }
////
////
////    @Override
////    public String getServletInfo() {
////        return "Short description";
////    }// </editor-fold>
////
////}
////
/////**
//// * Returns a short description of the servlet.
//// *
//// * @return a String containing servlet description
//// */
////
//package Mentor;
//
//import admin.AdminDAO;
//import dal.DAO;
//import dal.MentorDAO;
//import dal.TimeScheduleDAO;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//import model.Account;
//import model.Have_SKill;
//import model.Mentor;
//import model.ScheduleRequest;
//import model.SkillMentor;
//import model.TimeSchedule;
//import model.Time_Slot;
//import model.ViewScheduleOfAllMentor;
//
//@WebServlet(name = "ScheduleRequestServlet", urlPatterns = {"/scheduleRequest"})
//public class ScheduleRequestServlettt extends HttpServlet {
//
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet MentorScheduleServlet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet MentorScheduleServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession();
//        Account a = (Account) session.getAttribute("account");
//        String idMen = request.getParameter("idMentor");
//        int idMentor = Integer.parseInt(idMen);
//
//        MentorDAO dao = new MentorDAO();
//        Mentor list = dao.getIDMentor(idMentor);
//        request.setAttribute("mentor", list);
//        List<Have_SKill> hskill = dao.getidhaveskill(idMentor);
//        request.setAttribute("cf", hskill);
//        Account account = dao.getAccountByid(idMentor);
//        request.setAttribute("cx", account);
//        List<SkillMentor> skill = dao.getAllskill();
//        request.setAttribute("skill", skill);
//
//        AdminDAO addao = new AdminDAO();
//// Lọc các lịch trình có trạng thái là 1 cho từng mentor và thêm vào danh sách filteredSchedules
//        List<ViewScheduleOfAllMentor> listSchedule = addao.getViewScheduleOfAllMentor();
//        List<ViewScheduleOfAllMentor> mentorSchedules = addao.getViewScheduleOfAllMentorsWithStatus(listSchedule, 1, 1);
//        System.out.println(mentorSchedules.toString());
//        ViewScheduleOfAllMentor abc=new ViewScheduleOfAllMentor();
//        mentorSchedules.add(abc);
//// Gán danh sách mentorSchedules vào request
//        request.setAttribute("abc", mentorSchedules);
//
//        MentorDAO mdao = new MentorDAO();
//        List<Time_Slot> timeSlot = mdao.listTimeSlot();
//        request.setAttribute("timeSlot", timeSlot);
//
//        request.getRequestDispatcher("Mentor/Schedule.jsp").forward(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        MentorDAO dao = new MentorDAO();
//        HttpSession session = request.getSession();
//        Account a = (Account) session.getAttribute("account");
//        int idMentor = dao.getAccountByid(a.getId()).getId();
//        TimeScheduleDAO timeScheduleDAO = new TimeScheduleDAO();
//
//        int year = Integer.parseInt(request.getParameter("year"));
//        int startWeekNumber = Integer.parseInt(request.getParameter("startWeek"));
//        int endWeekNumber = Integer.parseInt(request.getParameter("endWeek"));
//
//        // Debugging: Kiểm tra giá trị của startWeekNumber và endWeekNumber
//        System.out.println("Start Week Number: " + startWeekNumber);
//        System.out.println("End Week Number: " + endWeekNumber);
//
//        String[] schedules = request.getParameterValues("schedule");
//        if ("draft".equalsIgnoreCase(request.getParameter("draft"))) {
//            if (schedules != null) {
//                dao.deleteRequestSchedule(idMentor);
//                for (String schedule : schedules) {
//                    String[] parts = schedule.split("-");
//                    if (parts.length == 2) {
//                        String day = parts[0];
//                        int timeSlotID = Integer.parseInt(parts[1]);
//                        for (int i = startWeekNumber; i <= endWeekNumber; i++) {
//                            TimeSchedule timeSchedule = new TimeSchedule(year, i, day, timeSlotID);
//                            timeScheduleDAO.addTimeSchedule(timeSchedule);
//                            ScheduleRequest scheduleRequest = new ScheduleRequest(idMentor, timeScheduleDAO.getSlotID(timeSchedule), 0);
//                            dao.addScheduleRequest(scheduleRequest);
//                        }
//                    }
//                }
//                request.getRequestDispatcher("Succesfull.jsp").forward(request, response);
//            } else {
//                // Xử lý trường hợp không có checkbox nào được chọn
//                System.out.println("No schedule selected");
//                // Bạn có thể redirect đến một trang lỗi hoặc xử lý lỗi khác ở đây
//                response.sendRedirect("error.jsp");
//            }
//        } else {
//            if (schedules != null) {
//                dao.deleteRequestSchedule(idMentor);
//                for (String schedule : schedules) {
//                    String[] parts = schedule.split("-");
//                    if (parts.length == 2) {
//                        String day = parts[0];
//                        int timeSlotID = Integer.parseInt(parts[1]);
//                        for (int i = startWeekNumber; i <= endWeekNumber; i++) {
//                            TimeSchedule timeSchedule = new TimeSchedule(year, i, day, timeSlotID);
//                            timeScheduleDAO.addTimeSchedule(timeSchedule);
//                            ScheduleRequest scheduleRequest = new ScheduleRequest(idMentor, timeScheduleDAO.getSlotID(timeSchedule), 1);
//                            dao.addScheduleRequest(scheduleRequest);
//                        }
//                    }
//                }
//                request.getRequestDispatcher("home.jsp").forward(request, response);
//            } else {
//                // Xử lý trường hợp không có checkbox nào được chọn
//                System.out.println("No schedule selected");
//                // Bạn có thể redirect đến một trang lỗi hoặc xử lý lỗi khác ở đây
//                response.sendRedirect("error.jsp");
//            }
//        }
//
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }
//
//}
