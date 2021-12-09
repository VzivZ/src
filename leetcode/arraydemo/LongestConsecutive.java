package leetcode.arraydemo;

import java.util.*;

/**
 * @ClassName LongestConsecutive
 * @Description 最长连续序列
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @Author VzivZ
 * @Date 2019/1/25 13:59
 */
public class LongestConsecutive {
	public static int longestConsecutive(int[] nums) {
		Arrays.sort(nums);
		HashSet<Integer> hs = new HashSet<>();
		for (int num1 : nums) {
			hs.add(num1);
		}
		int max = 0;
		for (int num : nums) {
			if (hs.contains(num)) {
				int count = 1;
				hs.remove(num);

				int low = num - 1;
				while (hs.contains(low)) {
					hs.remove(low);
					low--;
					count++;
				}

				int high = num + 1;
				while (hs.contains(high)) {
					hs.remove(high);
					high++;
					count++;
				}
				max = Math.max(max, count);
			}
		}
		return max;
	}

	public static int longestcontinueArrays(int[] nums) {

		Map<Integer, Integer> m = new HashMap<>();
		int maxLen = 0;
		for (int num : nums) {
			if (m.containsKey(num)) continue;
			int left = m.getOrDefault(num - 1, 0);
			int right = m.getOrDefault(num + 1, 0);
			int len = left + right + 1;
			maxLen = Math.max(maxLen, len);
			m.put(num - left, len);
			m.put(num + right, len);
			m.put(num, len);
		}
		return maxLen;

	}

	public int longestConsecutive2(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		for (int num : nums) set.add(num);
		for (int num : nums)
			if (!set.contains(num - 1)) {
				int val = num;
				while (set.remove(val++)) ;
				max = Math.max(max, val - num - 1);
			}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = {1, 0, 1, 2, 3};
		int sss = longestcontinueArrays(nums);
		System.out.println(sss);
	}
}
