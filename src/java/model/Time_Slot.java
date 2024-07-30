/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author DANG VU MINH
 */
public class Time_Slot {
    public int time_slot_id;
    public String time;


    public Time_Slot(int time_slot_id, String time) {
        this.time_slot_id = time_slot_id;
        this.time = time;

    }

    public int getTime_slot_id() {
        return time_slot_id;
    }

    public void setTime_slot_id(int time_slot_id) {
        this.time_slot_id = time_slot_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Time_Slot{" + "time_slot_id=" + time_slot_id + ", time=" + time + '}';
    }
    
    
    
}