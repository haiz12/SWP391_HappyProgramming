/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Mentor;

import dal.DAO;
import dal.HistoryPayDAO;
import dal.MentorDAO;
import dal.TakeMoneyDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Account;
import model.GetMoney;
import model.HistoryWallet;
import model.Mentor;
import model.Wallet;

/**
 *
 * @author Admin
 */
@WebServlet(name = "TakeMoney", urlPatterns = {"/takeMoney"})
public class TakeMoney extends HttpServlet {

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
            out.println("<title>Servlet TakeMoney</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TakeMoney at " + request.getContextPath() + "</h1>");
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
        HistoryPayDAO historyDAO = new HistoryPayDAO();
        WalletDAO walletDAO = new WalletDAO();

        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        request.setAttribute("idAccount", idAccount);
        List<HistoryWallet> listHistoryWallet = historyDAO.getHistoryWalletByIdAccount(idAccount);
        request.setAttribute("historyWallet", listHistoryWallet);
        int totalIncome = walletDAO.totalIncome(idAccount);
        request.setAttribute("totalIncome", totalIncome);
        int walletBalance = walletDAO.getWalletBalance(idAccount);
        request.setAttribute("walletBalance", walletBalance);
        request.getRequestDispatcher("Mentor/Wallet.jsp").forward(request, response);
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
        TakeMoneyDAO moneyDAO = new TakeMoneyDAO();
        MentorDAO mentorDAO = new MentorDAO();
        DAO dao = new DAO();

        int idAccount = Integer.parseInt(request.getParameter("idAccount"));
        String username = dao.getUserNameById(idAccount);
        Mentor mentor = mentorDAO.getIDMentor(idAccount);
        int money = Integer.parseInt(request.getParameter("money"));

        HistoryPayDAO historyDAO = new HistoryPayDAO();
        WalletDAO walletDAO = new WalletDAO();

        request.setAttribute("idAccount", idAccount);
        List<HistoryWallet> listHistoryWallet = historyDAO.getHistoryWalletByIdAccount(idAccount);
        request.setAttribute("historyWallet", listHistoryWallet);
        int totalIncome = walletDAO.totalIncome(idAccount);
        request.setAttribute("totalIncome", totalIncome);
        int walletBalance = walletDAO.getWalletBalance(idAccount);

        GetMoney getmoney = new GetMoney(0, mentor.getFullname(), username, money);
        String mess;
        Wallet wallet = new Wallet();
        if (money <= walletBalance) {
            if (moneyDAO.addTakeMoney(getmoney)) {
                mess = "ok";
                wallet.setAmount(wallet.getAmount() - money);
                walletDAO.updateWallet(wallet);
            } else {
                mess = "ko";
            }
        } else {
            mess = "ko";
        }
        request.setAttribute("mess", mess);
        request.setAttribute("walletBalance", walletBalance);
        request.getRequestDispatcher("Mentor/Wallet.jsp").forward(request, response);
//        request.getRequestDispatcher("Mentor/Wallet.jsp").forward(request, response);
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
