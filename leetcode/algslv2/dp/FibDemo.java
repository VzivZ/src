package leetcode.algslv2.dp;

/**
 * @description: 动态规划
 * @author: HeZhe
 * @date: 2020-09-10 16:34
 **/
public class FibDemo {
    //暴力递归，复杂度爆炸
    private int fib(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    //带备忘录的递归
    private int fib02(int N) {
        if (N < 1) return 0;
        // 备忘录全初始化为 0
        int[] memo = new int[N + 1];
        // 进行带备忘录的递归
        return helper(memo, N);
    }

    private int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) return 1;
        // 已经计算过
        if (memo[n] != 0) return memo[n];
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    //动态规划
    int fib03(int N) {
        int[] dp = new int[N + 1];

        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++)
            dp[i] = dp[i - 1] + dp[i - 2];
        return dp[N];
    }

    int fib04(int n) {
        if (n == 2 || n == 1)
            return 1;
        int prev = 1, curr = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public static void main(String[] args) {
        FibDemo fibDemo = new FibDemo();

        System.out.println(fibDemo.fib02(3));
    }

}
