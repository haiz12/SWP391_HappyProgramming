package admin;

import dal.BlogDAO;
import dal.DAO;
import dal.HandleRequestDAO;
import dal.HistoryPayDAO;
import dal.MenteeDAO;
import dal.MentorDAO;
import dal.RequestDAO;
import dal.TakeMoneyDAO;
import dal.WalletDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.swing.text.View;
import model.AListMentor;
import model.Account;
import model.Adshowreq;
import model.Blog;
import model.CV;
import model.GetMoney;
import model.HistoryWallet;
import model.Mentee;
import model.Mentor;
import model.News;
import model.Request;
import model.SkillMentor;
import model.StaticMentee;
import model.Time_Slot;
import model.UpdateSheduleRequest;
import model.ViewScheduleOfAllMentor;
import model.Wallet;
import model.reportReq;

/**
 *
 * @author Admin
 */
@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {

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
            out.println("<title>Servlet admin</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet admin at " + request.getContextPath() + "</h1>");
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
        if (a != null && (a.getRole().equals("Admin") || a.getRole().equals("Manager"))) {
            session.setAttribute("account", a);

            ///// du lieu
            AdminDAO addao = new AdminDAO();

            // list Skill
            int page, numperpage = 5;

            String xpage = request.getParameter("page");
            if (xpage == null) {
                page = 1;
            } else {
                page = Integer.parseInt(xpage);

            }
            int start;
            start = (page - 1) * numperpage;
            // list Skill
            List<SkillMentor> listSkill = new ArrayList<>();
            listSkill = addao.listAllSkill();
            int size3 = listSkill.size();
            int end2 = Math.min(page * numperpage, size3);
            int num3 = (size3 % 5 == 0 ? (size3 / 5) : ((size3 / 5)) + 1);

            List<SkillMentor> listSkill22 = addao.getListSkillByPage(listSkill, start, end2);

            System.out.println(listSkill22.size());
            request.setAttribute("page", page);
            request.setAttribute("num3", num3);
            request.setAttribute("listSkill22", listSkill22);

            // Lấy danh sách lịch trình của tất cả các mentor
            List<ViewScheduleOfAllMentor> listSchedule = addao.getViewScheduleOfAllMentor();
            Map<ViewScheduleOfAllMentor, List<ViewScheduleOfAllMentor>> mentorSchedules = new HashMap<>();
            Set<Integer> processedMentors = new HashSet<>();

// Lọc các lịch trình có trạng thái là 1 cho từng mentor và thêm vào danh sách filteredSchedules
            for (ViewScheduleOfAllMentor viewScheduleOfAllMentor : listSchedule) {
                int mentorId = viewScheduleOfAllMentor.getMentorId();
                if (!processedMentors.contains(mentorId)) {
                    List<ViewScheduleOfAllMentor> list = addao.getViewScheduleOfAllMentorsWithStatus(listSchedule, mentorId, 1);
                    mentorSchedules.put(viewScheduleOfAllMentor, list);
                    processedMentors.add(mentorId);
                }
            }

//            for (ViewScheduleOfAllMentor viewScheduleOfAllMentor : listSchedule) {
//                int mentorId = viewScheduleOfAllMentor.getMentorId();
//                int statusId = viewScheduleOfAllMentor.getStatus();
//                if (!(processedMentors.contains(mentorId) && processedStatus.contains(statusId))) {
//                    List<ViewScheduleOfAllMentor> list = addao.getViewScheduleOfAllMentorsWithStatus7(listSchedule, mentorId);
//                    mentorSchedules.put(viewScheduleOfAllMentor, list);
//                    processedMentors.add(mentorId);
//                    processedStatus.add(statusId);
//                }
//            }
// Gán danh sách mentorSchedules vào request
            request.setAttribute("mentorSchedules", mentorSchedules);

            request.setAttribute("listSchedule1", listSchedule);

            MentorDAO mdao = new MentorDAO();
            List<Time_Slot> timeSlot = mdao.listTimeSlot();
            request.setAttribute("timeSlot", timeSlot);

            List<Mentor> men = addao.getlistallMentor();
            List<AListMentor> alis = new ArrayList<>();
            int page1, numperpage1 = 5;

            String xpage1 = request.getParameter("page1");
            if (xpage1 == null) {
                page1 = 1;
            } else {
                page1 = Integer.parseInt(xpage1);

            }
            int end;

            String search = request.getParameter("search");
            request.setAttribute("search", search);

            if (search != null && !search.isEmpty()) {
                men = addao.listMentorByadmin(search);
                int acceptrequest;
                float percentcompleted;
                float rate;
                boolean ac;
                int action;
                for (Mentor ali : men) {
                    acceptrequest = addao.countAcceptedRequests(ali.getIdMentor());
                    percentcompleted = Float.parseFloat(String.format("%.2f", addao.calculateCompletedPercentage(ali.getIdMentor())));
                    rate = Float.parseFloat(String.format("%.2f", addao.getRate(ali.getIdMentor())));

                    Account acc = addao.getAccountByid(ali.getIdMentor());

                    action = acc.getActive();
                    alis.add(new AListMentor(ali.getIdMentor(), ali.getFullname(), ali.getAccount(), ali.getProfession(), acceptrequest, percentcompleted, rate, action));

                    //  System.out.println(alis);
                }

            } else {
                alis = addao.listAllMen();

            }
            int size = alis.size();
            //  System.out.println(size);
            // System.out.println(page);
            int start1 = (page1 - 1) * numperpage1;
            end = Math.min(page1 * numperpage1, size);
            int num = (size % 5 == 0 ? (size / 5) : ((size / 5)) + 1);
            List<AListMentor> list1 = addao.getListByPage(alis, start1, end);
            request.setAttribute("lis", list1);
            request.setAttribute("page1", page1);
            request.setAttribute("num", num);
            MenteeDAO dao = new MenteeDAO();
            int page2, numperpage2 = 5;

            String xpage2 = request.getParameter("page2");
            if (xpage2 == null) {
                page2 = 1;
            } else {
                page2 = Integer.parseInt(xpage2);

            }

            List<StaticMentee> list = new ArrayList<>();
            int start2 = (page2 - 1) * numperpage2;
            list = dao.getStaticMetee();
            int sizemte = list.size();
            int end1 = Math.min(page2 * numperpage2, sizemte);
            int num2 = (sizemte % 5 == 0 ? (sizemte / 5) : ((sizemte / 5)) + 1);
            List<StaticMentee> list2 = dao.getListByPage(list, start2, end1);
            //System.out.println(list2);
            request.setAttribute("num2", num2);
            request.setAttribute("page2", page2);
            request.setAttribute("list2", list2);
            List<Mentee> menn = dao.getlistallMentee();
            int result = 0;
            for (Mentee mentee : menn) {
                result++;
            }
            //System.out.println(result);
            request.setAttribute("result", result);
            int page4, numperpage4 = 5;
            int start4;
            int end4;
            String xpage4 = request.getParameter("page4");
            if (xpage4 == null) {
                page4 = 1;
            } else {
                page4 = Integer.parseInt(xpage4);

            }
            List<CV> cvList = addao.getCV();
            request.setAttribute("cvList", cvList);

            int page8, numperpage8 = 5;
            int start8;
            int end8;
            String xpage8 = request.getParameter("page8");
            if (xpage8 == null) {
                page8 = 1;
            } else {
                page8 = Integer.parseInt(xpage8);

            }

            DAO dal = new DAO();
            List<reportReq> ame = dal.getreportReq();
            int size8 = ame.size();
            start8 = (page8 - 1) * numperpage8;
            end8 = Math.min(page8 * numperpage8, size8);
            int num8 = (size8 % 5 == 0 ? (size8 / 5) : ((size8 / 5)) + 1);
            List<reportReq> amme = dal.getListSkillByPage(ame, start8, end8);
            request.setAttribute("amme", amme);
            request.setAttribute("num8", num8);
            request.setAttribute("page8", page8);

            List<News> listnews = addao.getAllnews();
            int size4 = listnews.size();
            start4 = (page4 - 1) * numperpage4;
            end4 = Math.min(page4 * numperpage4, size4);
            int num4 = (size4 % 5 == 0 ? (size4 / 5) : ((size4 / 5)) + 1);
            List<News> listnews1 = addao.getListNewByPage(listnews, start4, end4);
            request.setAttribute("news", listnews1);
            request.setAttribute("num4", num4);
            request.setAttribute("page4", page4);

            int page6;
            String xpage6 = request.getParameter("page6");

            int pageRequest = 1; // Số trang mặc định
            int recordsPerPage = 5; // Số bản ghi hiển thị trên mỗi trang

            if (xpage6 == null) {
                page6 = 1;
            } else {
                page6 = Integer.parseInt(xpage6);;
            }

            AdminDAO daoAdmin = new AdminDAO();
            List<Adshowreq> listRequest;
            String searchTerm = request.getParameter("searchTerm");

            if (searchTerm != null && !searchTerm.isEmpty()) {
                // Tìm kiếm theo từ khóa và lấy toàn bộ kết quả
                listRequest = daoAdmin.searchAdshowreq(searchTerm);
            } else {
                // Lấy toàn bộ danh sách nếu không có từ khóa tìm kiếm
                listRequest = daoAdmin.getAllAdshowreq();
            }

            // Tính tổng số trang
            int totalRecords = listRequest.size();
            int totalPages = (totalRecords + recordsPerPage - 1) / recordsPerPage;

            // Tính chỉ số bắt đầu và kết thúc của danh sách hiện tại
            int startIdx = (page6 - 1) * recordsPerPage;
            int endIdx = Math.min(startIdx + recordsPerPage, totalRecords);

            // Trích xuất danh sách hiện tại để hiển thị trên trang
            List<Adshowreq> currentList = listRequest.subList(startIdx, endIdx);

            List<String> statusList = daoAdmin.getAllDistinctStatus();

            // Đặt các thuộc tính cần thiết cho trang JSP
            request.setAttribute("statusList", statusList);
            request.setAttribute("listRequest", currentList);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", page);
            request.setAttribute("searchTerm", searchTerm); // Truyền lại từ khóa tìm kiếm để hiển thị trên trang

            String[] selectedStatusArray = request.getParameterValues("selectedStatusArray");
            String startDate = request.getParameter("startDate");
            String endDate = request.getParameter("endDate");
            if (selectedStatusArray != null) {
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
                    adshowreqList = addao.getAllAdshowreq();
                } else if (selectedStatusList.isEmpty() && startDate != null && endDate != null) {
                    adshowreqList = addao.checkdate(startDate, endDate);
                } else {
                    adshowreqList = addao.getMulStatus(selectedStatusList, startDate, endDate);
                }

                // Tính tổng số trang dựa trên kết quả tìm kiếm
                int totalRecordss = adshowreqList.size();
                int recordsPerPages = 6; // Số bản ghi hiển thị trên mỗi trang
                int totalPagess = (totalRecordss + recordsPerPages - 1) / recordsPerPage;

                // Trang mặc định sẽ là trang đầu tiên
                int pages = 1;

                // Lấy số trang nếu được chọn từ yêu cầu POST
                if (request.getParameter("page") != null) {
                    page = Integer.parseInt(request.getParameter("page"));
                }

                // Tính chỉ số bắt đầu và kết thúc của danh sách hiện tại
                int startIdxs = (pages - 1) * recordsPerPage;
                int endIdxs = Math.min(startIdx + recordsPerPages, totalRecordss);

                // Trích xuất danh sách hiện tại để hiển thị trên trang
                List<Adshowreq> currentLists = adshowreqList.subList(startIdxs, endIdxs);

                List<String> statusLists = addao.getAllDistinctStatus();

                request.setAttribute("statusList", statusLists);
                request.setAttribute("listRequest", currentLists);
                request.setAttribute("s", selectedStatusArray);
                request.setAttribute("totalPages", totalPagess);
                request.setAttribute("currentPage", page);
            }

            TakeMoneyDAO takeMoneyDAo = new TakeMoneyDAO();
            WalletDAO walletDAO = new WalletDAO();
            HistoryPayDAO historyDAO = new HistoryPayDAO();
            MentorDAO mentorDAO = new MentorDAO();
            List<GetMoney> listTakeMoney = takeMoneyDAo.getAllTakeMoney();
            request.setAttribute("listTakeMoney", listTakeMoney);
            int walletSystem = walletDAO.getWalletBalance(14);
            request.setAttribute("walletSystem", walletSystem);
            int income = walletDAO.incomeSystem();
            request.setAttribute("totalIncome", income);
            List<HistoryWallet> listHistory = historyDAO.getHistoryWalletByIdAccount(14);
            request.setAttribute("listHistory", listHistory);
            BlogDAO bd = new BlogDAO();
            List<Blog> BlogList4 = bd.getBlog();
            request.setAttribute("bloglist4", BlogList4);
//            List<ViewScheduleByMentorId > viewScheduleByMentorId = mentorDAO.viewScheduleByMentorId();
            AdminManagerRequestDAO adminDao = new AdminManagerRequestDAO();
            ArrayList<UpdateSheduleRequest> listUpdateScheduleRequest = adminDao.getListUpdateScheduleRequest();
            request.setAttribute("listUSR", listUpdateScheduleRequest);
            // List Request
            HandleRequestDAO hd = new HandleRequestDAO();
            ArrayList<Request> allRequest = hd.getListRequestForManager();
            request.setAttribute("allRequest", allRequest);
            //
            int idAccount = 14;
            request.setAttribute("idAccount", idAccount);
            List<HistoryWallet> listHistoryWallet = historyDAO.getHistoryWalletByIdAccount(idAccount);
            request.setAttribute("historyWallet", listHistoryWallet);
            int totalIncome = walletDAO.totalIncome(idAccount);
            request.setAttribute("totalIncome", totalIncome);
            int walletBalance = walletDAO.getWalletBalance(idAccount);
            request.setAttribute("walletBalance", walletBalance);
//            PrintWriter out = response.getWriter();
//            for (HistoryWallet historyWallet : listHistoryWallet) {
//                out.print(historyWallet.toString());
//            }
           request.getRequestDispatcher("Admin/demo_admin.jsp").forward(request, response);

        } else {
            request.getRequestDispatcher("signinAdmin").forward(request, response);
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
        String listRequest = request.getParameter("idRequest");
        int totalCost = Integer.parseInt(request.getParameter("totalCost"));
        String[] idRequest = listRequest.split(",");
        HandleRequestDAO handleRequestDao = new HandleRequestDAO();
        Request r = handleRequestDao.getRequestById(Integer.parseInt(idRequest[0]));
        handleRequestDao.updateStatusRequest(Integer.parseInt(idRequest[0]), 10, null);
        out.print(r.toString());
        
        int idMentor = r.getIdMentor();
        int idManager = 14;
        WalletDAO walletDAO = new WalletDAO();
        Wallet walletMentor = walletDAO.getWalletByIdAccount(idMentor);
        walletMentor.setAmount(walletMentor.getAmount() + totalCost);
        walletDAO.updateWallet(walletMentor);
        //
        Wallet walletManager = walletDAO.getWalletByIdAccount(idManager);
        walletManager.setAmount(walletManager.getAmount() - totalCost);
        walletDAO.updateWallet(walletManager);
        //
        Timestamp createdAt = new Timestamp(new Date().getTime());
        HistoryPayDAO hd = new HistoryPayDAO();
        HistoryWallet hme = new HistoryWallet();
        hme.setIdAccount(idMentor);
        hme.setAmount(totalCost);
        hme.setContent("Pay for course :" + r.getSkill().getSkillName());
        hme.setDatePay(String.valueOf(createdAt));
        hme.setNameMentee("Manager");
        hme.setStype("Deposit");
        hd.addHistoryPay(hme);
        //
        HistoryWallet hma = new HistoryWallet();
        hma.setIdAccount(idManager);
        hma.setAmount(totalCost);
        hma.setContent("Pay for course :" + r.getSkill().getSkillName());
        hma.setDatePay(String.valueOf(createdAt));
        hma.setNameMentee(r.getMentor().getFullname());
        hma.setStype("Payment");
        hd.addHistoryPay(hma);
        
        
        response.sendRedirect("admin");
    }

}
