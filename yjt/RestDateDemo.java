package yjt;

/**
 * @Description: 随便写写
 * @Author VzivZ
 * @Date 2021/11/24 9:48
 */
public class RestDateDemo {
    private static String today = DateUtil.getToday();
    private static String weekend = DateUtil.getWeek(5);
    private static String[] date2 = {"元旦", "2022-01-01"};
    private static String[] date3 = {"春节", "2022-01-31"};

    private static String str = "早上好，打工人！\n" +
            "\n" +
            "距离本周周末还有{count1}天\n" +
            "距离{name2}假期还有{count2}天\n" +
            "距离{name3}假期还有{count3}天\n" +
            "\n" +
            "工作再累 一定不要忘记摸鱼哦！\n" +
            "有事没事起身去茶水间去厕所去廊道走走\n" +
            "别老在工位上坐着 钱是老板的命是自己的";

    public static void main(String[] args) {
        calculateCount1();
        calculateCount2(date2[0]);
        calculateCount3(date3[0]);
        str = str.replace(".0", "");
        System.out.println(str);
    }

    private static void calculateCount1() {
        str = str.replace("{count1}", String.valueOf(DateUtil.calculateTimeGapDay(today, weekend)));
    }

    private static void calculateCount2(String dateName) {
        str = str.replace("{name2}", dateName);
        str = str.replace("{count2}", String.valueOf(DateUtil.calculateTimeGapDay(today, date2[1])));
    }

    private static void calculateCount3(String dateName) {
        str = str.replace("{name3}", dateName);
        str = str.replace("{count3}", String.valueOf(DateUtil.calculateTimeGapDay(today, date3[1])));
    }

}
