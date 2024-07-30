/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Request {

    private int idRequest, idMentee, idMentor, skillId, statusId, startWeek, endWeek, timeScheduleId;
    private String title, content;
    private float hour;
    private String reasonReject;
    int totalCost;
    private Mentee mentee;
    private Mentor mentor;
    private Skill skill;
    private TimeSchedule timeSchedule;
    private String listIdRequest, listSlot;

    public Request() {
    }

    public Request(int idRequest, int statusId, int startWeek, int endWeek, String title, String content, float hour, String reasonReject, int totalCost, Mentee mentee, Skill skill, TimeSchedule timeSchedule) {
        this.idRequest = idRequest;
        this.statusId = statusId;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.title = title;
        this.content = content;
        this.hour = hour;
        this.reasonReject = reasonReject;
        this.totalCost = totalCost;
        this.mentee = mentee;
        this.skill = skill;
        this.timeSchedule = timeSchedule;
    }
    
    public Request(int idRequest, int statusId, int startWeek, int endWeek, String title, String content, float hour, String reasonReject, int totalCost, Mentor mentor, Skill skill, TimeSchedule timeSchedule) {
        this.idRequest = idRequest;
        this.statusId = statusId;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.title = title;
        this.content = content;
        this.hour = hour;
        this.reasonReject = reasonReject;
        this.totalCost = totalCost;
        this.mentor = mentor;
        this.skill = skill;
        this.timeSchedule = timeSchedule;
    }

    public Request(int idRequest, int idMentee, int idMentor, int skillId, int statusId, int startWeek, int endWeek, String title, String content, float hour, String reasonReject, int totalCost, int timeScheduleId) {
        this.idRequest = idRequest;
        this.idMentee = idMentee;
        this.idMentor = idMentor;
        this.skillId = skillId;
        this.statusId = statusId;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.title = title;
        this.content = content;
        this.hour = hour;
        this.reasonReject = reasonReject;
        this.totalCost = totalCost;
        this.timeScheduleId = timeScheduleId;
    }

    public int getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(int timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }
    
    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getIdMentee() {
        return idMentee;
    }

    public void setIdMentee(int idMentee) {
        this.idMentee = idMentee;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(int startWeek) {
        this.startWeek = startWeek;
    }

    public int getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(int endWeek) {
        this.endWeek = endWeek;
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

    public float getHour() {
        return hour;
    }

    public void setHour(float hour) {
        this.hour = hour;
    }

    public String getReasonReject() {
        return reasonReject;
    }

    public void setReasonReject(String reasonReject) {
        this.reasonReject = reasonReject;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Mentee getMentee() {
        return mentee;
    }

    public void setMentee(Mentee mentee) {
        this.mentee = mentee;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public TimeSchedule getTimeSchedule() {
        return timeSchedule;
    }

    public void setTimeSchedule(TimeSchedule timeSchedule) {
        this.timeSchedule = timeSchedule;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public String getListIdRequest() {
        return listIdRequest;
    }

    public void setListIdRequest(String listIdRequest) {
        this.listIdRequest = listIdRequest;
    }

    public String getListSlot() {
        return listSlot;
    }

    public void setListSlot(String listSlot) {
        this.listSlot = listSlot;
    }

    @Override
    public String toString() {
        return "Request{" + "idRequest=" + idRequest + ", idMentee=" + idMentee + ", idMentor=" + idMentor + ", skillId=" + skillId + ", statusId=" + statusId + ", startWeek=" + startWeek + ", endWeek=" + endWeek + ", timeScheduleId=" + timeScheduleId + ", title=" + title + ", content=" + content + ", hour=" + hour + ", reasonReject=" + reasonReject + ", totalCost=" + totalCost + ", mentee=" + mentee + ", mentor=" + mentor + ", skill=" + skill + ", timeSchedule=" + timeSchedule + ", listIdRequest=" + listIdRequest + ", listSlot=" + listSlot + '}';
    }
    
    
    
    
}
