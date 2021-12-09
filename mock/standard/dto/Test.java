package mock.standard.dto;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Description:
 * @Author VzivZ
 * @Date 2021/1/15 14:55
 */
public class Test {

    public static void main(String[] args) {
        Date date = new Date();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
            Date beginDate = sdf.parse("060000");//转换为天的起始date
            Date endDate = sdf.parse("110000");//下一天的date
            List<Date> ds = timeIntervalFiveMin(beginDate, endDate);
            for (Date d : ds) {
                System.out.println(sdf.format(d));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    /**
     * 将指定时间切割成5分钟间隔
     * @param beginDate 开始时间
     * @param endDate 结束时间
     * @return
     */
    public static List<Date> timeIntervalFiveMin(Date beginDate, Date endDate) {
        try {

            List<Date> result = new ArrayList<>();
            while (beginDate.compareTo(endDate) <= 0) {
                result.add(beginDate);
                //日期加5分钟
                beginDate = addOffsetMin(beginDate, 5);
            }

            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 分割时间
     * @param start
     * @param offset
     * @return
     */
    private static Date addOffsetMin(Date start, int offset) {
        Calendar c = Calendar.getInstance();
        c.setTime(start);
        c.add(Calendar.MINUTE, offset);
        return c.getTime();
    }
}
