/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import admin.AdminDAO;
import dal.MentorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Account;
import model.CV;
import model.Have_SKill;
import model.Mentor;
import model.Skill;
import model.SkillMentor;
import model.*;

/**
 *
 * @author admin
 */
@WebServlet(name = "ScheduleServlet", urlPatterns = {"/schedule"})
@MultipartConfig
public class ScheduleServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateCVMentor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CreateCVMentor at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dal.ListRequest req = new dal.ListRequest();
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        String userName = account.getUser();

        int idAccount = req.getIdAccountByUsername(userName); // idAccount = idMentor

//        int idMentor;
//        try {
//            idMentor = Integer.parseInt(idMen);
//        } catch (NumberFormatException e) {
//            throw new ServletException("idMentor is not a valid number", e);
//        }
        MentorDAO dao = new MentorDAO();
        List<Time_Slot> timeSlot = dao.listTimeSlot();
        request.setAttribute("timeSlot", timeSlot);
        Mentor list = dao.getIDMentor(idAccount);
        request.setAttribute("mentor", list);
//        Account account = dao.getAccountByid(idMentor);
//        request.setAttribute("cx", account);

        request.getRequestDispatcher("Mentor/Schedule.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dal.ListRequest req = new dal.ListRequest();
        HttpSession session = request.getSession();

        Account account = (Account) session.getAttribute("account");
        String userName = account.getUser();

        int idAccount = req.getIdAccountByUsername(userName);
        Account a = (Account) session.getAttribute("account");
//        String idMen = request.getParameter("idMentor");
//        int idMentor = Integer.parseInt(idMen);
        MentorDAO dao = new MentorDAO();
        Mentor mentor = dao.getIDMentor(idAccount);

        String day = request.getParameter("day");

        //dao.deleteMentor(idMentor);
        String[] timeSlotId = request.getParameterValues("timeSlot");
        List<Schedule> schedule = new ArrayList<>();

        switch (day) {
            case "Monday":
                if (timeSlotId != null) {
                    for (String id : timeSlotId) {
                        dao.addSchedule(idAccount, Integer.parseInt(id), day);

                    }
                }
                break;
            case "Tuesday":
                if (timeSlotId != null) {
                    for (String id : timeSlotId) {
                        dao.addSchedule(idAccount, Integer.parseInt(id), day);

                    }
                }
                break;
            case "Wednesday":
                if (timeSlotId != null) {
                    for (String id : timeSlotId) {
                        dao.addSchedule(idAccount, Integer.parseInt(id), day);

                    }
                }
                break;
            case "Thursday":
                if (timeSlotId != null) {
                    for (String id : timeSlotId) {
                        dao.addSchedule(idAccount, Integer.parseInt(id), day);

                    }
                }
                break;
            case "Friday":
                if (timeSlotId != null) {
                    for (String id : timeSlotId) {
                        dao.addSchedule(idAccount, Integer.parseInt(id), day);

                    }
                }
                break;
            case "Saturday":
                if (timeSlotId != null) {
                    for (String id : timeSlotId) {
                        dao.addSchedule(idAccount, Integer.parseInt(id), day);

                    }
                }
                break;
            case "Sunday":
                if (timeSlotId != null) {
                    for (String id : timeSlotId) {
                        dao.addSchedule(idAccount, Integer.parseInt(id), day);

                    }
                }

                break;
            default:

        }
        request.getRequestDispatcher("Succesfull.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
