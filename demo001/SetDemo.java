package demo001;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @description: set
 * @author: VzivZ
 * @date: 2019-08-09 17:13
 **/
public class SetDemo {
    private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        if (!aaa()) {
            System.out.println("aaaa");
        } else {
            System.out.println("bbbb");
        }
        System.out.println(getDayArr(2019,201909));
        System.out.println(getTreeMonthDay(201908));
    }

    private static boolean aaa() {
        return true;
    }

    private static List<Integer> getDayArr(Integer year, Integer month) {
        List<Integer> list = new ArrayList<>();
        //这个月
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        String dateString = format.format(date);
        list.add(Integer.parseInt(dateString));
        //上个月
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.DATE, -1);
        date = calendar.getTime();
        dateString = format.format(date);
        list.add(Integer.parseInt(dateString));
        //上上个月
        calendar.add(Calendar.MONTH, -1);
        date = calendar.getTime();
        dateString = format.format(date);
        list.add(Integer.parseInt(dateString));

        return list;
    }

    private static List<Integer> getTreeMonthDay(Integer month) {
        List<Integer> list = new ArrayList<>();
        try {
            //指定月
            DateFormat fmt = new SimpleDateFormat("yyyyMM");
            Date date = fmt.parse(month.toString());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            // 获取某月最大天数
            int lastDay = calendar.getActualMaximum(Calendar.DATE);
            // 设置日历中月份的最大天数
            calendar.set(Calendar.DAY_OF_MONTH, lastDay);
            date = calendar.getTime();
            String dateString = format.format(date);
            list.add(Integer.parseInt(dateString));

            //指定月前一月
            calendar.add(Calendar.MONTH, -1);
            date = calendar.getTime();
            dateString = format.format(date);
            list.add(Integer.parseInt(dateString));
            //指定月后一月
            calendar.add(Calendar.MONTH, 2);
            date = calendar.getTime();
            if(date.after(new Date())){
                date = new Date();
                calendar.setTime(date);
                calendar.add(Calendar.DATE, -1);
                date = calendar.getTime();
            }
            dateString = format.format(date);
            list.add(Integer.parseInt(dateString));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
