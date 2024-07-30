/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Mentee;

import admin.AdminDAO;
import dal.HandleRequestDAO;
import dal.HistoryPayDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Account;
import model.HistoryWallet;
import model.Mentor;
import model.Request;
import model.Wallet;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ListRequest", urlPatterns = {"/listrequest"})
public class ListRequest extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ListRequest</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ListRequest at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        Account account = (Account) request.getSession().getAttribute("account");
        if (account != null && "Mentee".equals(account.getRole())) {
            int menteeId = account.getId();
            HandleRequestDAO handleRequestDao = new HandleRequestDAO();
            int processing = 1;
            int accept = 2;
            int reject = 3;
            int cancel = 4;
            int done = 11;
            int numPerPage = 6;
            // processing
            ArrayList<Request> listRequestProcessing = handleRequestDao.getRequestByStatusOfMentee(menteeId, processing);
            int numPsRP = listRequestProcessing.size();
            if (numPsRP != 0) {
                int numpageRP = numPsRP / numPerPage + (numPsRP % numPerPage == 0 ? 0 : 1);
                int startRP, endRP;
                String tpageRP = request.getParameter("pageRP");
                int pageRP;
                try {
                    pageRP = Integer.parseInt(tpageRP);
                } catch (NumberFormatException e) {
                    pageRP = 1;
                }
                startRP = (pageRP - 1) * numPerPage;
                if (pageRP * numPerPage > numPsRP) {
                    endRP = numPsRP;
                } else {
                    endRP = pageRP * numPerPage;
                }
                ArrayList<Request> arrRP = handleRequestDao.getListByPage((ArrayList<Request>) listRequestProcessing, startRP, endRP);
                request.setAttribute("dataRP", arrRP);
                request.setAttribute("numRP", numpageRP);
                request.setAttribute("PageRP", pageRP);

                //////
                List<Integer> listRangeToCombine = new ArrayList<>();
                for (int j = 0; j < listRequestProcessing.size(); j++) {
                    if (j == 0
                            || !listRequestProcessing.get(j).getMentor().getFullname().equals(listRequestProcessing.get(j - 1).getMentor().getFullname())
                            || !listRequestProcessing.get(j).getTitle().equals(listRequestProcessing.get(j - 1).getTitle())
                            || !listRequestProcessing.get(j).getContent().equals(listRequestProcessing.get(j - 1).getContent())
                            || listRequestProcessing.get(j).getStartWeek() != listRequestProcessing.get(j - 1).getStartWeek()
                            || listRequestProcessing.get(j).getEndWeek() != listRequestProcessing.get(j - 1).getEndWeek()
                            || listRequestProcessing.get(j).getTimeSchedule().getYear() != listRequestProcessing.get(j - 1).getTimeSchedule().getYear()) {
                        listRangeToCombine.add(j);
                    }
                }
                ArrayList<String> listIdRequest = new ArrayList<>();
                int l = 1;
                String requestCombine = "";
                for (int k = 0; k < listRequestProcessing.size(); k++) {
                    requestCombine += "-" + String.valueOf(listRequestProcessing.get(k).getIdRequest()) + "-";

                    if (l < listRangeToCombine.size() && k == listRangeToCombine.get(l) - 1) {
                        out.println(requestCombine);
                        out.println("\n");
                        listIdRequest.add(requestCombine);
                        requestCombine = "";
                        l += 1;
                    }
                    if (k == listRequestProcessing.size() - 1) {
                        out.println(requestCombine);
                        out.println("\n");
                        listIdRequest.add(requestCombine);
                    }
                }
                request.setAttribute("listIdRequest", listIdRequest);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            // accept
            ArrayList<Request> listRequestAccept = handleRequestDao.getRequestByStatusOfMentee(menteeId, accept);
            int numPsRA = listRequestAccept.size();
            if (numPsRA != 0) {
                int numpageRA = numPsRA / numPerPage + (numPsRA % numPerPage == 0 ? 0 : 1);
                int startRA, endRA;
                String tpageRA = request.getParameter("pageRA");
                int pageRA;
                try {
                    pageRA = Integer.parseInt(tpageRA);
                } catch (NumberFormatException e) {
                    pageRA = 1;
                }
                startRA = (pageRA - 1) * numPerPage;
                if (pageRA * numPerPage > numPsRA) {
                    endRA = numPsRA;
                } else {
                    endRA = pageRA * numPerPage;
                }
                ArrayList<Request> arrRA = handleRequestDao.getListByPage((ArrayList<Request>) listRequestAccept, startRA, endRA);
                request.setAttribute("dataRA", arrRA);
                request.setAttribute("numRA", numpageRA);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            // Reject
            ArrayList<Request> listRequestReject = handleRequestDao.getRequestByStatusOfMentee(menteeId, reject);
            int numPsRR = listRequestReject.size();
            if (numPsRR != 0) {
                int numpageRR = numPsRR / numPerPage + (numPsRR % numPerPage == 0 ? 0 : 1);
                int startRR, endRR;
                String tpageRR = request.getParameter("pageRR");
                int pageRR;
                try {
                    pageRR = Integer.parseInt(tpageRR);
                } catch (NumberFormatException e) {
                    pageRR = 1;
                }
                startRR = (pageRR - 1) * numPerPage;
                if (pageRR * numPerPage > numPsRR) {
                    endRR = numPsRR;
                } else {
                    endRR = pageRR * numPerPage;
                }
                ArrayList<Request> arrRR = handleRequestDao.getListByPage((ArrayList<Request>) listRequestReject, startRR, endRR);
                request.setAttribute("dataRR", arrRR);
                request.setAttribute("numRR", numpageRR);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            //Cancel
            ArrayList<Request> listRequestCancel = handleRequestDao.getRequestByStatusOfMentee(menteeId, cancel);
            int numPsRC = listRequestCancel.size();
            if (numPsRC != 0) {
                int numpageRC = numPsRC / numPerPage + (numPsRC % numPerPage == 0 ? 0 : 1);
                int startRC, endRC;
                String tpageRC = request.getParameter("pageRC");
                int pageRC;
                try {
                    pageRC = Integer.parseInt(tpageRC);
                } catch (NumberFormatException e) {
                    pageRC = 1;
                }
                startRC = (pageRC - 1) * numPerPage;
                if (pageRC * numPerPage > numPsRC) {
                    endRC = numPsRC;
                } else {
                    endRC = pageRC * numPerPage;
                }
                ArrayList<Request> arrRC = handleRequestDao.getListByPage((ArrayList<Request>) listRequestCancel, startRC, endRC);
                request.setAttribute("dataRC", arrRC);
                request.setAttribute("numRC", numpageRC);

            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            //Paid
            ArrayList<Request> listRequestPaid = handleRequestDao.getRequestByStatusOfMentee(menteeId, done);
            int numPsRPa = listRequestPaid.size();
            if (numPsRPa != 0) {
                int numpageRPa = numPsRPa / numPerPage + (numPsRPa % numPerPage == 0 ? 0 : 1);
                int startRPa, endRPa;
                String tpageRPa = request.getParameter("pageRPa");
                int pageRPa;
                try {
                    pageRPa = Integer.parseInt(tpageRPa);
                } catch (NumberFormatException e) {
                    pageRPa = 1;
                }
                startRPa = (pageRPa - 1) * numPerPage;
                if (pageRPa * numPerPage > numPsRPa) {
                    endRPa = numPsRPa;
                } else {
                    endRPa = pageRPa * numPerPage;
                }
                ArrayList<Request> arrRPa = handleRequestDao.getListByPage((ArrayList<Request>) listRequestPaid, startRPa, endRPa);
                request.setAttribute("dataRPa", arrRPa);
                request.setAttribute("numRPa", numpageRPa);
            } else {
                String errorMessage = "No requests found for this mentor.";
                request.setAttribute("errorMessage", errorMessage);
            }
            request.getRequestDispatcher("view/listallreq.jsp").forward(request, response);
        } else {
            String errorMessage = "You do not have permission to access this page.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("view/listallreq.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        String listId = request.getParameter("idRequest");
        if (listId != null) {
            listId = listId.substring(1, listId.length() - 1);
        }
        int statusId = Integer.parseInt(request.getParameter("statusId"));
        HandleRequestDAO handleRequestDao = new HandleRequestDAO();
        if (statusId == 4) {
            String[] elements = listId.split("--");
            for (int i = 0; i < elements.length; i++) {
                handleRequestDao.cancelManyRequest(Integer.parseInt(elements[i]));
            }
        }
        HistoryPayDAO hd = new HistoryPayDAO();
        if (statusId == 13) {
            int idRequest = Integer.parseInt(request.getParameter("idr"));
            String reasonReject = null;
            handleRequestDao.updateStatusRequest(idRequest, 2, reasonReject);
        }
        if (statusId == 12) {
            int idRequest = Integer.parseInt(request.getParameter("idr"));
            String reasonReject = null;
            handleRequestDao.updateStatusRequest(idRequest, statusId, reasonReject);
        }

        response.sendRedirect("listrequest");
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
