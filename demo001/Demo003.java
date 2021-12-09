package demo001;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description: 时间
 * @author: VzivZ
 * @date: 2019-09-10 16:05
 **/
public class Demo003 {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
    public static void main(String[] args) {
        int year = 201909/100;
        System.out.println(year);
//        System.out.println(getIntLastMonth(201903));
    }
    private static Integer getIntLastMonth(Integer month) {
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = format.parse(month.toString());
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            date = calendar.getTime();
            String dateString = format.format(date);
            return Integer.valueOf(dateString);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
