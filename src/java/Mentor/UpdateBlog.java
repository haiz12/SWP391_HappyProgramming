/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Mentor;

import dal.BlogDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import model.Blog;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="UpdateBlog", urlPatterns={"/updateblog"})
@MultipartConfig
public class UpdateBlog extends HttpServlet {
   
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
            out.println("<title>Servlet UpdateBlog</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateBlog at " + request.getContextPath () + "</h1>");
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
        BlogDAO bd = new BlogDAO();
        //lay blog id tu ViewBlog.jsp
        String id = request.getParameter("blogID");
        int idblog = Integer.parseInt(id);
        
        Blog blog = bd.getBlogByid(idblog);   // lay blog theo idblog
        request.setAttribute("b", blog);
        request.getRequestDispatcher("Mentor/UpdateBlog.jsp").forward(request, response);
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
        BlogDAO bd = new BlogDAO();
        int idBlog=Integer.parseInt(request.getParameter("idblog"));
        System.out.println("idblog" + idBlog);
        String title = request.getParameter("title");
        String brief = request.getParameter("brief");
        String detail = request.getParameter("detail");
        String date = request.getParameter("date");
        
        Part filePart = request.getPart("image");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

        // Define the folder where you want to save the file
        String uploadPath = getServletContext().getRealPath("/img");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        File existingFile = new File(uploadDir, fileName);
        if (existingFile.exists()) {
            existingFile.delete();
        }
        // Save the file to the folder
        try ( InputStream fileInput = filePart.getInputStream()) {
            Path imagePath = Paths.get(uploadDir.getAbsolutePath(), fileName);
            Files.copy(fileInput, imagePath);
        }

        // Add the file URL to your database
        String fileUrl = "img/" + fileName;
        bd.updateBlog(date, fileUrl, title, brief, detail, 0, idBlog);
        response.sendRedirect("bloglist");
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
