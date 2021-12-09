package demo001;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: HeZhe
 * @date: 2019-12-20 13:51
 **/
public class UUUtils {
    private static void getRecent20days(List<OvertimeDaysModel> list) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date today = new Date();

        Calendar theCa = Calendar.getInstance();
        theCa.setTime(today);
        Date start = theCa.getTime();
        String startDate = sdf.format(start);
        OvertimeDaysModel model = new OvertimeDaysModel();
        model.setDays(startDate);
        list.add(model);
        for(int i = 0; i < 19;i++){
            theCa.add(Calendar.DATE, -1);
            start = theCa.getTime();
            startDate = sdf.format(start);
            model = new OvertimeDaysModel();
            model.setDays(startDate);
            list.add(model);
        }
        System.out.println(list.size());
    }

    public static String formatDateTime(long timeMillis) {
        long day = timeMillis / (24 * 60 * 60 * 1000);
        long hour = (timeMillis / (60 * 60 * 1000) - day * 24);
        long min = ((timeMillis / (60 * 1000)) - day * 24 * 60 - hour * 60);
        long s = (timeMillis / 1000 - day * 24 * 60 * 60 - hour * 60 * 60 - min * 60);
        long sss = (timeMillis - day * 24 * 60 * 60 * 1000 - hour * 60 * 60 * 1000 - min * 60 * 1000 - s * 1000);
        return (day > 0 ? day + "天" : "") + hour + "小时" + min + "分钟" + s + "." + sss + "秒";
    }

    public static String formatDateTime002(long ms) {
        String dateTimes;
        long ss = ms/1000;
        long days = ss / ( 60 * 60 * 24);
        long hours = (ss % ( 60 * 60 * 24)) / (60 * 60);
        long minutes = (ss % ( 60 * 60)) /60;
        long seconds = ss % 60;
        if(days>0){
            dateTimes= days + "天" + hours + "小时" + minutes + "分" + seconds + "秒";
        }else if(hours>0){
            dateTimes=hours + "小时" + minutes + "分" + seconds + "秒";
        }else if(minutes>0){
            dateTimes=minutes + "分" + seconds + "秒";
        }else{
            dateTimes=seconds + "秒";
        }
        return dateTimes;
    }

    private <E> boolean isListBlank(List<E> list){
        if(list == null || list.size() == 0) return true;
        return list.size() == 1 && list.get(0) == null;
    }

    public static void main(String[] args) {

        String processOwner = "aaa,jjjjj";
        String[] idList = processOwner.split(",");

        for (String s : idList) {
            System.out.println(s);
        }

//        Double.parseDouble("");
//        List<OvertimeDaysModel> list = new ArrayList<>();
//
//        OvertimeDaysModel model = new OvertimeDaysModel();
//        try {
//            OvertimeDaysModel model01 = (OvertimeDaysModel)super.clone();
//        }catch (Exception ex){
//            ex.printStackTrace();
//        }
//        double ttt = 1*24*60*60;
//        ttt = ttt + 444 ;
//        ttt = ttt*1000;
//        System.out.println(formatDateTime002((long) ttt));
////        getRecent20days(list);
    }
}
