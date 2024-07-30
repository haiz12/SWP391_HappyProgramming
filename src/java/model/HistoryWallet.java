/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class HistoryWallet {

    int id, idAccount, amount;
    String nameMentee, datePay, content, stype;

    public HistoryWallet() {
    }

    public HistoryWallet(int id, int idAccount,int amount, String nameMentee, String datePay, String content, String stype) {
        this.id = id;
        this.idAccount = idAccount;
        this.amount = amount;
        this.nameMentee = nameMentee;
        this.datePay = datePay;
        this.content = content;
        this.stype = stype;
    }

    public String getNameMentee() {
        return nameMentee;
    }

    public void setNameMentee(String nameMentee) {
        this.nameMentee = nameMentee;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDatePay() {
        return datePay;
    }

    public void setDatePay(String datePay) {
        this.datePay = datePay;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    @Override
    public String toString() {
        return "HistoryWallet{" + "id=" + id + ", idAccount=" + idAccount + ", amount=" + amount + ", nameMentee=" + nameMentee + ", datePay=" + datePay + ", content=" + content + ", stype=" + stype + '}';
    }


    

    
}
