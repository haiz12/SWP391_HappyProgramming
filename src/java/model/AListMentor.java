/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class AListMentor {
    int ID;
    String FullName;
    String accountname;
    String Profession;
    int acceptrequest;
    float percentcompleted;
    float rate;
    int active;
    String status;

    public AListMentor(int ID, String FullName, String accountname, String Profession, int acceptrequest, float percentcompleted, float rate) {
        this.ID = ID;
        this.FullName = FullName;
        this.accountname = accountname;
        this.Profession = Profession;
        this.acceptrequest = acceptrequest;
        this.percentcompleted = percentcompleted;
        this.rate = rate;
    }

    public AListMentor(int ID, String FullName, String accountname, String Profession, int acceptrequest, float percentcompleted, float rate, int active) {
        this.ID = ID;
        this.FullName = FullName;
        this.accountname = accountname;
        this.Profession = Profession;
        this.acceptrequest = acceptrequest;
        this.percentcompleted = percentcompleted;
        this.rate = rate;
        this.active = active;
    }

    public AListMentor(int ID, String FullName, String accountname, String Profession, int acceptrequest, float percentcompleted, float rate, int active, String status) {
        this.ID = ID;
        this.FullName = FullName;
        this.accountname = accountname;
        this.Profession = Profession;
        this.acceptrequest = acceptrequest;
        this.percentcompleted = percentcompleted;
        this.rate = rate;
        this.active = active;
        this.status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getProfession() {
        return Profession;
    }

    public void setProfession(String Profession) {
        this.Profession = Profession;
    }

    public int getAcceptrequest() {
        return acceptrequest;
    }

    public void setAcceptrequest(int acceptrequest) {
        this.acceptrequest = acceptrequest;
    }

    public float getPercentcompleted() {
        return percentcompleted;
    }

    public void setPercentcompleted(float percentcompleted) {
        this.percentcompleted = percentcompleted;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AListMentor{" + "ID=" + ID + ", FullName=" + FullName + ", accountname=" + accountname + ", Profession=" + Profession + ", acceptrequest=" + acceptrequest + ", percentcompleted=" + percentcompleted + ", rate=" + rate + ", active=" + active + ", status=" + status + '}';
    }
    
}
