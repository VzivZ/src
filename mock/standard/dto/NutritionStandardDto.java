package mock.standard.dto;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class NutritionStandardDto {
    //操作员
    String operatorId;
    String grade;
    String gender;
    Double calories;
    Double protein;
    Double fat;
    Double carbohydrate;
    Double dietaryFiber;
    Double cholesterol;
    //
    Date modifyDate;

    public static void main(String[] args) {



        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd", Locale.SIMPLIFIED_CHINESE);
            Date firstDate = sdf.parse("2021/01/01");
            Date secondDate = sdf.parse("2021/01/31");
            System.out.println(getDayDiff(firstDate,secondDate));
            int begin = getIntDate(firstDate);
            int end = getIntDate(secondDate);
            System.out.println(end - begin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Integer getIntDate(Date d) {
        //"beginDate":1609430400000,"endDate":1612108799999,
        String dateStr = dateToString(d, "yyyyMMdd");
        return Integer.parseInt(dateStr);
    }

    public static Long getDayDiff(Date beginDate, Date endDate) {
        long diffInMillis = Math.abs(endDate.getTime() - beginDate.getTime());
        return TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
    }

    public static String dateToString(Date d, String format) {
        if (d == null) return null;
//      SimpleDateFormat sdf = new SimpleDateFormat(format);
//      return sdf.format(d);
        return new SimpleDateFormat(format).format(d);
    }

}
