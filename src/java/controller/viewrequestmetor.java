/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import dal.HandleRequestDAO;
import dal.HistoryPayDAO;
import dal.RequestDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.Account;
import model.HistoryWallet;
import model.Request;
import model.Wallet;

/**
 *
 * @author trang
 */
@WebServlet(name = "viewrequestmetor", urlPatterns = {"/reqmentor"})
public class viewrequestmetor extends HttpServlet {

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
            out.println("<title>Servlet viewrequestmetor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet viewrequestmetor at " + request.getContextPath() + "</h1>");
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
        Account account = (Account) request.getSession().getAttribute("account");
        if (account != null && "Mentor".equals(account.getRole())) {
            int mentorId = account.getId();
            HandleRequestDAO handleRequestDao = new HandleRequestDAO();
            int processing = 1;
            int accept = 2;
            int reject = 3;
            int numPerPage = 6;
            // processing
            ArrayList<Request> listRequestProcessing = handleRequestDao.getAllRequestNeedHandle(mentorId, processing);
            int numPsRP = listRequestProcessing.size();
            if (numPsRP != 0) {
                int numpageRP = numPsRP / numPerPage + (numPsRP % numPerPage == 0 ? 0 : 1);
                int startRP, endRP;
                String tpageRP = request.getParameter("pageRP");
                int pageRP;
                try {
                    pageRP = Integer.parseInt(tpageRP);
                } catch (NumberFormatException e) {
                    pageRP = 1;
                }
                startRP = (pageRP - 1) * numPerPage;
                if (pageRP * numPerPage > numPsRP) {
                    endRP = numPsRP;
                } else {
                    endRP = pageRP * numPerPage;
                }
                ArrayList<Request> arrRP = handleRequestDao.getListByPage((ArrayList<Request>) listRequestProcessing, startRP, endRP);
                request.setAttribute("dataRP", arrRP);
                request.setAttribute("numRP", numpageRP);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            // accept
            ArrayList<Request> listRequestAccept = handleRequestDao.getAllRequestNeedHandle(mentorId, accept);
            int numPsRA = listRequestAccept.size();
            if (numPsRA != 0) {
                int numpageRA = numPsRA / numPerPage + (numPsRA % numPerPage == 0 ? 0 : 1);
                int startRA, endRA;
                String tpageRA = request.getParameter("pageRA");
                int pageRA;
                try {
                    pageRA = Integer.parseInt(tpageRA);
                } catch (NumberFormatException e) {
                    pageRA = 1;
                }
                startRA = (pageRA - 1) * numPerPage;
                if (pageRA * numPerPage > numPsRA) {
                    endRA = numPsRA;
                } else {
                    endRA = pageRA * numPerPage;
                }
                ArrayList<Request> arrRA = handleRequestDao.getListByPage((ArrayList<Request>) listRequestAccept, startRA, endRA);
                request.setAttribute("dataRA", arrRA);
                request.setAttribute("numRA", numpageRA);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            // Reject
            ArrayList<Request> listRequestReject = handleRequestDao.getAllRequestNeedHandle(mentorId, reject);
            int numPsRR = listRequestReject.size();
            if (numPsRR != 0) {
                int numpageRR = numPsRR / numPerPage + (numPsRR % numPerPage == 0 ? 0 : 1);
                int startRR, endRR;
                String tpageRR = request.getParameter("pageRR");
                int pageRR;
                try {
                    pageRR = Integer.parseInt(tpageRR);
                } catch (NumberFormatException e) {
                    pageRR = 1;
                }
                startRR = (pageRR - 1) * numPerPage;
                if (pageRR * numPerPage > numPsRR) {
                    endRR = numPsRR;
                } else {
                    endRR = pageRR * numPerPage;
                }
                ArrayList<Request> arrRR = handleRequestDao.getListByPage((ArrayList<Request>) listRequestReject, startRR, endRR);
                request.setAttribute("dataRR", arrRR);
                request.setAttribute("numRR", numpageRR);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            int paid = 12;
            ArrayList<Request> listRequestPaid = handleRequestDao.getAllRequestNeedHandle(mentorId, paid);
            int numPsRPa = listRequestPaid.size();
            if (numPsRPa != 0) {
                int numpageRPa = numPsRPa / numPerPage + (numPsRPa % numPerPage == 0 ? 0 : 1);
                int startRPa, endRPa;
                String tpageRPa = request.getParameter("pageRPa");
                int pageRPa;
                try {
                    pageRPa = Integer.parseInt(tpageRPa);
                } catch (NumberFormatException e) {
                    pageRPa = 1;
                }
                startRPa = (pageRPa - 1) * numPerPage;
                if (pageRPa * numPerPage > numPsRPa) {
                    endRPa = numPsRPa;
                } else {
                    endRPa = pageRPa * numPerPage;
                }
                ArrayList<Request> arrRPa = handleRequestDao.getListByPage((ArrayList<Request>) listRequestPaid, startRPa, endRPa);
                request.setAttribute("dataRPa", arrRPa);
                request.setAttribute("numRPa", numpageRPa);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }

            request.getRequestDispatcher("Mentor/ManagerScheduleRequest.jsp").forward(request, response);
        } else {
            String errorMessage = "You do not have permission to access this page.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("Mentor/ManagerScheduleRequest.jsp").forward(request, response);
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
        int idRequest = Integer.parseInt(request.getParameter("idRequest"));
        int statusId = Integer.parseInt(request.getParameter("statusId"));
        String reasonReject = request.getParameter("reasonReject");
        HandleRequestDAO handleRequestDao = new HandleRequestDAO();
        Request r = handleRequestDao.getRequestById(idRequest);
        HistoryPayDAO hd = new HistoryPayDAO();
        if (statusId == 2) {
            int idMentee = r.getIdMentee();
            int idManager = 14;
            WalletDAO walletDAO = new WalletDAO();
            int totalCost = walletDAO.getTotalCostOfARequest(r);
            Wallet walletMentee = walletDAO.getWalletByIdAccount(idMentee);
            walletMentee.setAmount(walletMentee.getAmount() - totalCost);
            walletMentee.setHold(walletMentee.getHold() - totalCost);
            walletDAO.updateWallet(walletMentee);
            //
            Timestamp createdAt = new Timestamp(new Date().getTime());
            //them history bank cho mentee
            HistoryWallet hw = new HistoryWallet();
            hw.setIdAccount(idMentee);
            hw.setAmount(totalCost);
            hw.setContent("Pay for course :" + r.getSkill().getSkillName());
            hw.setDatePay(String.valueOf(createdAt));
            hw.setNameMentee("Manager");
            hw.setStype("Payment");
            hd.addHistoryPay(hw);
            //them history bank cho manager
            Wallet walletManager = walletDAO.getWalletByIdAccount(idManager);
            walletManager.setAmount(walletManager.getAmount() + totalCost);
            walletDAO.updateWallet(walletManager);
            HistoryWallet hm = new HistoryWallet();
            hm.setIdAccount(idManager);
            hm.setAmount(totalCost);
            hm.setContent("Pay for course :" + r.getSkill().getSkillName());
            hm.setDatePay(String.valueOf(createdAt));
            hm.setNameMentee(r.getMentee().getFullname());
            hm.setStype("Deposit");
            hd.addHistoryPay(hm);
        }
        if (statusId == 3){
            int idMentee = r.getIdMentee();
            WalletDAO walletDAO = new WalletDAO();
            int totalCost = walletDAO.getTotalCostOfARequest(r);
            Wallet walletMentee = walletDAO.getWalletByIdAccount(idMentee);
            walletMentee.setHold(walletMentee.getHold() - totalCost);
            walletDAO.updateWallet(walletMentee);
        }
        handleRequestDao.updateStatusRequest(idRequest, statusId, reasonReject);
        response.sendRedirect("reqmentor");
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
