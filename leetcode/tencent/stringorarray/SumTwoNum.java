package leetcode.tencent.stringorarray;

import java.util.HashMap;

/**
 * @ClassName SumTwoNum
 * @Description
 * @Author HeZhe
 * @Date 2018/10/8 9:17
 */
public class SumTwoNum {
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int b = nums[j];
				if (a + b == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
	}

	public static int[] twoSum2(int[] nums, int target) {
		int[] a = new int[2];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				a[0] = map.get(nums[i]);
				a[1] = i;
				return a;
			}
			//存储差值为key,下标为value
			map.put(target - nums[i], i);
		}
		return a;
	}

	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		int[] a = twoSum2(nums, target);
		for (int x : a) {
			System.out.println(x + " ");
		}
	}
}
