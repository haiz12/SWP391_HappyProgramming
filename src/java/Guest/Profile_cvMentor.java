/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Guest;

import dal.MentorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.Rate;
import model.info;

@WebServlet(name = "Profile_cvMenter", urlPatterns = {"/profilecv"})
public class Profile_cvMentor extends HttpServlet {

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
            out.println("<title>Servlet Profile_cvMenter</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Profile_cvMenter at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account");
        MentorDAO mentorDao = new MentorDAO();
        String action = request.getParameter("action");
        String idMentorParam = request.getParameter("idMentor");
        if (idMentorParam != null && !idMentorParam.isEmpty()) {
            try {
                int idMentor = Integer.parseInt(idMentorParam);
                System.out.println(idMentor);

                String update = "reject";
                if (a != null) {
                    if (idMentor == a.getId()) {
                        update = "accept";
                    }
                }
                request.setAttribute("update", update);

                // Retrieve full CV information of the mentor
                Mentor mentor = mentorDao.getIDMentor(idMentor);
                request.setAttribute("cv", mentor);

                // Retrieve skills of the mentor
                List<Have_SKill> hskill = mentorDao.getidhaveskill(idMentor);
                request.setAttribute("cf", hskill);

                // Retrieve account information of the mentor
                Account account = mentorDao.getAccountByid(idMentor);
                request.setAttribute("cx", account);
                // Retrieve rates for the mentor
                List<Rate> rates = mentorDao.getRatesByMentorId(idMentor);
                if (rates == null || rates.isEmpty()) {
                    request.setAttribute("message", "Hiện chưa có rating nào");
                } else {
                    request.setAttribute("rates", rates);
                }
                // Forward the request to the appropriate JSP page based on the action
                if (action == null) { // If this is the action of a mentor viewing their own CV
                    request.getRequestDispatcher("Mentor/profileMentor.jsp").forward(request, response);
                } else if (action.equals("view")) { // If this is the action of viewing CV from the search functionality
                    request.setAttribute("action", "request");
                    request.getRequestDispatcher("Mentor/profileMentor.jsp").forward(request, response);
                }
                
            } catch (NumberFormatException e) {
                // Handle the case where the parameter is not a valid integer
                e.printStackTrace(); // Or log the error
            }
        } else {
            // Handle the case where the "idMentor" parameter is null or empty
            System.out.println("idMentor parameter is null or empty");
            // Optionally, you can return an error response or redirect the user to an error page
        }
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
