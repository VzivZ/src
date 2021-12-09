package demo001.de;

import java.math.BigDecimal;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-05-20 18:16
 **/
public class JJJJJ {
    public static void main(String[] args) {

        BigDecimal a = new BigDecimal(1.1);
        BigDecimal b = new BigDecimal(1.10);
        if(a.compareTo(b) == 0){
            System.out.println("yyyyyyy");
        }
        if(a.equals(b)){
            System.out.println("hhhhhhhhhhhhhh");
        }

        System.out.println(201707%100);

        int aaa =  1000;
//        System.out.println(aaaaa(aaa, "jjjjjjj"));
    }

    private static int aaaaa(int aaa, String cccc) {
//        int aaa = 50 * 1000;
        new Timer("timer - ").schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println((Thread.currentThread().getName() + cccc));
//                System.gc();
                this.cancel();
            }
        }, aaa);

        return 0;
    }

    /**
     * 第一种方法：常规方法。利用String.charAt(i)以及String.valueOf(char).equals(" "
     * )遍历字符串并判断元素是否为空格。是则替换为"%20",否则不替换
     */
    public static String replaceSpace(StringBuffer str) {

        int length = str.length();
        // System.out.println("length=" + length);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char b = str.charAt(i);
            if (String.valueOf(b).equals(" ")) {
                result.append("%20");
            } else {
                result.append(b);
            }
        }
        return result.toString();
    }

    }
