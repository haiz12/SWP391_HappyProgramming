/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import admin.AdminDAO;
import dal.DAO;
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
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Account;
import model.News;

/**
 *
 * @author trang
 */
@WebServlet(name = "updatenews", urlPatterns = {"/updatenews"})
@MultipartConfig
public class updatenews extends HttpServlet {

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
            out.println("<title>Servlet updatenews</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatenews at " + request.getContextPath() + "</h1>");
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
        int newsID = Integer.parseInt(request.getParameter("newsID")); // Giả sử newsID được truyền qua parameter

        // Gọi DAO để lấy thông tin tin tức từ cơ sở dữ liệu
        AdminDAO admin = new AdminDAO();
        News news = admin.getNewsById(newsID);

        // Đưa thông tin tin tức vào request để hiển thị trên trang cập nhật tin tức
        request.setAttribute("news", news);

        // Forward sang trang cập nhật tin tức
        request.getRequestDispatcher("Admin/updatenews.jsp").forward(request, response);
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
        int newsID = Integer.parseInt(request.getParameter("newsID"));
        String title = request.getParameter("blogtitle");
        String summary = request.getParameter("Summary");
        int eventDay = Integer.parseInt(request.getParameter("ndays"));
        String eventMonth = request.getParameter("nmonth");
        int eventYear = Integer.parseInt(request.getParameter("nyear"));
        String content = request.getParameter("content");

        // Lấy ngày hiện tại
        Date currentDate = new Date();
        // Chuyển đổi ngày hiện tại thành định dạng "yyyy-MM-dd"
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String postdate = dateFormat.format(currentDate);

        // In ra các giá trị
        System.out.println("newsID: " + newsID);
        System.out.println("title: " + title);
        System.out.println("summary: " + summary);
        System.out.println("eventDay: " + eventDay);
        System.out.println("eventMonth: " + eventMonth);
        System.out.println("eventYear: " + eventYear);
        System.out.println("content: " + content);
        System.out.println("postdate: " + postdate);

// Xử lý upload hình ảnh nếu có
        String imageURL = "";

        Part filePart = request.getPart("coverimage");
        if (filePart != null && filePart.getSize() > 0) {
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadDir = getServletContext().getRealPath("/img");

            // Kiểm tra xem file đã tồn tại chưa trước khi ghi đè
            Path imagePath = Paths.get(uploadDir, fileName);
            if (!Files.exists(imagePath)) {
                // Lưu hình ảnh vào thư mục images trên server
                try ( InputStream fileInput = filePart.getInputStream()) {
                    Files.copy(fileInput, imagePath);
                }
            } else {

            }

            imageURL = "img/" + fileName;
        }

// Cập nhật tin tức trong cơ sở dữ liệu
        AdminDAO admin = new AdminDAO();

        boolean result = false;
        try {
            result = admin.updateNews(newsID, title, content, imageURL, postdate, eventDay, eventMonth, eventYear, summary);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;// Log the exception
        }

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
// Chuyển hướng sau khi thêm tin tức
        if (a.getRole().equals("Maketer")) {
            response.sendRedirect("maketer");
        } else if (a.getRole().equals("Manager")) {
            response.sendRedirect("admin");
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
