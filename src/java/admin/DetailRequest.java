package admin;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.ReDetail;

@WebServlet(name = "DetailRequest", urlPatterns = {"/detailreq"})
public class DetailRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminDAO dao = new AdminDAO(); // Tạo đối tượng AdminDAO để truy vấn CSDL

        // Lấy ID từ tham số yêu cầu
        String idRequest = request.getParameter("id");
        System.out.println("ID Request từ tham số: " + idRequest);

        // Kiểm tra xem idRequest có tồn tại và không rỗng không
        if (idRequest != null && !idRequest.isEmpty()) {
            try {
                // Lấy chi tiết yêu cầu cụ thể dựa trên idRequest
                ReDetail requestDetail = dao.getRequestById(Integer.parseInt(idRequest));

                // Nếu chi tiết yêu cầu tồn tại, đặt nó làm thuộc tính trong yêu cầu
                if (requestDetail != null) {
                    request.setAttribute("requestDetail", requestDetail);
                    System.out.println("Chi tiết yêu cầu được đặt làm thuộc tính của yêu cầu.");

                    // Chuyển tiếp yêu cầu đến trang JSP
                    System.out.println("Chuyển tiếp yêu cầu đến Admin/Requestdetail.jsp.");
                    request.getRequestDispatcher("Admin/Requestdetail.jsp").forward(request, response);
                    return; // Dừng việc thực thi servlet tiếp theo
                } else {
                    // Xử lý trường hợp không tìm thấy chi tiết yêu cầu
                    response.getWriter().println("Không tìm thấy chi tiết yêu cầu");
                    System.out.println("Không tìm thấy chi tiết yêu cầu.");
                }
            } catch (NumberFormatException e) {
                // Xử lý trường hợp idRequest không phải là số nguyên hợp lệ
                response.getWriter().println("Định dạng ID yêu cầu không hợp lệ");
                System.out.println("Định dạng ID yêu cầu không hợp lệ.");
            }
        } else {
            // Xử lý trường hợp idRequest không được cung cấp hoặc không hợp lệ
            response.getWriter().println("Thiếu ID yêu cầu");
            System.out.println("Thiếu ID yêu cầu.");
        }
        request.getRequestDispatcher("Admin/Requestdetail.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Admin/Requestdetail.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "DetailRequest Servlet";
    }
}
