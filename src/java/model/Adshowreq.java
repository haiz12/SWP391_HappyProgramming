/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trang
 */
public class Adshowreq {

    int idMentee, idRequest;
    String username, title, content, skill, status, startdate, endDate;
    float hour;
    int totalCost;
    private String reasonreject;
    String fullname, dob, avatar, sex, address, phone;

    public Adshowreq(int idMentee, int idRequest, String username, String title, String content, String skill, String startdate, String endDate, String status, float hour, String reasonreject,int totalCost) {
        this.idMentee = idMentee;
        this.idRequest = idRequest;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.startdate = startdate;
        this.endDate = endDate;
        this.status = status;
        this.hour = hour;
        this.reasonreject = reasonreject;
        this.totalCost=totalCost;
    }

    public Adshowreq() {
    }

    public Adshowreq(int idMentee, String username, String title, String content, String skill, String status, String startdate, String endDate) {
        this.idMentee = idMentee;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.startdate = startdate;
        this.endDate = endDate;
    }

    public Adshowreq(int idMentee, int idRequest, String username, String title, String content, String skill, String status, String startdate, String endDate) {
        this.idMentee = idMentee;
        this.idRequest = idRequest;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.startdate = startdate;
        this.endDate = endDate;
    }

    public Adshowreq(int idMentee, int idRequest, String username, String title, String content, String skill, String status, String fullname, String dob, String avatar, String sex, String address, String phone) {
        this.idMentee = idMentee;
        this.idRequest = idRequest;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.fullname = fullname;
        this.dob = dob;
        this.avatar = avatar;
        this.sex = sex;
        this.address = address;
        this.phone = phone;
    }

    public Adshowreq(int idMentee, String username, String title, String content, String status, String endDate, float hour) {
        this.idMentee = idMentee;
        this.username = username;
        this.title = title;
        this.content = content;
        this.status = status;
        this.endDate = endDate;
        this.hour = hour;
    }

    public Adshowreq(int idMentee, String username, String title, String content, String skill, String status, String endDate, float hour) {
        this.idMentee = idMentee;
        this.username = username;
        this.title = title;
        this.content = content;
        this.skill = skill;
        this.status = status;
        this.endDate = endDate;
        this.hour = hour;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public String getStartdate() {
        return startdate;
    }

    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeadline() {
        return endDate;
    }

    public void setDeadline(String endDate) {
        this.endDate = endDate;
    }

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReasonreject() {
        return reasonreject;
    }

    public void setReasonreject(String reasonreject) {
        this.reasonreject = reasonreject;
    }

    @Override
    public String toString() {
        return "Adshowreq{" + "idMentee=" + idMentee + ", idRequest=" + idRequest + ", username=" + username + ", title=" + title + ", content=" + content + ", skill=" + skill + ", status=" + status + ", startdate=" + startdate + ", endDate=" + endDate + ", hour=" + hour + ", reasonreject=" + reasonreject + ", fullname=" + fullname + ", dob=" + dob + ", avatar=" + avatar + ", sex=" + sex + ", address=" + address + ", phone=" + phone + '}';
    }

}
