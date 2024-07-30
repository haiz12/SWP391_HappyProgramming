/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package VNPay;

import dal.HandleRequestDAO;
import dal.HistoryPayDAO;
import dal.RequestDAO;
import dal.WalletDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import model.Account;
import model.HistoryWallet;
import model.Mentee;
import model.Request;
import model.Wallet;

/**
 *
 * @author admin
 */
@WebServlet(name = "VNPResponeController", urlPatterns = {"/vnpayresponse"})
public class VNPResponeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Account account = (Account) session.getAttribute("account");
        try {
            String amount_raw = request.getParameter("amount");
            if (amount_raw != null) {
                long amount = Long.parseLong(amount_raw);
                amount /= 100;
                WalletDAO walletDAO = new WalletDAO();
                HandleRequestDAO hrd = new HandleRequestDAO();
                Mentee mentee = hrd.getMenteeById(account.getId());
                HistoryPayDAO hd = new HistoryPayDAO();
                Wallet wallet = walletDAO.getWalletByIdAccount(account.getId());
                wallet.setAmount((int) (wallet.getAmount() + amount));
                boolean walletUpdate = walletDAO.updateWallet(wallet);

                Timestamp createdAt = new Timestamp(new Date().getTime());
                //them history bank cho mentee
                HistoryWallet hw = new HistoryWallet();
                hw.setIdAccount(account.getId());
                hw.setAmount((int) amount);
                hw.setContent("Top up to wallet");
                hw.setDatePay(String.valueOf(createdAt));
                hw.setNameMentee(mentee.getFullname());
                hw.setStype("Recharge");
                hd.addHistoryPay(hw);
                response.sendRedirect("home");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }

        //request.getRequestDispatcher("view/listallreq.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
