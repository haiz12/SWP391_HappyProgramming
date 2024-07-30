package admin;

import admin.AdminDAO;
import dal.DAO;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.Account;

import model.News;

@WebServlet(name = "addnews", urlPatterns = {"/addnews"})
@MultipartConfig
public class addnews extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Xử lý yêu cầu GET ở đây
        // Ví dụ: Hiển thị một trang để thêm tin tức mới
        request.getRequestDispatcher("Admin/createnews.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("blogtitle");
        String summary = request.getParameter("Summary");
        String dayParam = request.getParameter("ndays");
        String month = request.getParameter("nmonth");
        String yearParam = request.getParameter("nyear");
        Part filePart = request.getPart("coverimage");
        String content = request.getParameter("content");

        // Kiểm tra xem các tham số nhận được có null không
        if (title != null && summary != null && dayParam != null && month != null && yearParam != null && filePart != null && content != null) {
            // Chuyển các tham số sang dạng số nếu có thể
            int day = Integer.parseInt(dayParam);
            int year = Integer.parseInt(yearParam);

            // Lấy ngày hiện tại
            Date currentDate = new Date();
            // Chuyển đổi ngày hiện tại thành định dạng "yyyy-MM-dd"
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String postdate = dateFormat.format(currentDate);

            // Xử lý file ảnh
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
            String uploadPath = getServletContext().getRealPath("/img");
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }
            File existingFile = new File(uploadDir, fileName);
            if (existingFile.exists()) {
                existingFile.delete();
            }
            try ( InputStream fileInput = filePart.getInputStream()) {
                Path imagePath = Paths.get(uploadDir.getAbsolutePath(), fileName);
                Files.copy(fileInput, imagePath);
            }
            String fileUrl = "img/" + fileName;

            // Thêm tin tức vào cơ sở dữ liệu
            AdminDAO admin = new AdminDAO();
            News news = new News(title, content, fileUrl, postdate, day, month, year, summary);
            admin.addNews(news);

            // Chuyển hướng sau khi thêm tin tức
            request.setAttribute("message", "Add news successfully!");
            HttpSession session = request.getSession();
            Account a = (Account) session.getAttribute("account");
// Chuyển hướng sau khi thêm tin tức
            if (a.getRole().equals("Maketer")) {
                response.sendRedirect("maketer");
            } else if (a.getRole().equals("Manager")){
                response.sendRedirect("admin");
            }
        } else {
            // Nếu có bất kỳ tham số nào là null, in ra thông báo lỗi
            System.out.println("Error: One or more parameters are null");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
