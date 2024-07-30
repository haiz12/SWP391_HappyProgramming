/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package admin;

import dal.MentorDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CV;
import model.Have_SKill;
import model.Mentor;

/**
 *
 * @author trang
 */
@WebServlet(name = "UpdateCV", urlPatterns = {"/upcvmentor"})
public class UpdateCV extends HttpServlet {

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
            out.println("<title>Servlet UpdateCV</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateCV at " + request.getContextPath() + "</h1>");
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
        int idmentor = Integer.parseInt(request.getParameter("idmentor"));
        AdminDAO addAO = new AdminDAO();

        CV cv = addAO.getCVbyID(idmentor);
        MentorDAO mdao = new MentorDAO();
         mdao.deleteMentorbyhaveskill(idmentor);
        CV sss = addAO.getCVbyID(idmentor);
        String fullname = sss.getFullname();
        String avartar = sss.getAvatar();
        String phone = sss.getPhone();
        String dob = sss.getDob();
        String sex = sss.getSex();
        String address = sss.getAddress();
        String profess = sss.getProfession();
        String Pro_intro = sss.getPro_introduc();
        String archive = sss.getArchivement_descition();
        String framew = sss.getFramework();
        String experience = sss.getExperience();
        String edu = sss.getEducation();
        String service = sss.getMyservice();
        int cost = sss.getCost();
        String stk = sss.getStk();

        String skill = sss.getSkill();
        System.out.println(skill);
        skill = skill.substring(1, skill.length() - 1);
        String[] skillsArray = skill.split(", ");
        int a;
        int i = 0;
        for (String s : skillsArray) {
            a = mdao.getSkillNameWithId(s).getIdSkill();
            i++;
            System.out.println(s);
            System.out.println(a);
          

            mdao.addHave_Skill(idmentor, a);

        }

        boolean result = false;
        try {
            result = mdao.updateCV(idmentor, fullname, avartar, phone, dob, sex, address, profess, Pro_intro, archive, framew, experience, edu, service, cost, stk);
            // System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;// Log the exception
        }
        addAO.deleteCV(idmentor);
        response.sendRedirect("admin#cvmentor");

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
