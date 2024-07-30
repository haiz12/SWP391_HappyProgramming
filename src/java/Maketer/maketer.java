/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Maketer;

import admin.AdminDAO;
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
import model.News;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="maketer", urlPatterns={"/maketer"})
public class maketer extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet maketer</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet maketer at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
        if (a != null && (a.getRole().equals("Maketer"))) {
            session.setAttribute("account", a);
            AdminDAO addao = new AdminDAO();
            
            int page4, numperpage4 = 5;
            int start4;
            int end4;
            String xpage4 = request.getParameter("page4");
            if (xpage4 == null) {
                page4 = 1;
            } else {
                page4 = Integer.parseInt(xpage4);

            }

            List<News> listnews = addao.getAllnews();
            int size4 = listnews.size();
            start4 = (page4 - 1) * numperpage4;
            end4 = Math.min(page4 * numperpage4, size4);
            int num4 = (size4 % 5 == 0 ? (size4 / 5) : ((size4 / 5)) + 1);
            List<News> listnews1 = addao.getListNewByPage(listnews, start4, end4);
            request.setAttribute("news", listnews1);
            request.setAttribute("num4", num4);
            request.setAttribute("page4", page4);
            request.getRequestDispatcher("Maketer/maketer.jsp").forward(request, response);
            } else {
            request.getRequestDispatcher("signinmaketer").forward(request, response);
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("Maketer/maketer.jsp").forward(request, response);
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
