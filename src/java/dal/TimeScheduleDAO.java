package dal;

import model.*;
/**
 *
 * @author lvha0
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeScheduleDAO extends DBContext {

    PreparedStatement stmt;

    public TimeScheduleDAO() {
    }

    public TimeScheduleDAO(Connection connection) {
        this.connection = connection;
    }

    public TimeSchedule getTimeScheduleById(int id) {
        TimeSchedule timeSchedule = null;
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM time_schedule WHERE timeScheduleId = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                timeSchedule = new TimeSchedule(
                        rs.getInt("year"),
                        rs.getInt("week"),
                        rs.getString("day"),
                        rs.getInt("slotId")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeSchedule;
    }

    public List<TimeSchedule> getAllTimeSchedules() {
        List<TimeSchedule> timeSchedules = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM time_schedule")) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TimeSchedule timeSchedule = new TimeSchedule(
                        rs.getInt("year"),
                        rs.getInt("week"),
                        rs.getString("day"),
                        rs.getInt("slotId")
                );
                timeSchedules.add(timeSchedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return timeSchedules;
    }

    public boolean addTimeSchedule(TimeSchedule timeSchedule) {
        try {
            String strAdd = "INSERT INTO timeSchedule(year, week, day, slotId) VALUES (?, ?, ?, ?)";
            stmt = connection.prepareStatement(strAdd);
            stmt.setInt(1, timeSchedule.getYear());
            stmt.setInt(2, timeSchedule.getWeek());
            stmt.setString(3, timeSchedule.getDay());
            stmt.setInt(4, timeSchedule.getSlotId());
            int rowsAffected = stmt.executeUpdate();
            stmt.close();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void updateTimeSchedule(TimeSchedule timeSchedule) {
        try (PreparedStatement stmt = connection.prepareStatement(
                "UPDATE time_schedule SET year = ?, week = ?, day = ?, slotId = ? WHERE timeScheduleId = ?")) {
            stmt.setInt(1, timeSchedule.getYear());
            stmt.setInt(2, timeSchedule.getWeek());
            stmt.setString(3, timeSchedule.getDay());
            stmt.setInt(4, timeSchedule.getSlotId());
            stmt.setInt(5, timeSchedule.getTimeScheduleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTimeSchedule(int id) {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM time_schedule WHERE timeScheduleId = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int getSlotID(TimeSchedule timeSchedule) {
        int slotID = 0;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            String strAdd = "SELECT timeScheduleId FROM timeSchedule WHERE year = ? AND week = ? AND day = ? AND slotId = ?";
            stmt = connection.prepareStatement(strAdd);
            stmt.setInt(1, timeSchedule.getYear());
            stmt.setInt(2, timeSchedule.getWeek());
            stmt.setString(3, timeSchedule.getDay());
            stmt.setInt(4, timeSchedule.getSlotId());

            rs = stmt.executeQuery();

            if (rs.next()) {
                slotID = rs.getInt("timeScheduleId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng ResultSet và PreparedStatement
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return slotID;
    }

    public static void main(String[] args) {
//        String startWeek = "2023/12/31 to 2024/01/06";
//        String endWeek = "2024/02/14 to 2024/02/21";
//        int startWeekNumber = 0, endWeekNumber = 0;
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        try {
//            Date startDate = dateFormat.parse(startWeek.split(" to ")[0]);
//            Date endDate = dateFormat.parse(endWeek.split(" to ")[0]);
//
//            Calendar cal = Calendar.getInstance();
//            cal.setTime(startDate);
//            startWeekNumber = cal.get(Calendar.WEEK_OF_YEAR);
//
//            cal.setTime(endDate);
//            endWeekNumber = cal.get(Calendar.WEEK_OF_YEAR);
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println(startWeekNumber);
//        System.out.println(endWeekNumber);
//        MentorDAO dao = new MentorDAO();
//        TimeScheduleDAO timeScheduleDAO = new TimeScheduleDAO();
//        TimeSchedule timeSchedule = new TimeSchedule(2024, 0, "mon", 2);
//        timeScheduleDAO.addTimeSchedule(timeSchedule);
//
//        ScheduleRequest scheduleRequest = new ScheduleRequest(2, timeScheduleDAO.getSlotID(timeSchedule));
//        dao.addScheduleRequest(scheduleRequest);
    }
}
