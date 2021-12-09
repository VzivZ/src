package offer;

/**
 * @description: 斐波那契数列
 * @author: HeZhe
 * @date: 2019-12-21 14:41
 **/
public class No09 {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(getMethodNumber(10));
    }

    private static long fibonacci(int n) {
        long[] a = {0, 1};
        if (n < 2)
            return a[n];
        long fib1 = 0;
        long fib2 = 1;
        long fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fib1 + fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;

    }


    private static int getMethodNumber(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        return getMethodNumber(n - 1) + getMethodNumber(n - 2);
    }
}
