/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ADMIN
 */
public class Blog {
    int idblog, idMentor;
    String nameMentor,updatedate, thumbnail, title, briefinfo, detailinfo;
    int isAgree;

    public Blog() {
    }

    public Blog(int idblog, int idMentor, String nameMentor, String updatedate, String thumbnail, String title, String briefinfo, String detailinfo) {
        this.idblog = idblog;
        this.idMentor = idMentor;
        this.nameMentor = nameMentor;
        this.updatedate = updatedate;
        this.thumbnail = thumbnail;
        this.title = title;
        this.briefinfo = briefinfo;
        this.detailinfo = detailinfo;
    }

    public Blog(int idblog, int idMentor, String nameMentor, String updatedate, String thumbnail, String title, String briefinfo, String detailinfo, int isAgree) {
        this.idblog = idblog;
        this.idMentor = idMentor;
        this.nameMentor = nameMentor;
        this.updatedate = updatedate;
        this.thumbnail = thumbnail;
        this.title = title;
        this.briefinfo = briefinfo;
        this.detailinfo = detailinfo;
        this.isAgree = isAgree;
    }

    
    public int getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(int isAgree) {
        this.isAgree = isAgree;
    }



    public String getNameMentor() {
        return nameMentor;
    }

    public void setNameMentor(String nameMentor) {
        this.nameMentor = nameMentor;
    }

    public int getIdblog() {
        return idblog;
    }

    public void setIdblog(int idblog) {
        this.idblog = idblog;
    }

    public int getIdMentor() {
        return idMentor;
    }

    public void setIdMentor(int idMentor) {
        this.idMentor = idMentor;
    }

    public String getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(String updatedate) {
        this.updatedate = updatedate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBriefinfo() {
        return briefinfo;
    }

    public void setBriefinfo(String briefinfo) {
        this.briefinfo = briefinfo;
    }

    public String getDetailinfo() {
        return detailinfo;
    }

    public void setDetailinfo(String detailinfo) {
        this.detailinfo = detailinfo;
    }

    @Override
    public String toString() {
        return "Blog{" + "idblog=" + idblog + ", idMentor=" + idMentor + ", nameMentor=" + nameMentor + ", updatedate=" + updatedate + ", thumbnail=" + thumbnail + ", title=" + title + ", briefinfo=" + briefinfo + ", detailinfo=" + detailinfo + ", isAgree=" + isAgree + '}';
    }

    


    
    
    
}
