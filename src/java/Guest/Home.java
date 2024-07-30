/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Guest;

import dal.DAO;
import dal.ViewStatisticRequestDAO;
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
import model.MentorStatistic;
import model.News;
import model.Skill;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Home", urlPatterns = {"/home"})
public class Home extends HttpServlet {

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
            out.println("<title>Servlet Home</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Home at sad" + request.getContextPath() + "</h1>");
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
        List<Skill> listAllSkill = dao.ListAllSkill();
        request.setAttribute("listSkill", listAllSkill);
        List<News> listnews = dao.get3news();
        request.setAttribute("listnews", listnews);
        List<News> listsecond = dao.getsecondnews();
//        System.out.println(listsecond.get(0).getContent());
        if (!listsecond.isEmpty()) {
            System.out.println(listsecond.get(0).getContent());
            request.setAttribute("listsecond", listsecond);
        } else {
            // Handle the case when the list is empty
            System.out.println("The list of second news is empty.");
        }
        request.setAttribute("listsecond", listsecond);
        List<News> listlast = dao.getlastnews();
        request.setAttribute("listlast", listlast);
        //System.out.println("Number of skills: " + listAllSkill.size());
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account == null || !"Mentor".equals(account.getRole())) {
            request.setAttribute("errorMess", "You do not have permission to access this page.");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            ViewStatisticRequestDAO viewStatisticDAO = new ViewStatisticRequestDAO();
            MentorStatistic mentorStats = viewStatisticDAO.getMentorStatistics(account.getId());
            request.setAttribute("mentorStats", mentorStats);
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
