/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;

/**
 *
 * @author lvha0
 */
public class TimeSchedule {

    private int timeScheduleId;
    private int year;
    private int week;
    private String day;
    private int slotId;
    private String genderTo;
    private Time_Slot timeSlot;

    public TimeSchedule() {
    }

    public TimeSchedule(int timeScheduleId, int year, int week, String day, int slotId) {
        this.timeScheduleId = timeScheduleId;
        this.year = year;
        this.week = week;
        this.day = day;
        this.slotId = slotId;
    }

    public TimeSchedule(int year, int week, String day, int slotId) {
        this.year = year;
        this.week = week;
        this.day = day;
        this.slotId = slotId;
    }

    public TimeSchedule(int year, int week, String day, Time_Slot timeSlot) {
        this.year = year;
        this.week = week;
        this.day = day;
        this.timeSlot = timeSlot;
    }

    public int getTimeScheduleId() {
        return timeScheduleId;
    }

    public void setTimeScheduleId(int timeScheduleId) {
        this.timeScheduleId = timeScheduleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Time_Slot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Time_Slot timeSlot) {
        this.timeSlot = timeSlot;
    }
    
    

    public String getGenderTo() {
        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
        WeekFields weekFields = WeekFields.ISO; // Use ISO-8601 standard (Monday as the first day of the week)
        LocalDate startOfWeek = firstDayOfYear
                .with(weekFields.weekOfYear(), week)
                .with(weekFields.dayOfWeek(), 1); // 1 represents Monday
        LocalDate endOfWeek = startOfWeek.plusDays(6); // 6 days after Monday is Sunday

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return startOfWeek.format(formatter) + " to " + endOfWeek.format(formatter);
    }

    @Override
    public String toString() {
        return "TimeSchedule{" + "timeScheduleId=" + timeScheduleId + ", year=" + year + ", week=" + week + ", day=" + day + ", slotId=" + slotId + '}';
    }

    public static void main(String[] args) {
        TimeSchedule ts = new TimeSchedule(2024, 1, "Mon", 1);
        System.out.println(ts.getGenderTo());
    }
}
