/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Account;
import model.Have_SKill;
import model.Mentor;
import model.Request;
import model.Skill;
import model.SkillMentor;
import model.*;

/**
 *
 * @author admin
 */
public class MentorDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<Mentor> listMentor = new ArrayList<>();
    List<Have_SKill> listhskill = new ArrayList<>();
    List<info> listinfo = new ArrayList<>();
    List<SkillMentor> skill = new ArrayList<>();
    List<Time_Slot> time_slot = new ArrayList<>();
    List<ScheduleRequest> scheduleRequests = new ArrayList<>();

    public boolean deleteMentorbyhaveskill(int idMentor) {
        try {
            String sql = "DELETE FROM [dbo].[have_skill]\n"
                    + "      WHERE idMentor=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        } finally {
            // Close the connection here if necessary
        }
    }

    public List<SkillMentor> getAllskill() {
        try {

            String strSelect = "select * \n"
                    + "from skill";

            stm = connection.prepareStatement(strSelect);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tiltle = rs.getString(2);
                String image = rs.getString(3);
                String skillName = rs.getString(4);
                String Skill_description = rs.getString(5);
                String status = rs.getString(6);
                SkillMentor a = new SkillMentor(id, tiltle, image, skillName, Skill_description, status);
                skill.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return skill;
    }

    public Skill getSkillNameWithId(String skillName) {
        try {
            String sql = "SELECT id FROM skill WHERE skillName = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, skillName);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                // Assuming you have a Skill class with constructor taking id and name
                return new Skill(id, skillName);
            }
        } catch (SQLException e) {
            // Handle exception appropriately
            e.printStackTrace();
        } finally {
            // Close resources if necessary
        }
        return null; // Return null if no skill found with the given name
    }

    public boolean updateCV(int id_Mentor, String fullname, String avatar, String phone, String dob, String sex, String address, String profession, String pro_introduc,
            String archivement_descition, String framework, String experience, String education, String myservice, int cost, String STK) {
        try {

            String strUPDATE = "UPDATE [dbo].[mentor]\n"
                    + "SET \n"
                    + "    [fullname] = ?,\n"
                    + "    [avatar] = ?,\n"
                    + "    [phone] = ?,\n"
                    + "    [dob] = ?,\n"
                    + "    [sex] = ?,\n"
                    + "    [address] = ?,\n"
                    + "    [profession] = ?,\n"
                    + "    [pro_introduc] = ?,\n"
                    + "    [archivement_descition] = ?,\n"
                    + "    [framework] = ?,\n"
                    + "    [experience] = ?,\n"
                    + "    [education] = ?,\n"
                    + "    [myservice] = ?,\n"
                    + "    [stk] = ?,\n"
                    + "    [cost] = ?\n"
                    + "WHERE idMentor = ?;";
            PreparedStatement stm;
            stm = connection.prepareStatement(strUPDATE);
            stm.setString(1, fullname);
            stm.setString(2, avatar);
            stm.setString(3, phone);
            stm.setString(4, dob);
            stm.setString(5, sex);
            stm.setString(6, address);

            stm.setString(7, profession);
            stm.setString(8, pro_introduc);
            stm.setString(9, archivement_descition);
            stm.setString(10, framework);
            stm.setString(11, experience);
            stm.setString(12, education);
            stm.setString(13, myservice);
            stm.setString(14, STK);
            stm.setInt(15, cost);
            stm.setInt(16, id_Mentor);
            stm.executeUpdate();

            //stm2.executeUpdate();
        } catch (SQLException e) {
            System.out.println("loi, ko update dc");
            return false;
        }
        return true;

    }

    public Mentor getIDMentor(int IdMentor) {
        try {
            String strSelect = "select * from mentor where idMentor = ?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String phone = rs.getString(4);

                String dob = rs.getString(5);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                // Chuyển đổi ngày sinh từ chuỗi sang LocalDate
                LocalDate ngaySinh = LocalDate.parse(dob, formatter);

                // Lấy ngày hiện tại
                LocalDate ngayHienTai = LocalDate.now();

                // Tính tuổi
                Period period = Period.between(ngaySinh, ngayHienTai);

                String sex = rs.getString(6);
                String address = rs.getString(7);
                String registerDate = rs.getString(8);
                String profession = rs.getString(9);
                String pro_introduc = rs.getString(10);
                String archivement_sescition = rs.getString(11);
                String framework = rs.getString(12);
                String experience = rs.getString(13);
                String education = rs.getString(14);
                String myservice = rs.getString(15);
                int age = period.getYears();
                String STK = rs.getString(16);
                int cost = rs.getInt(17);

                Mentor a = new Mentor(idMentor, fullname, avatar, phone, dob, sex, address, registerDate, profession, pro_introduc, archivement_sescition, framework, experience, education, myservice, age, STK, cost);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Mentor> getListOfMentors() {
        List<Mentor> mentors = new ArrayList();
        String query = "SELECT * FROM mentor";

        try ( PreparedStatement pstmt = connection.prepareStatement(query)) {

            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Mentor mentor = mapResultSetToMentor(resultSet);
                mentors.add(mentor);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving mentors" + e.getMessage());
        }

        return mentors;
    }

    private Mentor mapResultSetToMentor(ResultSet resultSet) throws Exception {
        return new Mentor(
                resultSet.getInt("idMentor"),
                resultSet.getString("fullname"),
                resultSet.getString("avatar"),
                resultSet.getString("phone"),
                resultSet.getString("dob"),
                resultSet.getString("sex"),
                resultSet.getString("address"),
                resultSet.getString("registerDate"),
                resultSet.getString("profession"),
                resultSet.getString("pro_introduc"),
                resultSet.getString("archivement_descition"),
                resultSet.getString("framework"),
                resultSet.getString("experience"),
                resultSet.getString("education"),
                resultSet.getString("myservice"),
                resultSet.getInt("stk")
        );
    }

    public SkillMentor skill() {
        try {
            String strSelect = "select * \n"
                    + "from skill";

            stm = connection.prepareStatement(strSelect);

            while (rs.next()) {
                int id = rs.getInt(1);
                String tiltle = rs.getString(2);

                String image = rs.getString(3);
                String skillName = rs.getString(4);
                String Skill_description = rs.getString(5);
                String status = rs.getString(6);
                SkillMentor a = new SkillMentor(id, tiltle, image, skillName, Skill_description, status);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Have_SKill> getidhaveskill(int IdMentor) {
        try {
            String strSelect = "select idMentor,idSkill,skillName \n"
                    + "from have_skill join skill on have_skill.idSkill = skill.id \n"
                    + "where have_skill.idMentor=?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                int idSkill = rs.getInt(2);

                String skillname = rs.getString(3);

                Have_SKill a = new Have_SKill(idMentor, idSkill, skillname);
                listhskill.add(a);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listhskill;
    }

    public info info() {
        try {
            String strSelect = "select * from info where idMentor = 6";

            stm = connection.prepareStatement(strSelect);

            rs = stm.executeQuery();
            while (rs.next()) {
                int idInfo = rs.getInt(1);
                int idMentor = rs.getInt(2);
                String link = rs.getString(3);
                info a = new info(idInfo, idMentor, link);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public info getIdinfo(int IdMentor) {
        try {
            String strSelect = "select * from info where idMentor = ?";

            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, IdMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int idInfo = rs.getInt(1);
                int idMentor = rs.getInt(2);
                String link = rs.getString(3);
                info a = new info(idInfo, idMentor, link);
                return a;
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public Account getAccountByid(int idAccount) {
        try {
            String strSelect = "SELECT * FROM dbo.account WHERE idAccount = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, idAccount);
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

    public boolean addHave_Skill(int idmentor, int idskill) {
        try {
            String strSelect = "  INSERT INTO [dbo].[have_skill] ([idMentor], [idSkill])\n"
                    + "VALUES (?, ?);\n"
                    + "                           ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, idmentor);
            stm.setInt(2, idskill);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public List<Mentor> listMentorBySkill(String skillName) {
        List<Mentor> mentors = new ArrayList<>();
        try {
            String sql = "SELECT mentor.idMentor,fullname,username,idSkill,skillName\n"
                    + "FROM dbo.account JOIN dbo.mentor ON mentor.idMentor = account.idAccount\n"
                    + "JOIN dbo.have_skill ON have_skill.idMentor = mentor.idMentor\n"
                    + "JOIN dbo.skill ON skill.id = have_skill.idSkill\n"
                    + "WHERE skillName like ?";
            stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + skillName + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                int idMentor = rs.getInt(1);
                String fullname = rs.getString(2);
                String user = rs.getString(3);
                int idSkill = rs.getInt(4);
                String nameSkill = rs.getString(5);

//                Mentor m = new Mentor(idMentor, fullname, rate, user, totalRequest, totalInvite, idSkill, nameSkill);
//                mentors.add(new Mentor(idMentor, fullname, rate, user, totalRequest, totalInvite, idSkill, nameSkill));
                mentors.add(new Mentor(idMentor, fullname, user, idSkill, nameSkill));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi ham listMentorBySkill");
        }
        return mentors;
    }

    public float getRate(int idMentor) {
        float sum = 0;
        int count = 0;
        try {
            String sql = "SELECT * FROM dbo.rate \n"
                    + "WHERE idMentor=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                sum += rs.getInt(5);
                count++;
            }
            return (float) (sum / count);
        } catch (Exception e) {
            return 0;
        }
    }

    public List<Rate> getRatesByMentorId(int idMentor) {
        List<Rate> rates = new ArrayList<>();
        String sql = "SELECT idRate, idRequest, idMentee, star, comment FROM rate WHERE idMentor = ?";

        try ( PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idMentor);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Rate rate = new Rate();
                rate.setIdRate(rs.getInt("idRate"));
                rate.setIdRequest(rs.getInt("idRequest"));
                rate.setIdMentee(rs.getInt("idMentee"));
                rate.setStar(rs.getInt("star"));
                rate.setComment(rs.getString("comment"));
                rates.add(rate);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return rates;
    }

    public int totalRequest(int idMentor) {
        int totalRequest = 0;
        try {
            String sql = "SELECT COUNT(idRequest) FROM dbo.request\n"
                    + "WHERE idMentor=? ";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            if (rs.next()) {
                totalRequest = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ko lay duoc total request");
        }
        return totalRequest;
    }

    public int totalInvite(int idMentor) {
        int total = 0;
        try {
            String sql = "SELECT COUNT(idRequest) FROM dbo.request\n"
                    + "WHERE idMentor=?  AND status='Open'";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ko lay dc total invite");
        }
        return total;
    }

    public List<Mentor> getMentor() {
        Connection conn = null;
        List<Mentor> listMentor1 = new ArrayList<>();
        String query = "SELECT idMentor, fullname from mentor";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                listMentor1.add(new Mentor(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listMentor1;
    }

    public List<Skill> getSkill() {
        Connection conn = null;
        List<Skill> list1 = new ArrayList<>();
        String query = "SELECT * from Skill";
        try {
            conn = new DBContext().connection;
            stm = conn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                list1.add(new Skill(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
            System.out.println(e);

        }
        return list1;
    }

    public List<Request> ListRequestById(int idMentor) {
        List<Request> list5 = new ArrayList<>();
        Connection conn = null;
        String query = "SELECT * "
                + "FROM request r JOIN account a ON r.idMentor = a.idAccount "
                + "WHERE a.idAccount =  ? ";

        PreparedStatement _stm;
        ResultSet rs;
        try {
            conn = new DBContext().connection;
            _stm = conn.prepareStatement(query);
            _stm.setInt(1, idMentor);
            rs = _stm.executeQuery();
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
                list5.add(new Request(idRequest, idMentee, idMentor, skillId, statusId, startWeek, endWeek, title, content, hour, reasonReject ,totalCost, timeScheduleId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list5;
    }

    public Mentor getIdMtor(int idmentor) {
        try {
            String strSelect = "select idMentor, fullname, avatar,dob, sex , [address]   from mentor where idMentor = ? ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, idmentor);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String avatar = rs.getString(3);
                String dob = rs.getString(4);
                String sex = rs.getString(5);
                String address = rs.getString(6);

                Mentor a = new Mentor(idmentor, fullname, avatar, dob, sex, address);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Time_Slot> listTimeSlot() {
        try {
            String strSelect = "SELECT * FROM time_slot";
            stm = connection.prepareStatement(strSelect);
            rs = stm.executeQuery();
            while (rs.next()) {
                int time_slot_id = rs.getInt(1);
                String time = rs.getString(2);
                Time_Slot t = new Time_Slot(time_slot_id, time);
                time_slot.add(t);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return time_slot;
    }

    public Time_Slot getSlotByID(int timeSlotID) {
        try {
            String strSelect = "select * from time_slot where time_slot.time_slot_id= ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, timeSlotID);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String timeSlot = rs.getString(2);
                Time_Slot t = new Time_Slot(id, timeSlot);
                return t;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public boolean addSchedule(int idmentor, int time_slot_id, String day) {
        try {

            String strSelect = "  INSERT INTO [dbo].[schedule] ([mentor_id], [time_slot_id], [day] )\n"
                    + "VALUES (?, ?, ?);\n"
                    + "                           ";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, idmentor);
            stm.setInt(2, time_slot_id);
            stm.setString(3, day);

            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean deleteScheduleMentor(int idmentor) {
        try {
            String strDelete = "DELETE [dbo.schedule] WHERE [mentor_id] = ?";
            stm = connection.prepareStatement(strDelete);
            stm.setInt(1, idmentor);
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();

            return rowsAffected > 0;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public MentorSchedule getMentorScheduleById(int id) {
        MentorSchedule mentorSchedule = null;
        try ( PreparedStatement stmt = connection.prepareStatement("SELECT * FROM mentor_schedule WHERE mentorSchedule_id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                mentorSchedule = new MentorSchedule(
                        rs.getInt("mentorSchedule_id"),
                        rs.getInt("idMentor"),
                        rs.getInt("timeSchedule_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentorSchedule;
    }

    public List<MentorSchedule> getAllMentorSchedules() {
        List<MentorSchedule> mentorSchedules = new ArrayList<>();
        try ( PreparedStatement stmt = connection.prepareStatement("SELECT * FROM mentor_schedule")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MentorSchedule mentorSchedule = new MentorSchedule(
                        rs.getInt("mentorSchedule_id"),
                        rs.getInt("idMentor"),
                        rs.getInt("timeSchedule_id")
                );
                mentorSchedules.add(mentorSchedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mentorSchedules;
    }

    public int addMentorSchedule(MentorSchedule mentorSchedule) {
        int generatedId = -1;
        try ( PreparedStatement stmt = connection.prepareStatement(
                "INSERT INTO mentor_schedule(idMentor, timeSchedule_id, skill_id) VALUES (?, ?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, mentorSchedule.getIdMentor());
            stmt.setInt(2, mentorSchedule.getTimeScheduleId());
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

    public void updateMentorSchedule(MentorSchedule mentorSchedule) {
        try ( PreparedStatement stmt = connection.prepareStatement(
                "UPDATE mentor_schedule SET idMentor = ?, timeSchedule_id = ?, skill_id = ? WHERE mentorSchedule_id = ?")) {
            stmt.setInt(1, mentorSchedule.getIdMentor());
            stmt.setInt(2, mentorSchedule.getTimeScheduleId());
            stmt.setInt(4, mentorSchedule.getMentorScheduleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMentorSchedule(int id) {
        try ( PreparedStatement stmt = connection.prepareStatement("DELETE FROM mentor_schedule WHERE mentorSchedule_id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addScheduleRequest(ScheduleRequest scheduleRequest) {
        try {
            String add = "INSERT INTO scheduleRequest(mentor_id, timeScheduleId, status) VALUES (?, ?, ?)";
            stm = connection.prepareStatement(add);
            stm.setInt(1, scheduleRequest.getMentorId());
            stm.setInt(2, scheduleRequest.getTimeScheduleId());
            stm.setInt(3, scheduleRequest.getStatus());
            int rowsAffected = stm.executeUpdate();
            stm.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getAvatar(int idMentor) {
        String avatar = null;
        try {
            String query = "SELECT avatar FROM mentor WHERE idMentor = ?";
            stm = connection.prepareStatement(query);
            stm.setInt(1, idMentor);
            rs = stm.executeQuery();
            if (rs.next()) {
                avatar = rs.getString("avatar");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return avatar;
    }

    public void deleteRequestSchedule(int id) {
        try ( PreparedStatement stmt = connection.prepareStatement("DELETE FROM scheduleRequest WHERE mentor_id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ScheduleRequest> listScheduleRequests(int id) {
        List<ScheduleRequest> list = new ArrayList<>();
        try {
            String strSelect = "SELECT * FROM scheduleRequest WHERE status = 0 AND mentor_id = ?";
            stm = connection.prepareStatement(strSelect);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                int mentorId = rs.getInt(1);
                int timeScheduleId = rs.getInt(2);
                int status = rs.getInt(3);
                ScheduleRequest s = new ScheduleRequest(mentorId, timeScheduleId, status);
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) {

    }

}
