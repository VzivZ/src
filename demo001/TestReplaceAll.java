package demo001;

import java.util.regex.Pattern;

/**
 * @description: 压缩连续空格到只剩下一个
 * @author: HeZhe
 * @date: 2019-10-09 17:02
 **/
public class TestReplaceAll {
    static int count = 0;

    public static void main(String[] agrs) {
        ms();
//        x(x(8));
//        System.out.println(count);
    }

    private static int x(int n) {
        count++;
        if (n <= 3) return 1;
        else return x(n - 2) + x(n - 4) + 1;
    }

    private double m(byte x, double y) {
        return (short) x / y * 2;
    }

    private static void ms() {
        int t = 1, a = 2, b = -1;
        if ((a = b) > 0) {
            t = a++;
        }
        System.out.println(t);
    }
}
