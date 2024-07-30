/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lvha0
 */
public class MenteeSchedule {
    private int menteeScheduleId;
    private int idMentee;
    private int timeScheduleId;
    private int skillId;

    public MenteeSchedule() {
        // Default constructor
    }

    public MenteeSchedule(int menteeScheduleId, int idMentee, int timeScheduleId, int skillId) {
        this.menteeScheduleId = menteeScheduleId;
        this.idMentee = idMentee;
        this.timeScheduleId = timeScheduleId;
        this.skillId = skillId;
    }

    public int getMenteeScheduleId() {
        return menteeScheduleId;
    }

    public void setMenteeScheduleId(int menteeScheduleId) {
        this.menteeScheduleId = menteeScheduleId;
    }

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public int getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(int timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}

