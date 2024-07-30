/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import Helper.HmacSHA256;
import VNPay.Config;
import com.google.gson.Gson;
import dal.RequestDAO;
import dto.PaymentDTO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Request;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author admin
 */
@WebServlet(name = "Payment", urlPatterns = {"/payment"})
public class Payment extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        if (account.getRole().equals("Mentee")) {
            request.getRequestDispatcher("view/payment.jsp").forward(request, response);
            return;
        }
        String requestIdStr = request.getParameter("idrequest");
        RequestDAO requestDAO = new RequestDAO();
        Request r = requestDAO.getRequestById(Integer.parseInt(requestIdStr));
        request.setAttribute("amount", r.getTotalCost());
//        request.setAttribute("amount",amount);
        request.getRequestDispatcher("view/payment.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Account account = (Account) request.getSession().getAttribute("account");
        String amount = request.getParameter("amount");
        if (account.getRole().equals("Mentee")) {
            // URL của API bạn muốn gọi
            String apiUrl = "https://api-merchant.payos.vn/v2/payment-requests";
            Gson gson = new Gson();
            // Tạo một đối tượng HttpClient
            HttpClient client = HttpClientBuilder.create().build();

            // Tạo yêu cầu POST
            HttpPost postRequest = new HttpPost(apiUrl);

            // Thêm header parameters
            postRequest.addHeader("x-client-id", "03cdd541-c19d-467f-8262-b0120cf89894");
            postRequest.addHeader("x-api-key", "fba4f4bb-b46a-4d5d-8f38-77747f91f1b9");
            postRequest.addHeader("Content-Type", "application/json");
            Map<String, Object> params = new HashMap<>();
            // Tạo requestBody (dưới đây là ví dụ với JSON)
            JSONObject requestBody = new JSONObject();
            int orderCode = (int) (Math.random() * 1000 + 1);
            try {
                LocalDateTime dateTime = LocalDateTime.now().plus(1, ChronoUnit.DAYS);
                ZonedDateTime zonedDateTime = dateTime.atZone(ZoneId.systemDefault());
                Instant instant = zonedDateTime.toInstant();

                // Lấy số giây kể từ epoch và ép kiểu thành int32
                int unixTimestamp = (int) instant.getEpochSecond();
                String description = Config.getRandomNumber(8);
                requestBody.put("orderCode", orderCode);
                requestBody.put("description", description);
                requestBody.put("cancelUrl", "http://localhost:9999/Happy_v1/cancel-payment");
                requestBody.put("returnUrl", "http://localhost:9999/Happy_v1/success-payment");
                requestBody.put("amount", Integer.parseInt(amount));
                requestBody.put("expiredAt", unixTimestamp);
                params.put("amount", amount);
                params.put("cancelUrl", "http://localhost:9999/Happy_v1/cancel-payment");
                params.put("description", description);
                params.put("orderCode", orderCode);
                params.put("returnUrl", "http://localhost:9999/Happy_v1/success-payment");
                String json = gson.toJson(params);
                requestBody.put("signature", HmacSHA256.generate(json));
            } catch (JSONException ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Payment.class.getName()).log(Level.SEVERE, null, ex);
            }
            // Đặt requestBody vào yêu cầu POST
            StringEntity entity = new StringEntity(requestBody.toString());
            postRequest.setEntity(entity);

            // Thực hiện yêu cầu và nhận phản hồi
            HttpResponse apiResponse = client.execute(postRequest);

            // Lấy nội dung từ phản hồi
            HttpEntity responseEntity = apiResponse.getEntity();
            String responseBody = EntityUtils.toString(responseEntity);

            PaymentDTO paymentDTO = gson.fromJson(responseBody, PaymentDTO.class);
            request.getSession().setAttribute("link", paymentDTO.getData().getCheckoutUrl());
            request.getSession().setAttribute(String.valueOf(account.getId()),orderCode);
            request.getRequestDispatcher("view/payment.jsp").forward(request, response);
        }
    }

}
