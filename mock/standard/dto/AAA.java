package mock.standard.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description:
 * @Author HeZhe
 * @Date 2020/12/28 11:38
 */
public class AAA {
    public static void main(String[] args) {
//        long a = 20201204062948L;
//        System.out.println(a / 1000000);
//        System.out.println(castIntDateFormat(a));
//        System.out.println(castPayTimeInterval(110000));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(sdf.format(new Date()));
//        List<String> aaa = new ArrayList<>();
//        SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
//        try {
//            Date  beginDate = sdf.parse("060000");//起始date
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(getIntDayAddOffset(20201231, 1));
        System.out.println(Integer.parseInt("0090"));
    }

    /**
     * 获取指定日期的指定天数后的日期
     *
     * @return
     */
    public static Integer getIntDayAddOffset(int day, int offset) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal = new GregorianCalendar();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        try {
            cal.setTime(format.parse(String.valueOf(day)));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cal.add(Calendar.DATE, offset);
        Date first = cal.getTime();
        return Integer.parseInt(format.format(first));
    }

    private static String castPayTimeInterval(Long intTime) {
        if (intTime == null) return null;
        String timeStr = String.valueOf(intTime);
        if (timeStr.length() == 5) timeStr = "0" + timeStr;
        String HH = timeStr.substring(0, 2);
        String mm = timeStr.substring(2, 4);
        String ss = timeStr.substring(4);
        return HH + ":" + mm + ":" + ss;
    }

    public static String castIntDateFormat(Long intDateTime) {
        String timeStr = String.valueOf(intDateTime);
        String result = null;
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            Date tmp = format.parse(timeStr);
            result = format2.format(tmp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

}
