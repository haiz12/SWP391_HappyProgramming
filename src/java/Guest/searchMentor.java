/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Guest;

import admin.AdminDAO;
import dal.DAO;
import dal.MentorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.Mentor;
import model.Skill;

/**
 *
 * @author Admin
 */
@WebServlet(name = "searchMentor", urlPatterns = {"/searchMentor"})
public class searchMentor extends HttpServlet {

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
            out.println("<title>Servlet searchMentor</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet searchMentor at " + request.getContextPath() + "</h1>");
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
        DAO daoz = new DAO();
        MentorDAO dao = new MentorDAO();
        AdminDAO admin = new AdminDAO();
        List<Mentor> list = new ArrayList<>();
        List<Mentor> listM = new ArrayList<>();
        List<Skill> listAllSkill = daoz.ListAllSkill();
        String search = request.getParameter("searchBySkill");       
        boolean skillExists = listAllSkill.stream().anyMatch(skill -> skill.getSkillName().equalsIgnoreCase(search));

if (!skillExists) {
    // Kỹ năng không tồn tại, đặt một thông báo lỗi
    request.setAttribute("err", "The skill " + search + " does not exist.");
    request.getRequestDispatcher("suggestMentor.jsp").forward(request, response);
}

        list = dao.listMentorBySkill(search);
        String des_skil = daoz.getDesBySkill(search);

        float rate;
        int totalRequest, totalInvite;
        for (Mentor m : list) {
            rate = (float) (Math.round(dao.getRate(m.getIdMentor()) * 10.0) / 10.0);
            totalRequest = dao.totalRequest(m.getIdMentor());
            totalInvite = dao.totalInvite(m.getIdMentor());
            // String img = admin.getSkillById(m.getIdSkill()).getImage();
            String img = dao.getAvatar(m.getIdMentor());
            listM.add(new Mentor(m.getIdMentor(), m.getFullname(), rate, totalRequest, totalInvite, m.getIdSkill(), m.getSkillName(), img));
        }
        request.setAttribute("listM", listM);
        request.setAttribute("message", "" + search + " Programming ");
        request.setAttribute("des", des_skil);
        request.getRequestDispatcher("suggestMentor.jsp").forward(request, response);
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
        MentorDAO dao = new MentorDAO();
        AdminDAO admin = new AdminDAO();
        List<Mentor> list = new ArrayList<>();
        List<Mentor> listM = new ArrayList<>();
        String search = request.getParameter("searchBySkill");
        list = dao.listMentorBySkill(search);

        float rate;
        int totalRequest, totalInvite;
        for (Mentor m : list) {
            rate = (float) (Math.round(dao.getRate(m.getIdMentor()) * 10.0) / 10.0);
            totalRequest = dao.totalRequest(m.getIdMentor());
            totalInvite = dao.totalInvite(m.getIdMentor());
            String img = admin.getSkillById(m.getIdSkill()).getImage();
           
            listM.add(new Mentor(m.getIdMentor(), m.getFullname(), rate, m.getUser(), totalRequest, totalInvite, m.getIdSkill(), m.getSkillName(), img));
        }
        request.setAttribute("listM", listM);

//        response.sendRedirect("suggestMentor.jsp");
        request.getRequestDispatcher("suggestMentor.jsp").forward(request, response);
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
