package yjt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description:
 * @Author VzivZ
 * @Date 2021/1/23 11:02
 */
public class Demo001 {
    public static void main(String[] args) {
//        System.out.println(getWeekIntDay(-1));
//        System.out.println(getWeekIntDay(5));
        double lI1 = 0d;
        test();
    }

    private static void test(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date2 = new Date(1618976682000L);
            Date date = format.parse("2021-02-10 23:00");
            System.out.println(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public static Integer getWeekIntDay(int day) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + day);
        if (day == -1) {
            //Calendar 的第一天是周一，获取上周日
            cal.add(Calendar.DATE,-7);
        }
        Date first = cal.getTime();
        return Integer.parseInt(format.format(first));
    }
}
