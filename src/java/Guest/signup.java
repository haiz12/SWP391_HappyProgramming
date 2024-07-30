package Guest;

import CheckDb.Checkdb;
import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Account;
import dal.WalletDAO;
import model.Signup;

/**
 * Handles the user signup process.
 */
public class signup extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet signup</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet signup at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("Account/signup.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Checkdb check = new Checkdb();
        DAO dao = new DAO();
        WalletDAO walletdao = new WalletDAO();
        
        String role = request.getParameter("role");
        String user = request.getParameter("username");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String phone = request.getParameter("phone");
        String birth = request.getParameter("birth");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        if (gender == null) {
            gender = "Male";
        }

        Signup signup = new Signup(role, user, pass, repass, email, fullname, phone, birth, address, gender);

        String err = "";
        LocalDateTime registrationTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String registerDate = registrationTime.format(formatter);

        // Validation
        if (!fullname.matches("^[\\p{L} ]{3,50}$")) {
            setErrorAndRedirect(request, response, "Full name should only contain letters, spaces, and be 3-50 characters long.", signup);
            return;
        }

        if (!user.matches("^[a-zA-Z0-9]{6,30}$")) {
            setErrorAndRedirect(request, response, "Username should be 6-30 characters long and contain no special characters or spaces.", signup);
            return;
        }

        if (phone != null && !phone.matches("^\\d{10}$")) {
            setErrorAndRedirect(request, response, "Phone number should be 10 numeric characters.", signup);
            return;
        }

        if (!email.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) {
            setErrorAndRedirect(request, response, "Email should have characters before '@', contain '@', and have characters after '@'.", signup);
            return;
        }

        if (pass.isEmpty() || !pass.matches("^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$")) {
            setErrorAndRedirect(request, response, "Password should not be blank, contain at least one digit, one uppercase letter, one special character, and be 8-20 characters long.", signup);
            return;
        }

        if (!repass.equals(pass)) {
            setErrorAndRedirect(request, response, "Confirm password must match password.", signup);
            return;
        }

        if (birth == null || birth.isEmpty()) {
            setErrorAndRedirect(request, response, "Birth date should not be blank.", signup);
            return;
        }

        if (gender == null || gender.isEmpty()) {
            setErrorAndRedirect(request, response, "Gender should not be blank.", signup);
            return;
        }

        // Check for existing user and email
        if (check.IsUserExist(user)) {
            setErrorAndRedirect(request, response, "Username already exists.", signup);
            return;
        }

        if (check.isEmailUsed(email)) {
            setErrorAndRedirect(request, response, "Email already exists.", signup);
            return;
        }

        // Register user
        dao.addAccount(user, pass, role, email);
        Account a = dao.login(user, pass);
        walletdao.addWallet(a);

        if (role.equalsIgnoreCase("Mentor")) {
            dao.addMentor(a.getId(), fullname, phone, birth, gender, address, registerDate);
        } else {
            dao.addMentee(a.getId(), fullname, birth, phone, gender, registerDate, address);
        }

        HttpSession session = request.getSession();
        session.setAttribute("account", a);
        request.getRequestDispatcher("sendEmailVerify").forward(request, response);
    }

    private void setErrorAndRedirect(HttpServletRequest request, HttpServletResponse response, String errMsg, Signup signup)
            throws ServletException, IOException {
        request.setAttribute("err", errMsg);
        request.setAttribute("signup", signup);
        request.getRequestDispatcher("Account/signup.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Handles user signup";
    }
}
