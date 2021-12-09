package demo001;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description: demo
 * @author: VzivZ
 * @date: 2019-11-05 17:53
 **/
public class DateDemo {
    public static void main(String[] args) {
//        Calendar currDate = Calendar.getInstance();
//        int year = currDate.get(Calendar.YEAR);    //获取年
//        int month = currDate.get(Calendar.MONTH) + 1;   //获取月份，0表示1月份
//        int days = currDate.get(Calendar.DAY_OF_MONTH);
//        System.out.println(year + "   " + month + "    " + days);
//        System.out.println(getDeadline(201912));
//        System.out.println(getDeadline(201902));
        getRecent20days();

    }

    private static String getDeadline(Integer month) {
        Date today = new Date();
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(today);
        int days = calendar1.get(Calendar.DAY_OF_MONTH);
        try {
            DateFormat fmt = new SimpleDateFormat("yyyyMM");
            Date date = fmt.parse(month.toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            // 获取某月最大天数
            int m = calendar.get(Calendar.MONTH) + 1;
            days = calendar.getActualMaximum(Calendar.DATE);
            return m + "月" + days + "日";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static void getRecent20days() {
        List<String> days = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date today = new Date();

        Calendar theCa = Calendar.getInstance();
        theCa.setTime(today);
        Date start = theCa.getTime();
        String startDate = sdf.format(start);
        days.add(startDate);
        for(int i = 0; i < 19;i++){
            theCa.add(Calendar.DATE, -1);
            start = theCa.getTime();
            startDate = sdf.format(start);
            days.add(startDate);
        }
    }
}
