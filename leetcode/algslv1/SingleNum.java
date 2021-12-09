package leetcode.algslv1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName SingleNum
 * @Description 只出现一次的数字
 * @Author VzivZ
 * @Date 2018/11/13 16:28
 */
public class SingleNum {
	public static int singleNumber(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length ; i = i + 2) {
			if (i + 1 >= nums.length ) {
				return nums[i];
			}
			if (nums[i] != nums[i + 1]) {
				return nums[i];
			}
		}

		return -1;
	}
	public static int singleNumber2(int[] nums){
		int res = 0;
		for (int i : nums) {
			res ^= i;
		}
		return res;
	}

	public static int singleNumber3(int[] nums){
		Map<Integer, Integer> map = new HashMap<>();
		//两个同等级for时间复杂度还是O(n)，两个嵌套的for时间复杂度就是O(n²)。
		for (int i = 0; i < nums.length; i++) {

			Integer value = map.get(nums[i]);
			map.put(nums[i], (value == null ? 0 : value) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {2,2,1};
		System.out.println(singleNumber2(nums));
	}
}
