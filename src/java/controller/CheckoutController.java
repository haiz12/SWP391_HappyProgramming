/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import dal.HistoryPayDAO;
import dal.MenteeDAO;
import dal.WalletDAO;
import dto.PaymentDTO;
import dto.PaymentVietqrResp;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Account;
import model.HistoryWallet;
import model.Wallet;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author admin
 */
public class CheckoutController extends HttpServlet {

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
        Account account = (Account) request.getSession().getAttribute("account");
        int orderCode = (int) request.getSession().getAttribute(String.valueOf(account.getId()));
        String apiUrl = "https://api-merchant.payos.vn/v2/payment-requests/" + orderCode;
        Gson gson = new Gson();
        // Tạo một đối tượng HttpClient
        HttpClient client = HttpClientBuilder.create().build();

        // Tạo yêu cầu POST
        HttpGet postRequest = new HttpGet(apiUrl);

        // Thêm header parameters
        postRequest.addHeader("x-client-id", "03cdd541-c19d-467f-8262-b0120cf89894");
        postRequest.addHeader("x-api-key", "fba4f4bb-b46a-4d5d-8f38-77747f91f1b9");
        postRequest.addHeader("Content-Type", "application/json");

        HttpResponse apiResponse = client.execute(postRequest);

        // Lấy nội dung từ phản hồi
        HttpEntity responseEntity = apiResponse.getEntity();
        String responseBody = EntityUtils.toString(responseEntity);
        PaymentVietqrResp resp = gson.fromJson(responseBody, PaymentVietqrResp.class);
        if (resp.getData().getStatus().equals("PAID")) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String datePay = currentDateTime.format(formatter);
            WalletDAO walletDAO = new WalletDAO();
            HistoryPayDAO historyPayDAO = new HistoryPayDAO();
            Wallet wallet = walletDAO.getWalletByIdAccount(account.getId());
            wallet.setAmount(wallet.getAmount() + Integer.parseInt(resp.getData().getAmountPaid()));
            walletDAO.updateWallet(wallet);
            HistoryWallet historyWallet = new HistoryWallet();
            historyWallet.setIdAccount(account.getId());
            historyWallet.setContent("Thanh toán sau khóa học");
            historyWallet.setNameMentee(account.getUser());
            historyWallet.setStype("Payment");
            historyWallet.setDatePay(datePay);
            historyWallet.setAmount(Integer.parseInt(resp.getData().getAmountPaid()));
            historyPayDAO.addHistoryPay(historyWallet);
        } else {
            response.sendRedirect("error.jsp");
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
        processRequest(request, response);
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
