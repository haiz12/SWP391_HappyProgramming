/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author lvha0
 */
public class ReasonRejectSchedule {
    private int idRequest;
    private int idMentor;
    private String note;
    private Date time;
    private int status;

    public ReasonRejectSchedule(int idRequest, int idMentor, String note, Date time, int status) {
        this.idRequest = idRequest;
        this.idMentor = idMentor;
        this.note = note;
        this.time = time;
        this.status = status;
    }

    // Getters and Setters
    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

