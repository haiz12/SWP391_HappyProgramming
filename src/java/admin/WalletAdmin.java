/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import dal.DAO;
import dal.HistoryPayDAO;
import dal.TakeMoneyDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Account;
import model.GetMoney;
import model.HistoryWallet;
import model.Wallet;

/**
 *
 * @author Admin
 */
@WebServlet(name = "WalletAdmin", urlPatterns = {"/walletAdmin"})
public class WalletAdmin extends HttpServlet {

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
            out.println("<title>Servlet WalletAdmin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet WalletAdmin at " + request.getContextPath() + "</h1>");
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
        WalletDAO walletDAO = new WalletDAO();
        TakeMoneyDAO takeMoneyDAO = new TakeMoneyDAO();
        DAO dao = new DAO();
        HistoryPayDAO historyDAO=new HistoryPayDAO();

        String action = request.getParameter("action");
        int idTakeMoney = Integer.parseInt(request.getParameter("id"));
        GetMoney takeMoney = takeMoneyDAO.getTakeMoneyById(idTakeMoney);
        Account a = dao.getAccountByUsername(takeMoney.getUsername());
        
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String datePay = currentDateTime.format(formatter);
        
        if (action.equals("accept")) {
            int ManagerId = 14;
            Wallet wallet = walletDAO.getWalletByIdAccount(ManagerId);
            wallet.setAmount(wallet.getAmount() - takeMoney.getMoney());
            walletDAO.updateWallet(wallet);
            takeMoneyDAO.deleteTakeMoney(idTakeMoney);
            //history of mentor
            historyDAO.addHistoryPay(new HistoryWallet(0, a.getId(), takeMoney.getMoney(), "NULL", datePay, "Rút tiền về tài khoản ngân hàng", "Payment"));
            //history of system
            historyDAO.addHistoryPay(new HistoryWallet(0, 14,  takeMoney.getMoney(),"NULL", datePay, "Thanh toán cho "+a.getUser(), "Payment"));
        } else if (action.equals("reject")) {
            Wallet wallet = walletDAO.getWalletByIdAccount(a.getId());
            wallet.setAmount(wallet.getAmount() + takeMoney.getMoney());
            walletDAO.updateWallet(wallet);
            takeMoneyDAO.deleteTakeMoney(idTakeMoney);
        }
        
        response.sendRedirect("admin");
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
        processRequest(request, response);
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
