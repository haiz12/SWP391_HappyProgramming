/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class UpdateSheduleRequest {
    private int mentor_id;
    private int status;
    private String reasonReject;
    private Mentor mentor;

    public UpdateSheduleRequest() {
    }

    public UpdateSheduleRequest(int mentor_id, int status, String reasonReject, Mentor mentor) {
        this.mentor_id = mentor_id;
        this.status = status;
        this.reasonReject = reasonReject;
        this.mentor = mentor;
    }

    public int getMentor_id() {
        return mentor_id;
    }

    public void setMentor_id(int mentor_id) {
        this.mentor_id = mentor_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getReasonReject() {
        return reasonReject;
    }

    public void setReasonReject(String reasonReject) {
        this.reasonReject = reasonReject;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @Override
    public String toString() {
        return "UpdateSheduleRequest{" + "mentor_id=" + mentor_id + ", status=" + status + ", reasonReject=" + reasonReject + ", mentor=" + mentor + '}';
    }

    

    
}



