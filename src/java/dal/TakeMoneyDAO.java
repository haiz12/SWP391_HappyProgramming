/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import controller.TakeMoney;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.GetMoney;
import model.HistoryWallet;

/**
 *
 * @author Admin
 */
public class TakeMoneyDAO extends DBContext {

    PreparedStatement stm;
    ResultSet rs;
    List<GetMoney> listTakeMoney = new ArrayList<>();

    public boolean addTakeMoney(GetMoney t) {
        try {
            String sql = "INSERT INTO [dbo].[requestTakeMoney]\n"
                    + "     VALUES(?,?,?)";
            stm = connection.prepareStatement(sql);
            stm.setString(1, t.getFullname());
            stm.setString(2, t.getUsername());
            stm.setInt(3, t.getMoney());
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("addTakeMoney: " + e);
            return false;
        }
    }

    public GetMoney getTakeMoneyById(int id) {
        try {
            String sql = "SELECT * FROM dbo.requestTakeMoney \n"
                    + "WHERE id=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                int money = rs.getInt(4);
                return new GetMoney(id, fullname, username, money);
            }
        } catch (Exception e) {
            System.out.println("getTakeMoneyById" + e);
        }
        return null;
    }

    public boolean deleteTakeMoney(int id) {
        try {
            String sql = "DELETE FROM dbo.requestTakeMoney\n"
                    + "WHERE id=?";
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            int rowsAffected = stm.executeUpdate();

            // Close the prepared statement
            stm.close();
            return rowsAffected > 0;
        } catch (Exception e) {
            System.out.println("deleteTakeMoney "+e);
        }
        return false;
    }

    public List<GetMoney> getAllTakeMoney() {
        try {
            String sql = "SELECT * FROM dbo.requestTakeMoney ";
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String fullname = rs.getString(2);
                String username = rs.getString(3);
                int money = rs.getInt(4);

                listTakeMoney.add(new GetMoney(id, fullname, username, money));
            }
        } catch (Exception e) {
            System.out.println("getAllTakeMoney " + e);
        }
        return listTakeMoney;
    }

    public static void main(String[] args) {
        TakeMoneyDAO dao = new TakeMoneyDAO();
        System.out.println(dao.deleteTakeMoney(2));
    }
}
