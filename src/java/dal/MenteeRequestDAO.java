/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Have_SKill;
import model.Request;
import model.ScheduleRequest;
import model.Skill;
import model.TimeSchedule;
import model.Time_Slot;

/**
 *
 * @author admin
 */
public class MenteeRequestDAO extends DBContext {

    public ArrayList<Time_Slot> getAllSlot() {
        ArrayList<Time_Slot> lts = new ArrayList<>();
        String sql = "select * from time_slot";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Time_Slot ts = new Time_Slot(rs.getInt("time_slot_id"), rs.getString("time"));
                lts.add(ts);
            }
            return lts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TimeSchedule> getFreeScheduleOfMentor(int idMentor) {
        ArrayList<TimeSchedule> listFreeTimeScheduleOfMentor = new ArrayList<>();
        String sql = "select distinct * \n"
                + "from timeSchedule ts\n"
                + "join scheduleRequest sr on sr.timeScheduleId = ts.timeScheduleId\n"
                + "where sr.mentor_id = ? and status = 2";
        ArrayList<TimeSchedule> listAllTimeScheduleOfMentor = new ArrayList<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentor);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TimeSchedule ts = new TimeSchedule();
                ts.setTimeScheduleId(rs.getInt("timeScheduleId"));
                ts.setYear(rs.getInt("year"));
                ts.setWeek(rs.getInt("week"));
                ts.setDay(rs.getString("day"));
                ts.setSlotId(rs.getInt("slotId"));
                listAllTimeScheduleOfMentor.add(ts);
            }
            ArrayList<TimeSchedule> listRegisteredTimeScheduleOfMentor = getRegisteredTimeScheduleOfMentor(idMentor);
            for (TimeSchedule tsA : listAllTimeScheduleOfMentor) {
                if (!checkRegisteredTimeScheduleOfMentor(listRegisteredTimeScheduleOfMentor, tsA)) {
                    listFreeTimeScheduleOfMentor.add(tsA);
                }
            }
            return listFreeTimeScheduleOfMentor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TimeSchedule> getFreeScheduleOfMentorIn1Week(int idMentor) {
        ArrayList<TimeSchedule> listFreeTimeScheduleOfMentor = new ArrayList<>();
        String sql = "WITH DistinctTimeSlots AS (\n"
                + "    SELECT \n"
                + "        ts.day, \n"
                + "        ts.slotId,\n"
                + "        MIN(ts.timeScheduleId) AS timeScheduleId\n"
                + "    FROM timeSchedule ts\n"
                + "    JOIN scheduleRequest sr ON sr.timeScheduleId = ts.timeScheduleId\n"
                + "    WHERE sr.mentor_id = ? AND sr.status = 2\n"
                + "    GROUP BY ts.day, ts.slotId\n"
                + ")\n"
                + "SELECT \n"
                + "    ts.timeScheduleId,\n"
                + "    ts.year,\n"
                + "    ts.week,\n"
                + "    ts.day,\n"
                + "    ts.slotId\n"
                + "FROM timeSchedule ts\n"
                + "JOIN DistinctTimeSlots dts ON ts.timeScheduleId = dts.timeScheduleId;";
        ArrayList<TimeSchedule> listAllTimeScheduleOfMentor = new ArrayList<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentor);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TimeSchedule ts = new TimeSchedule();
                ts.setTimeScheduleId(rs.getInt("timeScheduleId"));
                ts.setYear(rs.getInt("year"));
                ts.setWeek(rs.getInt("week"));
                ts.setDay(rs.getString("day"));
                ts.setSlotId(rs.getInt("slotId"));
                listAllTimeScheduleOfMentor.add(ts);
            }
            ArrayList<TimeSchedule> listRegisteredTimeScheduleOfMentor = getRegisteredTimeScheduleOfMentor(idMentor);
            for (TimeSchedule tsA : listAllTimeScheduleOfMentor) {
                if (!checkRegisteredTimeScheduleOfMentor(listRegisteredTimeScheduleOfMentor, tsA)) {
                    listFreeTimeScheduleOfMentor.add(tsA);
                }
            }
            return listFreeTimeScheduleOfMentor;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean checkRegisteredTimeScheduleOfMentor(ArrayList<TimeSchedule> lts, TimeSchedule ts) {
        for (TimeSchedule t : lts) {
            if (t.getTimeScheduleId() == ts.getTimeScheduleId()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<TimeSchedule> getRegisteredTimeScheduleOfMentor(int idMentor) {
        String sql = "SELECT ts.*\n"
                + "FROM scheduleRequest sr\n"
                + "JOIN timeSchedule ts ON sr.timeScheduleId = ts.timeScheduleId\n"
                + "JOIN request r ON r.timeScheduleId = sr.timeScheduleId and sr.mentor_id = r.idMentor\n"
                + "WHERE sr.mentor_id = ? AND sr.status = 2 AND r.statusId = 10;";
        ArrayList<TimeSchedule> list = new ArrayList<>();
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentor);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TimeSchedule ts = new TimeSchedule();
                ts.setTimeScheduleId(rs.getInt("timeScheduleId"));
                ts.setYear(rs.getInt("year"));
                ts.setWeek(rs.getInt("week"));
                ts.setDay(rs.getString("day"));
                ts.setSlotId(rs.getInt("slotId"));
                list.add(ts);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Have_SKill> getListSkillOfMentor(int mentorId) {
        ArrayList<Have_SKill> list = new ArrayList<>();
        String sql = "select hs.*, s.skillName\n"
                + "from Mentor as m \n"
                + "join have_skill hs on m.idMentor = hs.idMentor\n"
                + "join skill s on hs.idSkill = s.id\n"
                + "where m.idMentor = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, mentorId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Have_SKill hs = new Have_SKill();
                hs.setIdMentor(mentorId);
                hs.setIdSkill(rs.getInt("idSkill"));
                hs.setSkillname(rs.getString("skillName"));
                list.add(hs);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TimeSchedule getTimeScheduleByInformation(int year, int week, String day, int slotId) {
        TimeSchedule ts = new TimeSchedule();
        String sql = "select * from TimeSchedule\n"
                + "where year = ? and week = ? and day = ? and slotId = ? ";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, year);
            pre.setInt(2, week);
            pre.setString(3, day);
            pre.setInt(4, slotId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ts.setTimeScheduleId(rs.getInt("timeScheduleId"));
                ts.setYear(rs.getInt("year"));
                ts.setWeek(rs.getInt("week"));
                ts.setDay(rs.getString("day"));
                ts.setSlotId(rs.getInt("slotId"));
            }
            return ts;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addMenteeRequest(Request request) {
        String sql = "INSERT INTO request(idMentee, idMentor, title, content, skillId, statusId, timeScheduleId, startWeek, endWeek, hour, reasonReject, totalCost) VALUES \n"
                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, request.getIdMentee());
            pre.setInt(2, request.getIdMentor());
            pre.setString(3, request.getTitle());
            pre.setString(4, request.getContent());
            pre.setInt(5, request.getSkillId());
            pre.setInt(6, request.getStatusId());
            pre.setInt(7, request.getTimeScheduleId());
            pre.setInt(8, request.getStartWeek());
            pre.setInt(9, request.getEndWeek());
            pre.setFloat(10, request.getHour());
            pre.setString(11, request.getReasonReject());
            pre.setInt(12, request.getTotalCost());

            int affectedRows = pre.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        MenteeRequestDAO dao = new MenteeRequestDAO();
        Request r = new Request();
        r.setIdMentee(7);
        r.setIdMentor(1);
        r.setTitle("Gia su");
        r.setContent("Pass C+++");
        r.setSkillId(1);
        r.setStatusId(1);
        r.setTimeScheduleId(10);
        r.setStartWeek(12);
        r.setEndWeek(13);
        r.setHour(1);
        r.setTotalCost(10000 * (13 - 12));
        System.out.println(dao.addMenteeRequest(r));
    }
}


