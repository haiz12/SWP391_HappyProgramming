/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class GetMoney {

    
    int id;
    String fullname,username;
    int money;

    public GetMoney() {
    }

    public GetMoney(int id, String fullname, String username, int money) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "TakeMoney{" + "id=" + id + ", fullname=" + fullname + ", username=" + username + ", money=" + money + '}';
    }
    
    
}
