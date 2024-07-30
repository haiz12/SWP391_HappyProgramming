/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lvha0
 */
public class Schedule {
    private int scheduleId;
    private int mentorScheduleId;
    private int menteeScheduleId;
    private int timeScheduleId;

    public Schedule() {
        // Default constructor
    }

    public Schedule(int scheduleId, int mentorScheduleId, int menteeScheduleId, int timeScheduleId) {
        this.scheduleId = scheduleId;
        this.mentorScheduleId = mentorScheduleId;
        this.menteeScheduleId = menteeScheduleId;
        this.timeScheduleId = timeScheduleId;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public int getMentorScheduleId() {
        return mentorScheduleId;
    }

    public void setMentorScheduleId(int mentorScheduleId) {
        this.mentorScheduleId = mentorScheduleId;
    }

    public int getMenteeScheduleId() {
        return menteeScheduleId;
    }

    public void setMenteeScheduleId(int menteeScheduleId) {
        this.menteeScheduleId = menteeScheduleId;
    }

    public int getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(int timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }
    
    
}

