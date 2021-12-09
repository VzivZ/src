package leetcode.daily.february;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Description:
 * @Author VzivZ
 * @Date 2021/3/4 10:47
 */
public class Solution0304 {
    public int maxEnvelopes(int[][] envelopes) {
        // 问题在于怎么通过宽度进行排序了
        int n = envelopes.length;
        // 按宽度进行升序排列，如果宽度一致，则按高度升序排列
        Arrays.sort(envelopes,
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][0] > envelopes[j][0]
                        && envelopes[i][1] > envelopes[j][1]) {
                    tmp = Math.max(tmp, dp[j] + 1);
                }
            }
            dp[i] = tmp;
            max = Math.max(tmp, max);
        }
        return max;
    }
}
