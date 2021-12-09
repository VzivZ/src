package yjt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Description:
 * @Author HeZhe
 * @Date 2021/11/24 11:10
 */
public class DateUtil {
    public static float calculateTimeGapDay(String time1, String time2) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");

        float day = 0;
        Date date1;
        Date date2;

        try {
            date1 = simpleDateFormat.parse(time1);
            date2 = simpleDateFormat.parse(time2);
            long millisecond = date2.getTime() - date1.getTime();
            day = millisecond / (24 * 60 * 60 * 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return (day);
    }

    public static String getToday() {
        LocalDate todaysDate = LocalDate.now();
        return String.valueOf(todaysDate);
    }

    /**
     * 得到本周周一-周六日期 0为周一 6为周日
     *
     * @return
     */
    public static String getWeek(int day) {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        cal.setTime(new Date());
        cal.set(Calendar.DAY_OF_WEEK, cal.getFirstDayOfWeek() + day);
        Date first = cal.getTime();
        return formater.format(first);
    }

}
