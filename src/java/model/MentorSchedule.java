/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lvha0
 */
public class MentorSchedule {
    private int mentorScheduleId;
    private int idMentor;
    private int timeScheduleId;

    public MentorSchedule() {
        // Default constructor
    }

    public MentorSchedule(int mentorScheduleId, int idMentor, int timeScheduleId) {
        this.mentorScheduleId = mentorScheduleId;
        this.idMentor = idMentor;
        this.timeScheduleId = timeScheduleId;
    }

    public int getMentorScheduleId() {
        return mentorScheduleId;
    }

    public void setMentorScheduleId(int mentorScheduleId) {
        this.mentorScheduleId = mentorScheduleId;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(int timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }

}

