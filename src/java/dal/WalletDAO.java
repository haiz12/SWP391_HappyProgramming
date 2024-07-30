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
import model.Account;
import model.Request;
import model.Wallet;

/**
 *
 * @author Admin
 */
public class WalletDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;

    // function for Mentor
    public int totalIncome(int idAccount) {
        try {
            String sql = "SELECT SUM(amount) FROM dbo.historyWallet\n"
                    + "WHERE idAccount=? AND stype='Deposit'";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            int totalIncome = 0;
            if (rs.next()) {
                totalIncome = rs.getInt(1);
            }
            return totalIncome;
        } catch (Exception e) {
            System.out.println("totalIncome: " + e);
        }
        return 0;
    }

    //function for system
    public int incomeSystem() {
        try {
            String sql = "SELECT SUM(totalCost) FROM dbo.request \n"
                    + "WHERE status IN ('Learning','Completed','Closed')";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            int totalIncome = 0;
            if (rs.next()) {
                totalIncome = rs.getInt(1);
            }
            return totalIncome / 10;
        } catch (Exception e) {
            System.out.println("incomeSystem " + e);
            return 0;
        }
    }

    public int getWalletBalance(int idAccount) {
        try {
            String sql = "SELECT * FROM dbo.wallet WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(2);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public boolean addWallet(Account a) {
        try {
            String sql = "INSERT INTO dbo.wallet\n"
                    + "(\n"
                    + "    idAccount,\n"
                    + "    amount\n"
                    + ")\n"
                    + "VALUES (?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, a.getId());
            stm.setInt(2, 0);
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    public boolean updateWallet(int idAccount, int balance, int hold) {
//        try {
//            String sql = "UPDATE dbo.wallet\n"
//                    + "SET amount=?, hold = ?\n"
//                    + "WHERE idAccount=?";
//            stm = connection.prepareStatement(sql);
//            stm.setInt(1, balance);
//            stm.setInt(2, hold);
//            stm.setInt(3, idAccount);
//            int rowsAffected = stm.executeUpdate();
//
//            // Close the prepared statement
//            stm.close();
//            return rowsAffected > 0;
//        } catch (Exception e) {
//            System.out.println("updateWallet " + e);
//            return false;
//        }
//    }
    public boolean updateWallet(Wallet wallet) {
        try {
            String sql = "UPDATE dbo.wallet\n"
                    + "SET amount=?, hold = ?\n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, wallet.getAmount());
            stm.setInt(2, wallet.getHold());
            stm.setInt(3, wallet.getIdAccount());
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("updateWallet " + e);
            return false;
        }
    }

    public Wallet getWalletByIdAccount(int idAccount) {
        try {
            String sql = "SELECT * FROM dbo.wallet\n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            if (rs.next()) {
                return new Wallet(idAccount, rs.getInt(2), rs.getInt(3));
            }
        } catch (Exception e) {
            System.out.println("getWalletByIdAccount " + e);
        }
        return null;
    }

    public int getTotalCostOfARequest(Request r) {
        HandleRequestDAO hd = new HandleRequestDAO();
        ArrayList<Request> list = new ArrayList<>();
        int totalCost = 0;
        String sql = "SELECT * FROM request WHERE idMentee = ? AND idMentor = ? AND title = ? AND skillId = ? AND statusId = ? AND startWeek = ? AND endWeek = ? AND [hour] = ? AND totalCost = ?";
        try ( PreparedStatement pre = connection.prepareStatement(sql)) {
            pre.setInt(1, r.getIdMentee());
            pre.setInt(2, r.getIdMentor());
            pre.setString(3, r.getTitle());
            pre.setInt(4, r.getSkillId());
            pre.setInt(5, r.getStatusId());
            pre.setInt(6, r.getStartWeek());
            pre.setInt(7, r.getEndWeek());
            pre.setFloat(8, r.getHour());
            pre.setInt(9, r.getTotalCost());

            rs = pre.executeQuery();
            while (rs.next()) {
                Request re = new Request();
                re.setIdRequest(rs.getInt("idRequest"));
                re.setSkillId(rs.getInt("skillId"));
                re.setStatusId(rs.getInt("statusId"));
                re.setStartWeek(rs.getInt("startWeek"));
                re.setEndWeek(rs.getInt("endWeek"));
                re.setTitle(rs.getString("title"));
                re.setContent(rs.getString("content"));
                re.setHour(rs.getFloat("hour"));
                re.setReasonReject(rs.getString("reasonReject"));
                re.setTotalCost(rs.getInt("totalCost"));
                re.setMentee(hd.getMenteeById(rs.getInt("idMentee")));
                re.setSkill(hd.getSkillById(rs.getInt("skillId")));
                re.setTimeSchedule(hd.getTimeScheduleById(rs.getInt("timeScheduleId")));
                re.setTimeScheduleId(rs.getInt("timeScheduleId"));
                re.setIdMentor(rs.getInt("idMentor"));
                re.setIdMentee(rs.getInt("idMentee"));
                list.add(re);
            }
            for (Request req : list) {
                totalCost += req.getTotalCost();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return totalCost;
    }

    public static void main(String[] args) {
        WalletDAO dao = new WalletDAO();
        HandleRequestDAO hd = new HandleRequestDAO();
        Request r = hd.getRequestById(1);
        int sum = dao.getTotalCostOfARequest(r);
        System.out.println(sum);
    }
}
