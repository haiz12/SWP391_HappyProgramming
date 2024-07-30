/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import CheckDb.Checkdb;
import dal.DAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Timer;
import java.util.TimerTask;
import model.Account;

@WebServlet(name = "ResetPasswordController", urlPatterns = {"/reset-password"})
public class ResetPasswordController extends HttpServlet {

    private static String newPassword;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Account/resetpassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accountname = request.getParameter("accountname");
        String emailaddress = request.getParameter("emailaddress");
        Checkdb check = new Checkdb();
        try {
            Account account = check.isExistResetPassword(accountname, emailaddress);
            // check in db
            if (account == null) {
                request.setAttribute("message", "not found");
            } else {
                String oldPassword = account.getPass();
                // generate password
                newPassword = generatePassword(8);

                // send mail
                request.setAttribute("response", sendEmail(emailaddress, "Reset password", "The password is available in 5 minutes. Your new password: " + newPassword));

                // update db
                new DAO().updatePassword(account.getId(), newPassword);

                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        new DAO().updatePassword(account.getId(), oldPassword); // dat lai mk sau 5 phút
                        System.out.println("password expired.");
                        timer.cancel(); // Hủy Timer sau khi hủy OTP
                    }
                }, 5 * 60 * 1000); // 5 phút (5 * 60 * 1000 mili giây)

                request.setAttribute("message", "ok");
            }
            request.getRequestDispatcher("Account/resetpassword.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("message", "Error");
            request.getRequestDispatcher("Account/resetpassword.jsp").forward(request, response);
            System.out.println(e.getMessage());
        }

    }

    public boolean sendEmail(String to, String subject, String text) {
        // URL to which the request will be sent
        String url = "https://mail-sender-service.vercel.app/send-email";

        try {
            // Create a URL object
            URL apiUrl = new URL(url);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();

            // Set the request method
            connection.setRequestMethod("POST");

            // Enable input/output streams
            connection.setDoOutput(true);

            // Set the content type
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            // Prepare the request payload
            String payload = "{\"to\":\"" + to + "\",\"subject\":\"" + subject + "\",\"text\":\"" + text + "\"}";

            // Write the payload to the output stream
            try ( OutputStream os = connection.getOutputStream()) {
                byte[] input = payload.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Close the connection
            connection.disconnect();

            return responseCode == 200;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String generatePassword(int length) {
        // Define characters to use in the password (lowercase letters and digits)
        String characters = "abcdefghijklmnopqrstuvwxyz0123456789";

        // Use SecureRandom for better randomness
        SecureRandom random = new SecureRandom();

        // Build the password by randomly selecting characters from the defined set
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }

}
