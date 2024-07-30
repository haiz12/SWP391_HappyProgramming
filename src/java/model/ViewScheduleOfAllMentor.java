/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANG VU MINH
 */
public class ViewScheduleOfAllMentor {
    private int mentorId;
    private String fullname;
    private int year;
    private int week;
    private String day;
    private String time;
    private int status;

    public ViewScheduleOfAllMentor() {
    }

    public ViewScheduleOfAllMentor (int mentorId, String fullname, int year, int week, String day, String time, int status) {
        this.mentorId = mentorId;
        this.fullname = fullname;
        this.year = year;
        this.week = week;
        this.day = day;
        this.time = time;
        this.status = status;
    }

    // Getters and setters
    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ViewScheduleOfAllMentor{" + "mentorId=" + mentorId + ", fullname=" + fullname + ", year=" + year + ", week=" + week + ", day=" + day + ", time=" + time + ", status=" + status + '}';
    }

    
    
    
    
}
