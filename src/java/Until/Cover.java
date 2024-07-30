/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Until;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;
/**
 *
 * @author admin
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class Cover {
    public static String[] getDatesOfWeek(int year, int weekNumber) {
        // Định dạng ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        // Lấy ngày đầu tiên của năm
        LocalDate firstDayOfYear = LocalDate.of(year, 1, 1);
        
        // Tạo WeekFields để xác định hệ thống tuần
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        
        // Lấy ngày đầu tiên của tuần theo tuần số
        LocalDate startDate = firstDayOfYear
            .with(weekFields.weekOfYear(), weekNumber)
            .with(weekFields.dayOfWeek(), 1);
        
        // Tính ngày kết thúc của tuần
        LocalDate endDate = startDate.plusDays(6);
        
        // Đổi ngày tháng sang định dạng dd/MM/yyyy
        String[] result = {
            startDate.format(formatter),
            endDate.format(formatter)
        };
        
        return result;
    }
    
   public String CoverStatus(int status) {
        switch (status) {
            case 0:
                return "Draft";
            case 1:
                return "Processing";
            case 2:
                return "Approve";
            case 3:
                return "Reject";
            default:
                return "Unknown Status";
        }
    }
}

