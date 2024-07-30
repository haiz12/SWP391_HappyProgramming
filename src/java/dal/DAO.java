/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Mentee;
import model.Mentor;
import model.News;
import model.Rate;
import model.Schedule;
import model.Request;
import model.Skill;
import model.reportReq;

/**
 *
 * @author Admin
 */
public class DAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Account> listAccount = new ArrayList<>();
    List<Skill> listAllSkill = new ArrayList<>();

    public boolean insertreport(reportReq r) {
        try {
            String sql = "INSERT INTO [dbo].[reportReq]\n"
                    + "           ([idRequest]\n"
                    + "           ,[title]\n"
                    + "           ,[content])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, r.getIdRequest());
            stm.setString(2, r.getTitle());
            stm.setString(3, r.getContent());
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public List<reportReq> getListSkillByPage(List<reportReq> list, int start, int end) {
        ArrayList<reportReq> arr = new ArrayList<>();
        for (int i = start; i < end; i++) {
            arr.add(list.get(i));
        }
        return arr;
    }

    public List<reportReq> getreportReq() {
        List<reportReq> listreport = new ArrayList<>();
        try {
            String strSelect = "SELECT TOP (1000) [idRequest]\n"
                    + "      ,[title]\n"
                    + "      ,[content]\n"
                    + "  FROM [swp].[dbo].[reportReq]";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                reportReq a = new reportReq(rs.getInt(1), rs.getString(2), rs.getString(3));

                listreport.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listreport;
    }

    public Account login(String username, String password) {
        String query = "SELECT *"
                + "FROM account "
                + "WHERE username = ? AND password = ?";

        try ( PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();
            if (resultSet.next()) {
                int idAccount = resultSet.getInt(1);
                String user = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
                String role = resultSet.getString(5);
                int confirm = resultSet.getInt(6);
                int active = resultSet.getInt(7);

                return new Account(idAccount, user, email, pass, role, confirm, active);
            }
        } catch (Exception e) {
            System.out.println("Login: " + e.getMessage());
        }

        return null;
    }

    public Rate getRateByIDRequest(int id) {
        try {
            String sql = " select * from rate\n"
                    + "  where idRequest=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                int idRate = rs.getInt(1);
                int idRequest = rs.getInt(2);
                int idMentee = rs.getInt(3);
                int idMentor = rs.getInt(4);
                int star = rs.getInt(5);
                String comment = rs.getString(6);
                String time = rs.getString(7);

                Rate r = new Rate(idRate, idRequest, idMentee, idMentor, star, comment, time);

                return r;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public Request getIdMentorss(int idMentor) {
        try {
            String sql = "select * from request\n"
                    + "         where idMentor = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idRequest = rs.getInt("idRequest");
                int idMentee = rs.getInt("idMentee");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int skillId = rs.getInt("skillId");
                int statusId = rs.getInt("statusId");
                int startWeek = rs.getInt("startWeek");
                int endWeek =rs.getInt("endWeek");
                float hour = rs.getFloat("hour");
                int totalCost=rs.getInt("totalCost");
                String reasonReject = rs.getString("reasonReject");
                int timeScheduleId=rs.getInt("timeScheduleId");
                Request objE = new Request(idRequest, idMentee, idMentor, skillId, statusId, startWeek, endWeek, title, content, hour, reasonReject ,totalCost, timeScheduleId);
//                if (!objE.getStatusId() == 4 && !objE.getStatusId() == 5 && !objE.getStatusId() == 6) {
//
//                }
                return objE;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean updateratebyidreq(int id, int star, String comment, String time) {
        try {
            String strUPDATE = "UPDATE [dbo].[rate]\n"
                    + "   SET    \n"
                    + "       [star] = ?\n"
                    + "      ,[comment] = ?\n"
                    + "      ,[time] = ?\n"
                    + " WHERE idRequest = ?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setInt(1, star);
            stm.setString(2, comment);
            stm.setString(3, time);
            stm.setInt(4, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, log or throw a custom exception
            return false;
        }
    }

    public boolean changePassword(String username, String newPassword) {
        String query = "UPDATE account SET password = ? WHERE username = ? ";

        try ( PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newPassword);
            pstmt.setString(2, username);

            int rowsUpdated = pstmt.executeUpdate();

            return rowsUpdated > 0;
        } catch (Exception e) {
            System.out.println("Change Password: " + e.getMessage());
        }

        return false;
    }

    public Account getAccountByUsername(String username) {
        try {
            String strSelect = "SELECT * FROM dbo.account WHERE username = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setString(1, username);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String user = rs.getString(2);
                String email = rs.getString(3);
                String pass = rs.getString(4);
                String role = rs.getString(5);
                int confirm = rs.getInt(6);

                Account a = new Account(id, user, email, pass, role, confirm);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean addAccount(String user, String pass, String role, String email) {
        try {
            String sql = "  INSERT INTO dbo.account (username, password, role, email) VALUES (?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.setString(3, role);
            stm.setString(4, email);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean confirmAccount(String user) {
        try {
            String sql = "UPDATE dbo.account SET confirm=1\n"
                    + "WHERE username=?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, user);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean updatePassword(int id, String password) {
        try {
            String strUPDATE = "UPDATE dbo.account\n"
                    + "SET password = ?\n"
                    + "WHERE idAccount = ?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, password);
            stm.setInt(2, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("loi, ko update dc");
            return false;
        }
    }

    public boolean addMentor(int id, String fullname, String phone, String dob, String sex, String address, String registerDate) {
        try {
            String sql = "INSERT INTO dbo.mentor\n"
                    + "(\n"
                    + "    idMentor,\n"
                    + "    fullname,\n"
                    + "    phone,\n"
                    + "    dob,\n"
                    + "    sex,\n"
                    + "    address,\n"
                    + "registerDate\n"
                    + ")\n"
                    + "VALUES (?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, fullname);
            stm.setString(3, phone);
            stm.setString(4, dob);
            stm.setString(5, sex);
            stm.setString(6, address);
            stm.setString(7, registerDate);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean addMentee(int id, String fullname, String dob, String phone, String sex, String registerDate, String address) {
        try {
            String sql = "INSERT INTO dbo.mentee\n"
                    + "(\n"
                    + "    idMentee,\n"
                    + "    fullname,\n"
                    + "    dob,\n"
                    + "    phone,\n"
                    + "    sex,\n"
                    + "    registerDate,\n"
                    + "    address\n"
                    + ")\n"
                    + "VALUES (?,?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, fullname);
            stm.setString(3, dob);
            stm.setString(4, phone);
            stm.setString(5, sex);
            stm.setString(6, registerDate);
            stm.setString(7, address);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public List<Request> getAllRequesttbyID(int idMentor) {
        List<Request> list = new ArrayList<>();  // Initialize a new list

        String sql = "select * from request\n"
                + "         where idMentor = ?";
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idRequest = rs.getInt("idRequest");
                int idMentee = rs.getInt("idMentee");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int skillId = rs.getInt("skillId");
                int statusId = rs.getInt("statusId");
                int startWeek = rs.getInt("startWeek");
                int endWeek =rs.getInt("endWeek");
                float hour = rs.getFloat("hour");
                int totalCost=rs.getInt("totalCost");
                String reasonReject = rs.getString("reasonReject");
                int timeScheduleId=rs.getInt("timeScheduleId");
                Request objE = new Request(idRequest, idMentee, idMentor, skillId, statusId, startWeek, endWeek, title, content, hour, reasonReject ,totalCost, timeScheduleId);
                if (objE.getStatusId() != 4 && objE.getStatusId() != 5 && objE.getStatusId() != 6 ) {
                    list.add(objE);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting");
            // Handle the exception properly, logging or rethrowing if needed
        }
        return list;
    }

    public boolean updateRe(int id, String newStatus) {
        try {
            String strUPDATE = "UPDATE request SET status = ? WHERE idRequest = ?";
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, newStatus);
            stm.setInt(2, id);

            int rowsAffected = stm.executeUpdate();
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, log or throw a custom exception
            return false;
        }
    }

    // Update reject
    public boolean updateReason(int idRequest, String status, String newReasonReject) {
        try {
            // Câu lệnh SQL để cập nhật lý do từ chối và trạng thái
            String sql = "UPDATE request SET reasonReject = ?, status = ? WHERE idRequest = ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, newReasonReject);
            stm.setString(2, status);
            stm.setInt(3, idRequest);

            // Thực hiện câu lệnh SQL
            int rowsAffected = stm.executeUpdate();

            // Trả về true nếu có ít nhất một hàng được cập nhật
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace(); // Xử lý ngoại lệ một cách phù hợp, ghi log hoặc ném một ngoại lệ tùy chỉnh
            return false;
        } finally {
            // Đóng statement sau khi sử dụng
            if (stm != null) {
                try {
                    stm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//
    public List<News> get3news() {
        List<News> listnews = new ArrayList<>();
        try {
            String strSelect = "SELECT TOP 1 * FROM news;";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                News i = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));

                listnews.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listnews;
    }

    public List<News> getlastnews() {
        List<News> listnews = new ArrayList<>();
        try {
            String strSelect = "SELECT TOP 1 *\n"
                    + "FROM news\n"
                    + "ORDER BY newsid DESC;";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                News i = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));

                listnews.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listnews;
    }

    //
    public List<News> getsecondnews() {
        List<News> listnews = new ArrayList<>();
        try {
            String strSelect = "SELECT *\n"
                    + "FROM news\n"
                    + "ORDER BY newsID\n"
                    + "OFFSET 1 ROW\n"
                    + "FETCH NEXT 1 ROW ONLY;";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                News i = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));

                listnews.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listnews;
    }

    public List<Request> getAllRequestsByID(int idMentor) {
        List<Request> list = new ArrayList<>();  // Khởi tạo một danh sách mới

        String sql = "SELECT r.idRequest, r.idMentee, r.idMentor, m.fullname AS FullName, r.title, r.content, r.skill, r.status, r.startDate, r.endDate, r.hour\n"
                + "FROM request r\n"
                + "JOIN mentee m ON r.idMentee = m.idMentee\n"
                + "WHERE r.idMentor = ?";

        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();

            while (rs.next()) {
                int idRequest = rs.getInt("idRequest");
                int idMentee = rs.getInt("idMentee");
                String title = rs.getString("title");
                String content = rs.getString("content");
                int skillId = rs.getInt("skillId");
                int statusId = rs.getInt("statusId");
                int startWeek = rs.getInt("startWeek");
                int endWeek =rs.getInt("endWeek");
                float hour = rs.getFloat("hour");
                int totalCost=rs.getInt("totalCost");
                String reasonReject = rs.getString("reasonReject");
                int timeScheduleId=rs.getInt("timeScheduleId");
                Request objE = new Request(idRequest, idMentee, idMentor, skillId, statusId, startWeek, endWeek, title, content, hour, reasonReject ,totalCost, timeScheduleId);
                list.add(objE);

            }
        } catch (SQLException e) {
            System.out.println("Error when selecting");
            // Xử lý ngoại lệ một cách đúng đắn, ghi log hoặc ném lại nếu cần thiết
        } finally {
            // Đảm bảo đóng các tài nguyên, ví dụ: PreparedStatement, ResultSet
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
            } catch (SQLException e) {
                System.out.println("Error when closing resources");
            }
        }
        return list;
    }
//

    public Mentee MenteeinfoById(int id) {
        try {
            String sql = "SELECT a.idAccount, m.fullname, m.avatar, m.dob, m.phone, m.sex, m.address,a.email \n"
                    + "                    FROM mentee m \n"
                    + "                    JOIN account a ON m.idMentee = a.idAccount \n"
                    + "                    WHERE m.idMentee = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String dob = rs.getString(4);
                String phone = rs.getString(5);
                String sex = rs.getString(6);
                String address = rs.getString(7);
                String email = rs.getString(8);

                Mentee s = new Mentee(id, fullname, avatar, dob, phone, sex, address, email);
                return s;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    //   
    List<Mentor> listm = new ArrayList<>();

    public List<Mentor> getAllMentor() {
        String sql = "SELECT idMentor, fullname FROM mentor";
        try ( PreparedStatement stm = connection.prepareStatement(sql);  ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                Mentor mentorr = new Mentor(
                        rs.getInt("idMentor"),
                        rs.getString("fullname")
                );
                listm.add(mentorr);
            }
        } catch (SQLException e) {
            System.out.println("Error when selecting mentors: " + e.getMessage());
            e.printStackTrace();
        }
        return listm;
    }

    public boolean insertr(Rate r) {
        try {
            String sql = "INSERT INTO [dbo].[rate]\n"
                    + "           ([idRequest]\n"
                    + "           ,[idMentee]\n"
                    + "           ,[idMentor]\n"
                    + "           ,[star]\n"
                    + "           ,[comment]\n"
                    + "           ,[time])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, r.getIdRequest());
            stm.setInt(2, r.getIdMentee());
            stm.setInt(3, r.getIdMentor());
            stm.setInt(4, r.getStar());
            stm.setString(5, r.getComment());
            stm.setString(6, r.getTime());

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }
// LIST NEWS
    List<News> listnews = new ArrayList<>();

    public List<News> getAllnews() {
        try {
            String strSelect = "SELECT * \n"
                    + "FROM news\n"
                    + "ORDER BY eventYear, \n"
                    + "         CASE \n"
                    + "            WHEN eventMonth = 'January' THEN 1\n"
                    + "            WHEN eventMonth = 'February' THEN 2\n"
                    + "            WHEN eventMonth = 'March' THEN 3\n"
                    + "            WHEN eventMonth = 'April' THEN 4\n"
                    + "            WHEN eventMonth = 'May' THEN 5\n"
                    + "            WHEN eventMonth = 'June' THEN 6\n"
                    + "            WHEN eventMonth = 'July' THEN 7\n"
                    + "            WHEN eventMonth = 'August' THEN 8\n"
                    + "            WHEN eventMonth = 'September' THEN 9\n"
                    + "            WHEN eventMonth = 'October' THEN 10\n"
                    + "            WHEN eventMonth = 'November' THEN 11\n"
                    + "            WHEN eventMonth = 'December' THEN 12\n"
                    + "            ELSE 99 -- For unexpected cases\n"
                    + "         END,\n"
                    + "         eventDay;";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                News i = new News(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8), rs.getString(9));

                listnews.add(i);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listnews;
    }

    // list news id
    public News getNewsById(int id) {
        try {
            String sql = "SELECT * FROM news WHERE newsid = ?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                String content = rs.getString(3);
                String ImageURL = rs.getString(4);
                String PostDate = rs.getString(5);
                int eventday = rs.getInt(6);
                String Monthdate = rs.getString(7);
                int Yeardate = rs.getInt(8);
                String Summary = rs.getString(9);
                News s = new News(id, title, content, ImageURL, PostDate, eventday, Monthdate, Yeardate, Summary);

                return s;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Skill> ListAllSkill() {
        Connection conn = null;
        String query = "SELECT * FROM skill";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                listAllSkill.add(new Skill(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listAllSkill;

    }

     //Fatvv: get description by name
    public String getDesBySkill(String skillName) {
        String description = null;
        String sql = "SELECT skill_description FROM skill WHERE skillName = ?";

        try (Connection conn = new DBContext().connection;
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, skillName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                description = rs.getString("skill_description");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return description;
    }

    public String getUserNameById(int id) {
        String user = null;
        try {
            String sql = "SELECT username FROM dbo.account \n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                user = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("loi lay user bang id");
        }
        return user;
    }

    public boolean updateFav(int fav, int id) {
        Connection conn = null;
        String query = "UPDATE [dbo].[skill]\n"
                + "   SET \n"
                + "      [fav] = ?\n"
                + " WHERE id = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, fav);
            stm.setInt(2, id);
            stm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    public List<Skill> getSkillByFav(int fav) {
        List<Skill> listsfav = new ArrayList<>();
        Connection conn = null;
        String query = "select id, title, image, skillName,m.idMentor, m.fullname from skill s \n"
                + "join have_skill hv on s.id = hv.idSkill\n"
                + "join mentor m on m.idMentor = hv.idMentor\n"
                + "where fav = ?";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            stm.setInt(1, fav);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String title = rs.getString(2);
                String image = rs.getString(3);
                String skillname = rs.getString(4);
                int idMentor = rs.getInt(5);
                String name = rs.getString(6);

                Skill s = new Skill(id, idMentor, title, image, skillname, name);
                listsfav.add(s);
            }
        } catch (Exception e) {
        }
        return listsfav;
    }

    public Schedule getScheduleById(int id) {
        Schedule schedule = null;
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM schedule WHERE schedule_id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                schedule = new Schedule(
                        rs.getInt("schedule_id"),
                        rs.getInt("mentor_schedule_id"),
                        rs.getInt("mentee_schedule_id"),
                        rs.getInt("time_schedule_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }

    public List<Schedule> getAllSchedules() {
        List<Schedule> schedules = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM schedule")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule(
                        rs.getInt("schedule_id"),
                        rs.getInt("mentor_schedule_id"),
                        rs.getInt("mentee_schedule_id"),
                        rs.getInt("time_schedule_id")
                );
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    public int addSchedule(Schedule schedule) {
        int generatedId = -1;
        try (PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO schedule(mentor_schedule_id, mentee_schedule_id, time_schedule_id) VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, schedule.getMentorScheduleId());
            stmt.setInt(2, schedule.getMenteeScheduleId());
            stmt.setInt(3, schedule.getTimeScheduleId());
            stmt.executeUpdate();
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return generatedId;
    }

    public void updateSchedule(Schedule schedule) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "UPDATE schedule SET mentor_schedule_id = ?, mentee_schedule_id = ?, time_schedule_id = ? WHERE schedule_id = ?")) {
            stmt.setInt(1, schedule.getMentorScheduleId());
            stmt.setInt(2, schedule.getMenteeScheduleId());
            stmt.setInt(3, schedule.getTimeScheduleId());
            stmt.setInt(4, schedule.getScheduleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSchedule(int id) {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM schedule WHERE schedule_id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DAO dao = new DAO();

        System.out.println(dao.getreportReq());
    }
}
