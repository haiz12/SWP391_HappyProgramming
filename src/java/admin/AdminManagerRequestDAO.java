/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package admin;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.UpdateSheduleRequest;

/**
 *
 * @author admin
 */
public class AdminManagerRequestDAO extends DBContext {

    public void acceptOrRejectScheduleRequest(int idMentor, int status, String reasonReject) {
        String sql = "UPDATE updateScheduleRequest\n"
                + "SET status = ?, reasonReject = ?\n"
                + "where mentor_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, status);
            pre.setString(2, reasonReject);
            pre.setInt(3, idMentor);
            pre.executeUpdate();
            if(status == 8){
                updateScheduleByMentorId(idMentor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUpdateScheduleRequest(int idMentor) {
        ArrayList<UpdateSheduleRequest> list = getListUpdateScheduleRequest();
        int a = 0;
        for (UpdateSheduleRequest updateSheduleRequest : list) {
            if(updateSheduleRequest.getMentor_id() == idMentor){
                a++;
            }
        }
        if(a != 0) {
            return;
        }
        String sql = "INSERT INTO updateScheduleRequest(mentor_id, status) VALUES \n"
                + "(?, 7 )";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, idMentor);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<UpdateSheduleRequest> getListUpdateScheduleRequest() {
        ArrayList<UpdateSheduleRequest> list = new ArrayList<>();
        String sql = "select distinct * from updateScheduleRequest where status = 7";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                UpdateSheduleRequest usr = new UpdateSheduleRequest();
                usr.setMentor_id(rs.getInt("mentor_id"));
                usr.setStatus(rs.getInt("status"));
                usr.setReasonReject(rs.getString("reasonReject"));
                list.add(usr);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateScheduleByMentorId(int mentor_id) {
        String sql = "update scheduleRequest\n"
                + "set status = 0\n"
                + "where mentor_id = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setInt(1, mentor_id);
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}



