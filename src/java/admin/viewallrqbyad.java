/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Account;
import model.Adshowreq;

/**
 *
 * @author trang
 */
@WebServlet(name = "viewallrqbyad", urlPatterns = {"/viewall"})
public class viewallrqbyad extends HttpServlet {

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
            out.println("<title>Servlet viewallrqbyad</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet viewallrqbyad at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   private boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");

        return account != null && account.getRole().equals("Admin");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        if (!isAdmin(request)) {
//            response.sendRedirect("home.jsp");
//            return;
//        }

        int page = 1; // Số trang mặc định
        int recordsPerPage = 6; // Số bản ghi hiển thị trên mỗi trang

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        AdminDAO dao = new AdminDAO();
        List<Adshowreq> listRequest;
        String searchTerm = request.getParameter("searchTerm");

        if (searchTerm != null && !searchTerm.isEmpty()) {
            // Tìm kiếm theo từ khóa và lấy toàn bộ kết quả
            listRequest = dao.searchAdshowreq(searchTerm);
        } else {
            // Lấy toàn bộ danh sách nếu không có từ khóa tìm kiếm
            listRequest = dao.getAllAdshowreq();
        }

        // Tính tổng số trang
        int totalRecords = listRequest.size();
        int totalPages = (totalRecords + recordsPerPage - 1) / recordsPerPage;

        // Tính chỉ số bắt đầu và kết thúc của danh sách hiện tại
        int startIdx = (page - 1) * recordsPerPage;
        int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);

        // Trích xuất danh sách hiện tại để hiển thị trên trang
        List<Adshowreq> currentList = listRequest.subList(startIdx, endIdx);

        List<String> statusList = dao.getAllDistinctStatus();

        // Đặt các thuộc tính cần thiết cho trang JSP
        request.setAttribute("statusList", statusList);
        request.setAttribute("listRequest", currentList);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);
        request.setAttribute("searchTerm", searchTerm); // Truyền lại từ khóa tìm kiếm để hiển thị trên trang

        System.out.println("Forwarding to viewadmin.jsp with page: " + page);

        request.getRequestDispatcher("Admin/viewadmin.jsp?page=" + page).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       AdminDAO dao = new AdminDAO();

        String[] selectedStatusArray = request.getParameterValues("selectedStatusArray");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        List<String> selectedStatusList = new ArrayList<>();

        if (selectedStatusArray != null) {
            selectedStatusList = Arrays.asList(selectedStatusArray);
        }

        if (startDate == null || startDate.isEmpty()) {
            startDate = null;
        }
        if (endDate == null || endDate.isEmpty()) {
            endDate = null;
        }

        List<Adshowreq> adshowreqList;

        if (selectedStatusList.isEmpty() && (startDate == null || endDate == null)) {
            adshowreqList = dao.getAllAdshowreq();
        } else if (selectedStatusList.isEmpty() && startDate != null && endDate != null) {
            adshowreqList = dao.checkdate(startDate, endDate);
        } else {
            adshowreqList = dao.getMulStatus(selectedStatusList, startDate, endDate);
        }

        // Tính tổng số trang dựa trên kết quả tìm kiếm
        int totalRecords = adshowreqList.size();
        int recordsPerPage = 6; // Số bản ghi hiển thị trên mỗi trang
        int totalPages = (totalRecords + recordsPerPage - 1) / recordsPerPage;

        // Trang mặc định sẽ là trang đầu tiên
        int page = 1;

        // Lấy số trang nếu được chọn từ yêu cầu POST
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        // Tính chỉ số bắt đầu và kết thúc của danh sách hiện tại
        int startIdx = (page - 1) * recordsPerPage;
        int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);

        // Trích xuất danh sách hiện tại để hiển thị trên trang
        List<Adshowreq> currentList = adshowreqList.subList(startIdx, endIdx);

        List<String> statusList = dao.getAllDistinctStatus();
       
        request.setAttribute("statusList", statusList);
        request.setAttribute("listRequest", currentList);
        request.setAttribute("s", selectedStatusArray);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", page);

        request.getRequestDispatcher("Admin/viewadmin.jsp").forward(request, response);
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
