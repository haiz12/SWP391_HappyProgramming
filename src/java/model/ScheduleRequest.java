/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lvha0
 */
public class ScheduleRequest {
    private int mentorId;
    private int timeScheduleId;
    private int status;
    public ScheduleRequest() {
    }

    public ScheduleRequest(int mentorId, int timeScheduleId, int status) {
        this.mentorId = mentorId;
        this.timeScheduleId = timeScheduleId;
        this.status = status;
    }

    public int getMentorId() {
        return mentorId;
    }

    public void setMentorId(int mentorId) {
        this.mentorId = mentorId;
    }

    public int getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(int timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    
}
