/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Mentee;

import dal.MentorDAO;
import dal.MenteeRequestDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.Request;
import model.ScheduleRequest;
import model.TimeSchedule;
import model.Time_Slot;
import model.Wallet;

/**
 *
 * @author admin
 */
public class MenteeRequest extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MenteeRequest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MenteeRequest at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        int idMentor = Integer.parseInt(request.getParameter("idMentor"));
        MenteeRequestDAO srDao = new MenteeRequestDAO();
        MentorDAO mDao = new MentorDAO();
        ArrayList<Time_Slot> listTS = srDao.getAllSlot();
        ArrayList<TimeSchedule> listATR = srDao.getFreeScheduleOfMentor(idMentor);
        ArrayList<TimeSchedule> listTR = srDao.getFreeScheduleOfMentorIn1Week(idMentor);
        String[] schedule = new String[listTR.size()];
        int i = 0;
        for (TimeSchedule ts : listTR) {
            String sc = ts.getDay() + "-" + ts.getSlotId();
            schedule[i] = sc;
            i++;
        }
        Set<Integer> weeks = new TreeSet<>();
        for (TimeSchedule ts : listATR) {
            weeks.add(ts.getWeek());
        }
        ArrayList<Have_SKill> listHS = srDao.getListSkillOfMentor(idMentor);
        Mentor mentor = mDao.getIDMentor(idMentor);
        request.setAttribute("listTR", listTR);
        request.setAttribute("listHS", listHS);
        request.setAttribute("mentor", mentor);
        request.setAttribute("listTS", listTS);
        request.setAttribute("schedule", schedule);
        request.setAttribute("weeks", weeks);
        String mess = (String) session.getAttribute("mess");
        if (mess != null && !mess.isEmpty()) {
            request.setAttribute("mess", mess);
        }
        Integer amount =  (Integer) session.getAttribute("amountPay");
        if (amount != null) {
            request.setAttribute("amount", amount);
        }
        out.print("hiiii");
        request.getRequestDispatcher("Mentee/menteeRequest.jsp").forward(request, response);
        if (mess != null && !mess.isEmpty()) {
            session.removeAttribute("mess");
        }
        if (amount != null) {
            session.removeAttribute("amount");
        }
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
        PrintWriter out = response.getWriter();

        Map<String, String[]> parameters = request.getParameterMap();
        MentorDAO dao = new MentorDAO();
        MenteeRequestDAO srDao = new MenteeRequestDAO();
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        int idMentee = dao.getAccountByid(account.getId()).getId();
        int idMentor = Integer.parseInt(request.getParameter("idMentor"));
        ArrayList<TimeSchedule> listRegisteredTimeScheduleOfMentor = srDao.getRegisteredTimeScheduleOfMentor(idMentor);
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int skillId = Integer.parseInt(request.getParameter("skillId"));
        int startWeek = Integer.parseInt(request.getParameter("startWeek"));
        int endWeek = Integer.parseInt(request.getParameter("endWeek"));
        float hour = 2;
        float cost = Float.parseFloat(request.getParameter("cost"));
        int year = Integer.parseInt(request.getParameter("year"));
        int statusId = Integer.parseInt(request.getParameter("statusId"));
        String[] schedules = parameters.get("schedule");
        //
        int numberOfSlotInAWeek = schedules.length;
        int totalCost = (int) (cost * hour * numberOfSlotInAWeek * (endWeek - startWeek + 1));
        WalletDAO wd = new WalletDAO();
        Wallet wallet = wd.getWalletByIdAccount(account.getId());
        int hold = wallet.getHold();
        int balance = wallet.getAmount();
        int holdFuture = hold + totalCost;
        //
        if (holdFuture <= balance) {
            wallet.setHold(holdFuture);
            wd.updateWallet(wallet);
            for (String schedule : schedules) {
                String[] parts = schedule.split("-");
                if (parts.length == 2) {
                    String day = parts[0];
                    int slotId = Integer.parseInt(parts[1]);
                    for (int week = startWeek; week <= endWeek; week++) {
                        TimeSchedule ts = srDao.getTimeScheduleByInformation(year, week, day, slotId);
                        if (ts != null) {

                            if (srDao.checkRegisteredTimeScheduleOfMentor(listRegisteredTimeScheduleOfMentor, ts)) {
                                String messenger = "The schedule has already been registered";
                                request.setAttribute("mess", messenger);
                                request.getRequestDispatcher("Mentee/menteeRequest.jsp").forward(request, response);
                            } else {
                                Request r = new Request();
                                r.setIdMentee(idMentee);
                                r.setIdMentor(idMentor);
                                r.setTitle(title);
                                r.setContent(content);
                                r.setSkillId(skillId);
                                r.setStatusId(statusId);
                                r.setTimeScheduleId(ts.getTimeScheduleId());
                                r.setStartWeek(startWeek);
                                r.setEndWeek(endWeek);
                                r.setHour(hour);
                                r.setTotalCost((int) (cost * r.getHour()));
                                srDao.addMenteeRequest(r);
                            }
                        }
                    }
                }
            }
            request.getRequestDispatcher("Succesfull.jsp").forward(request, response);
        } else {
            String mess = "You need to deposit an additional " + (holdFuture - balance) + " VND to pay for the course.";
            session.setAttribute("mess", mess);
            session.setAttribute("amountPay", holdFuture - balance);
            response.sendRedirect("menteeRequest?idMentor=" + idMentor);
        }
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
