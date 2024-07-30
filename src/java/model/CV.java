/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author trang
 */
public class CV {

    int idMentor;
    String   fullname,avatar,  phone, dob, sex, address, registerDate;
    String profession, pro_introduc, archivement_descition, framework, experience, education, myservice, stk;
    int cost;
    String skill;

    public CV() {
    }

    public CV(int idMentor, String fullname, String avatar, String phone, String dob, String sex, String address, String registerDate, String profession, String pro_introduc, String archivement_descition, String framework, String experience, String education, String myservice, String stk, int cost) {
        this.idMentor = idMentor;
        this.fullname = fullname;
        this.avatar = avatar;
        this.phone = phone;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.registerDate = registerDate;
        this.profession = profession;
        this.pro_introduc = pro_introduc;
        this.archivement_descition = archivement_descition;
        this.framework = framework;
        this.experience = experience;
        this.education = education;
        this.myservice = myservice;
        this.stk = stk;
        this.cost = cost;
    }

    public CV(int idMentor, String fullname, String avatar, String phone, String dob, String sex, String address, String registerDate, String profession, String pro_introduc, String archivement_descition, String framework, String experience, String education, String myservice, String stk, int cost, String skill) {
        this.idMentor = idMentor;
        this.fullname = fullname;
        this.avatar = avatar;
        this.phone = phone;
        this.dob = dob;
        this.sex = sex;
        this.address = address;
        this.registerDate = registerDate;
        this.profession = profession;
        this.pro_introduc = pro_introduc;
        this.archivement_descition = archivement_descition;
        this.framework = framework;
        this.experience = experience;
        this.education = education;
        this.myservice = myservice;
        this.stk = stk;
        this.cost = cost;
        this.skill = skill;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    

    public int getIdMentor() {
        return idMentor;
    }

   

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPro_introduc() {
        return pro_introduc;
    }

    public void setPro_introduc(String pro_introduc) {
        this.pro_introduc = pro_introduc;
    }

    public String getArchivement_descition() {
        return archivement_descition;
    }

    public void setArchivement_descition(String archivement_descition) {
        this.archivement_descition = archivement_descition;
    }

    public String getFramework() {
        return framework;
    }

    public void setFramework(String framework) {
        this.framework = framework;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getMyservice() {
        return myservice;
    }

    public void setMyservice(String myservice) {
        this.myservice = myservice;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
    

    @Override
    public String toString() {
        return "CV{" + "idMentor=" + idMentor + ", fullname=" + fullname + ", avatar=" + avatar + ", phone=" + phone + ", dob=" + dob + ", sex=" + sex + ", address=" + address + ", registerDate=" + registerDate + ", profession=" + profession + ", pro_introduc=" + pro_introduc + ", archivement_descition=" + archivement_descition + ", framework=" + framework + ", experience=" + experience + ", education=" + education + ", myservice=" + myservice + ", stk=" + stk + ", cost=" + cost + ", skill=" + skill + '}';
    }

    

    
   
    
}
