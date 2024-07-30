/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Request;
import model.TimeSchedule;
import model.Time_Slot;
import model.Mentee;
import model.Mentor;
import model.Skill;

/**
 *
 * @author admin
 */
public class HandleRequestDAO extends DBContext {

    public Time_Slot getTimeSlotById(int slotId) {
        String sql = "select * from time_slot where time_slot_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, slotId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Time_Slot ts = new Time_Slot(rs.getInt("time_slot_id"), rs.getString("time"));
                return ts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TimeSchedule getTimeScheduleById(int timeScheduleId) {
        String sql = "select * from timeschedule where timescheduleid = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, timeScheduleId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                TimeSchedule ts = new TimeSchedule(rs.getInt("year"), rs.getInt("week"), rs.getString("day"), getTimeSlotById(rs.getInt("slotId")));
                return ts;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Mentee getMenteeById(int idMentee) {
        Mentee mt = new Mentee();
        String sql = "select * from mentee where idMentee = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentee);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                mt.setIdMentee(rs.getInt("idMentee"));
                mt.setFullname(rs.getString("fullname"));
            }
            return mt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Skill getSkillById(int skillId) {
        Skill sk = new Skill();
        String sql = "select * from skill where id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, skillId);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                sk.setSkillName(rs.getString("skillName"));
            }
            return sk;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Request> getAllRequestNeedHandle(int idMentor, int statusId) {
        ArrayList<Request> list = new ArrayList<>();
        String sql = "select idRequest, idMentee, idMentor, title, content, skillId, statusId, r.timeScheduleId, startWeek, endWeek, hour, reasonReject, totalCost FROM request r\n"
                + "join timeSchedule t on r.timeScheduleId = t.timeScheduleId\n"
                + "WHERE idMentor = ? AND statusId = ? and t.week = r.startWeek";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentor);
            stm.setInt(2, statusId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Request r = new Request();
                r.setIdRequest(rs.getInt("idRequest"));
                r.setStatusId(rs.getInt("statusId"));
                r.setStartWeek(rs.getInt("startWeek"));
                r.setEndWeek(rs.getInt("endWeek"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setHour(rs.getFloat("hour"));
                r.setReasonReject(rs.getString("reasonReject"));
                r.setTotalCost(rs.getInt("totalCost"));
                r.setMentee(getMenteeById(rs.getInt("idMentee")));
                r.setSkill(getSkillById(rs.getInt("skillId")));
                r.setTimeSchedule(getTimeScheduleById(rs.getInt("timeScheduleId")));
                r.setTimeScheduleId(rs.getInt("timeScheduleId"));
                list.add(r);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Request> getListByPage(ArrayList<Request> list, int start, int end) {
        if (!list.isEmpty()) {
            ArrayList<Request> arr = new ArrayList<>();
            for (int i = start; i < end; i++) {
                arr.add(list.get(i));
            }
            return arr;
        }
        return null;
    }

    public Request getRequestById(int idRequest) {
        Request r = new Request();
        String sql = "select * from request\n"
                + "where idRequest = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, idRequest);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                r.setIdRequest(rs.getInt("idRequest"));
                r.setSkillId(rs.getInt("skillId"));
                r.setStatusId(rs.getInt("statusId"));
                r.setStartWeek(rs.getInt("startWeek"));
                r.setEndWeek(rs.getInt("endWeek"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setHour(rs.getFloat("hour"));
                r.setReasonReject(rs.getString("reasonReject"));
                r.setTotalCost(rs.getInt("totalCost"));
                r.setMentee(getMenteeById(rs.getInt("idMentee")));
                r.setSkill(getSkillById(rs.getInt("skillId")));
                r.setTimeSchedule(getTimeScheduleById(rs.getInt("timeScheduleId")));
                r.setTimeScheduleId(rs.getInt("timeScheduleId"));
                r.setIdMentor(rs.getInt("idMentor"));
                r.setIdMentee(rs.getInt("idMentee"));
                r.setMentor(getMentorById(rs.getInt("idMentor")));
            }
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Request> getRequestByIdMentorAndSkillId(int idMentee, int idMentor, int skillId) {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM request WHERE idMentee=? AND idMentor = ? AND skillId = ?  AND statusId = 2";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentee);
            stm.setInt(2, idMentor);
            stm.setInt(3, skillId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Request r = new Request();
                r.setIdRequest(rs.getInt("idRequest"));
                r.setStatusId(rs.getInt("statusId"));
                r.setStartWeek(rs.getInt("startWeek"));
                r.setEndWeek(rs.getInt("endWeek"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setHour(rs.getFloat("hour"));
                r.setReasonReject(rs.getString("reasonReject"));
                r.setTotalCost(rs.getInt("totalCost"));
                r.setMentee(getMenteeById(rs.getInt("idMentee")));
                r.setSkill(getSkillById(rs.getInt("skillId")));
                r.setTimeSchedule(getTimeScheduleById(rs.getInt("timeScheduleId")));
                r.setTimeScheduleId(rs.getInt("timeScheduleId"));
                r.setIdMentor(rs.getInt("idMentor"));
                r.setIdMentee(rs.getInt("idMentee"));
                list.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void RejectRequestDuplicate(int idMentee, int idRequest) {
        String sql = "UPDATE request\n"
                + "SET statusId = 3, reasonReject = 'Time schedule has been booked!'\n"
                + "where idMentee != ? and ? <= startWeek and endWeek <= ? and timeScheduleId = ? and statusId = 1";
        try {
            Request r = getRequestById(idRequest);
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentee);
            pre.setInt(2, r.getStartWeek());
            pre.setInt(3, r.getEndWeek());
            pre.setInt(4, r.getTimeScheduleId());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getListTimeScheduleBy(int idMentee, int skillId, int startWeek, int endWeek) {
        ArrayList<Integer> list = new ArrayList<>();
        String sql = "select * from request\n"
                + "where idMentee = ? and skillId = ? and startWeek = ? and endWeek = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentee);
            pre.setInt(2, skillId);
            pre.setInt(3, startWeek);
            pre.setInt(4, endWeek);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int timeScheduleId = rs.getInt("timeScheduleId");
                list.add(timeScheduleId);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateManyRequest(int idMentee, int skillId, int statusId, int startWeek, int endWeek, String reasonReject) {
        String sql = "UPDATE request\n"
                + "SET statusId = ?, reasonReject = ?\n"
                + "where idMentee = ? and skillId = ? and startWeek = ? and endWeek = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, statusId);
            pre.setString(2, reasonReject);
            pre.setInt(3, idMentee);
            pre.setInt(4, skillId);
            pre.setInt(5, startWeek);
            pre.setInt(6, endWeek);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusRequest(int idRequest, int statusId, String reasonReject) {
        Request r = getRequestById(idRequest);
        if (statusId == 2) {
            updateManyRequest(r.getIdMentee(), r.getSkillId(), statusId, r.getStartWeek(), r.getEndWeek(), null);
            ArrayList<Integer> list = getListTimeScheduleBy(r.getIdMentee(), r.getSkillId(), r.getStartWeek(), r.getEndWeek());
            for (int i = 0; i < list.size(); i++) {
                RejectRequestDuplicate(r.getIdMentee(), list.get(i));
            }
        }
        if (statusId == 3 || statusId == 11 || statusId == 12 || statusId == 10) {
            updateManyRequest(r.getIdMentee(), r.getSkillId(), statusId, r.getStartWeek(), r.getEndWeek(), reasonReject);
        }
    }
    // Các hàm bên dưới là của MenteeHandleRequest

    public ArrayList<Request> getRequestByStatusOfMentee(int idMentee, int statusId) {
        ArrayList<Request> list = new ArrayList<>();
        String sql = "select idRequest, idMentee, idMentor, title, content, skillId, statusId, r.timeScheduleId, startWeek, endWeek, hour, reasonReject, totalCost FROM request r\n"
                + "join timeSchedule t on r.timeScheduleId = t.timeScheduleId\n"
                + "WHERE idMentee = ? AND statusId = ? and t.week = r.startWeek";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, idMentee);
            stm.setInt(2, statusId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Request r = new Request();
                r.setIdRequest(rs.getInt("idRequest"));
                r.setStatusId(rs.getInt("statusId"));
                r.setStartWeek(rs.getInt("startWeek"));
                r.setEndWeek(rs.getInt("endWeek"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setHour(rs.getFloat("hour"));
                r.setReasonReject(rs.getString("reasonReject"));
                r.setTotalCost(rs.getInt("totalCost"));
                r.setMentor(getMentorById(rs.getInt("idMentor")));
                r.setSkill(getSkillById(rs.getInt("skillId")));
                r.setTimeSchedule(getTimeScheduleById(rs.getInt("timeScheduleId")));
                r.setTimeScheduleId(rs.getInt("timeScheduleId"));
                list.add(r);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Mentor getMentorById(int idMentor) {
        Mentor mt = new Mentor();
        String sql = "select * from mentor where idMentor = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentor);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                mt.setIdMentor(rs.getInt("idMentor"));
                mt.setFullname(rs.getString("fullname"));
            }
            return mt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void PaymentManyRequest(int idMentee, int idMentor, int skillId) {
        String sql = "UPDATE request\n"
                + "SET statusId = 10\n"
                + "where idMentee = ? and idMentor = ? and skillId = ? and statusId = 2";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentee);
            pre.setInt(2, idMentor);
            pre.setInt(3, skillId);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void cancelManyRequest(int idRequest) {
        String sql = "UPDATE request\n"
                + "SET statusId = 4\n"
                + "where idRequest = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idRequest);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Request> getListRequestForManager() {
        ArrayList<Request> list = new ArrayList<>();
        String sql = "SELECT idRequest, idMentee, idMentor, title, content, skillId, statusId, slots, startWeek, endWeek, hour, reasonReject, totalCost\n"
                + "FROM (\n"
                + "    SELECT \n"
                + "        STRING_AGG(CAST(r.idRequest AS VARCHAR), ',') AS idRequest, r.idMentee, r.idMentor, r.title, r.content, r.skillId, r.statusId, STRING_AGG(s.time, ',') AS slots, r.startWeek, r.endWeek, SUM((r.hour * (CAST(r.endWeek AS INT) - CAST(r.startWeek AS INT) + 1))/(CAST(r.endWeek AS INT) - CAST(r.startWeek AS INT) + 1)) AS hour, r.reasonReject, SUM(r.totalCost) AS totalCost\n"
                + "    FROM \n"
                + "        request r\n"
                + "    JOIN \n"
                + "        timeSchedule t ON r.timeScheduleId = t.timeScheduleId\n"
                + "    JOIN \n"
                + "        time_slot s ON t.slotId = s.time_slot_id\n"
                + "    GROUP BY \n"
                + "        r.idMentee, \n"
                + "        r.idMentor, \n"
                + "        r.title, \n"
                + "        r.content, \n"
                + "        r.skillId, \n"
                + "        r.statusId, \n"
                + "        r.startWeek, \n"
                + "        r.endWeek, \n"
                + "        r.reasonReject\n"
                + ") AS subquery;";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Request r = new Request();
                r.setListIdRequest(rs.getString("idRequest"));

                r.setStatusId(rs.getInt("statusId"));
                r.setStartWeek(rs.getInt("startWeek"));
                r.setEndWeek(rs.getInt("endWeek"));
                r.setTitle(rs.getString("title"));
                r.setContent(rs.getString("content"));
                r.setHour(rs.getFloat("hour"));
                r.setReasonReject(rs.getString("reasonReject"));
                r.setTotalCost(rs.getInt("totalCost"));
                r.setMentor(getMentorById(rs.getInt("idMentor")));
                r.setMentee(getMenteeById(rs.getInt("idMentee")));
                r.setSkill(getSkillById(rs.getInt("skillId")));
                r.setListSlot(getDistinctSlot(rs.getString("slots")));
                list.add(r);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getDistinctSlot(String listSlot) {
        String[] arr = listSlot.split(",");
        String s = "";
        for (String st : arr) {
            if (!s.contains(st)) {
                s += st + "\n";
            }
        }
        s = s.substring(0, s.length()-1);
        return s;
    }

    public static void main(String[] args) {
        HandleRequestDAO hd = new HandleRequestDAO();
//        Request r = handleRequestDao.getRequestById(3);
//        handleRequestDao.PaymentManyRequest(r.getIdMentee(), r.getIdMentor(), r.getSkillId());
        ArrayList<Request> l = hd.getListRequestForManager();
        String[] lr = l.get(1).getListIdRequest().split(",");
        System.out.println(lr[0]);
    }

}
