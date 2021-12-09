package leetcode.topk;

import java.util.Arrays;

/**
 * @description: 506.相对名次
 * @author: HeZhe
 * @date: 2019-07-10 16:44
 **/
public class TopK01 {
    public static String[] findRelativeRanks(int[] nums) {
        final int len = nums.length;
        int digit = 1;
        while (len >> digit != 0) {
            digit++;
        }
        final long[] record = new long[len];
        for (int i = 0; i < len; i++) {
            record[i] = (long) (nums[i] << digit) + i;
        }
        Arrays.sort(record);
        final String[] result = new String[len];
        int p = (1 << digit) - 1;
        for (int i = len - 1, rak = 1; i > -1; i--, rak++) {
            switch (rak) {
                case 1:
                    result[(int) (record[i] & p)] = "Gold Medal";
                    break;
                case 2:
                    result[(int) (record[i] & p)] = "Silver Medal";
                    break;
                case 3:
                    result[(int) (record[i] & p)] = "Bronze Medal";
                    break;
                default:
                    result[(int) (record[i] & p)] = String.valueOf(rak);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        System.out.println(Arrays.toString(findRelativeRanks(nums)));
    }
}
