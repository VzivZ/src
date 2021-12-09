package leetcode.daily.no077.back_tracking;

/**
 * @description: 357. 计算各个位数不同的数字个数
 * 给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。
 * 示例:
 * 输入: 2
 * 输出: 91
 * 解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-numbers-with-unique-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-08 11:12
 **/
public class CountNumbersWithUniqueDigits {
    private static int res = 0;

    private static int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        countNumbersWithUniqueDigits(nums, 0, n);
        return res + 1;
    }

    private static int[] tag = new int[10];

    private static void countNumbersWithUniqueDigits(int[] nums, int start, int n) {
        if (n == 0) return;
        for (int i = 0; i < nums.length; i++) {
            if (start != i && tag[i] == 0) {
                tag[i] = 1;
                res++;
                countNumbersWithUniqueDigits(nums, i, n - 1);
                tag[i] = 0;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(1));
        System.out.println(countNumbersWithUniqueDigits(2));

    }
}
