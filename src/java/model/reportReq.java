/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author admin
 */
public class reportReq {
   int idRequest ;
	String title;
	String content;

    public reportReq(int idRequest, String title, String content) {
        this.idRequest = idRequest;
        this.title = title;
        this.content = content;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
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

    @Override
    public String toString() {
        return "reportReq{" + "idRequest=" + idRequest + ", title=" + title + ", content=" + content + '}';
    }
	
}
