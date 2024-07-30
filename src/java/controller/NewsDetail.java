/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.News;

/**
 *
 * @author trang
 */
@WebServlet(name = "NewsDetail", urlPatterns = {"/newsdetail"})
public class NewsDetail extends HttpServlet {

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
            out.println("<title>Servlet NewsDetail</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NewsDetail at " + request.getContextPath() + "</h1>");
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
        DAO dao = new DAO();
        // Lấy newsid từ tham số yêu cầu
        String newsId = request.getParameter("newsid");
        System.out.println("newsid Request từ tham số: " + newsId);

        // Kiểm tra xem newsid có tồn tại và không rỗng không
        if (newsId != null && !newsId.isEmpty()) {
            try {
                // Lấy chi tiết yêu cầu cụ thể dựa trên newsId
                News news = dao.getNewsById(Integer.parseInt(newsId));

                // Nếu chi tiết yêu cầu tồn tại, đặt nó làm thuộc tính trong yêu cầu
                if (newsId!= null) {
                    request.setAttribute("news", news);
                    System.out.println("Chi tiết yêu cầu được đặt làm thuộc tính của yêu cầu.");

                    // Chuyển tiếp yêu cầu đến trang JSP
                    System.out.println("Chuyển tiếp yêu cầu đến newsdetail.jsp.");
                    request.getRequestDispatcher("newsdetail.jsp").forward(request, response);
                    return; // Dừng việc thực thi servlet tiếp theo
                } else {
                    // Xử lý trường hợp không tìm thấy chi tiết yêu cầu
                    response.getWriter().println("Không tìm thấy chi tiết yêu cầu");
                    System.out.println("Không tìm thấy chi tiết yêu cầu.");
                }
            } catch (NumberFormatException e) {
                // Xử lý trường hợp newsId không phải là số nguyên hợp lệ
                response.getWriter().println("Định dạng newsId không hợp lệ");
                System.out.println("Định dạng newsId không hợp lệ.");
            }
        } else {
            // Xử lý trường hợp newsId không được cung cấp hoặc không hợp lệ
            response.getWriter().println("Thiếu newsId");
            System.out.println("Thiếu newsId.");
        }
        request.getRequestDispatcher("newsdetail.jsp").forward(request, response);
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
     * @return a String containing servlet description
     */
    @Override
public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
