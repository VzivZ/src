package demo001;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-01-16 15:47
 **/
public class AAA {
    public static String getFirstDayOfMonth(int year,int month)
    {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);

        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, 1);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        return sdf.format(cal.getTime());
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
//    public static String getDate(String pattern) {
//        return DateFormatUtils.format(new Date(), pattern);
//    }

    public static void main(String[] args) {
        System.out.println(201901/100);
        System.out.println(201901%100);
//        System.out.println(getFirstDayOfMonth(201901/100,201901%100));
    }
}
