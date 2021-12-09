package demo001.de;

import java.util.Calendar;
import java.util.Date;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-05-09 15:24
 **/
public class CountDemo {
    public static void main(String[] args) {
        getDateVersionScope();
//        String group = ",slliew,,chgoh,,slliew,,slliew,,myting,yxpow,,brisep,," +
//                ",khwong,,myting,slngu,,nmohdnazir,,yblee,,yblee,,khwong,,khwong,,slliew,,yblee,,khwong,,slliew,,sfchai,,slliew,,slliew,,slliew,,slliew,";
//        String[] groupIds = group.split(",");
//        Set<String> set = new HashSet<>();
//        //用set来记录节点涉及的人员
//        for (String id : groupIds) {
//            if (id == null || "".equals(id)) continue;
//            id = id.trim();
//            set.add(id);
//        }
//        System.out.println(set.size());
    }

    private static void getDateVersionScope() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -1);
        System.out.println(getDateStr(cal));
        cal.add(Calendar.DATE, -30);
        System.out.println(getDateStr(cal));
    }

    private static String getDateStr(Calendar cal) {
        int y = cal.get(Calendar.YEAR);
        int m = cal.get(Calendar.MONTH) + 1;
        int d = cal.get(Calendar.DAY_OF_MONTH);
        String mStr = concat00(m);
        String dStr = concat00(d);
        return y + mStr + dStr;
    }

    private static String concat00(int n) {
        if (n >= 10) {
            return String.valueOf(n);
        } else {
            return "0" + n;
        }
    }

}
