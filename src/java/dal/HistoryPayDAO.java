/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.HistoryWallet;
import model.Request;

/**
 *
 * @author Admin
 */
public class HistoryPayDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    

    public List<HistoryWallet> getHistoryWalletByIdAccount(int idAccount) {
        List<HistoryWallet> listHistoryWallet = new ArrayList<>();
        try {
            String sql = "SELECT * FROM dbo.historyWallet\n"
                    + "WHERE idAccount=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, idAccount);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String nameMentee = rs.getString(3);
                int amount = rs.getInt(4);
                String datePay = rs.getString(5);
                String content = rs.getString(6);
                String stype = rs.getString(7);

                listHistoryWallet.add(new HistoryWallet(id, idAccount,amount,nameMentee,  datePay, content, stype));
            }
        } catch (Exception e) {
            System.out.println("getHistoryWalletByIdAccount " + e);
        }
        return listHistoryWallet;
    }

    public boolean addHistoryPay(HistoryWallet h) {
        List<HistoryWallet> listHistoryWallet = new ArrayList<>();
        try {
            String sql = "INSERT INTO dbo.historyWallet (idAccount,nameMentee, amount,datePay,content,stype)\n"
                    + "VALUES(?,?,?,?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, h.getIdAccount());
            stm.setString(2, h.getNameMentee());
            stm.setInt(3, h.getAmount());
            stm.setString(4, h.getDatePay());
            stm.setString(5, h.getContent());
            stm.setString(6, h.getStype());
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("addHistoryPay " + e);
        }
        return false;
    }

    public static void main(String[] args) {
        HistoryPayDAO hd = new HistoryPayDAO();
//        Timestamp createdAt = new Timestamp(new Date().getTime());
//        WalletDAO walletDAO = new WalletDAO();
//        HandleRequestDAO handleRequestDao = new HandleRequestDAO();
//        Request r = handleRequestDao.getRequestById(1);
//        HistoryWallet hw = new HistoryWallet();
//        int idMentee = r.getIdMentee();
//        int totalCost = walletDAO.getTotalCostOfARequest(r);
//        hw.setIdAccount(idMentee);
//        hw.setAmount(totalCost);
//        hw.setContent("Pay for course :" + r.getSkill().getSkillName());
//        hw.setDatePay(String.valueOf(createdAt));
//        hw.setNameMentee(r.getMentee().getFullname());
//        hw.setStype("Deposit");
//        hd.addHistoryPay(hw);
    List<HistoryWallet> l = hd.getHistoryWalletByIdAccount(14);
        for (HistoryWallet historyWallet : l) {
            System.out.println("1");
        }
    }
}
