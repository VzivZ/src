package leetcode.tencent.stringorarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName SumThreeNum
 * @Description
 * @Author VzivZ
 * @Date 2018/10/19 15:47
 */
public class SumThreeNum {
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			int m = nums.length - 1;
			int j = i + 1;
			while (j < m) {
				int y = nums[j];
				int z = nums[m];
				if (x + y + z == 0) {
					List<Integer> a = new ArrayList<>();
					a.add(x);
					a.add(y);
					a.add(z);
					if (!result.contains(a)) {
						result.add(a);
					}
					j++;
				} else if (x + y + z <= 0) {
					j++;
				} else {
					m--;
				}
			}

		}
		return result;
	}

	public static List<List<Integer>> threeSum2(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {

			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				int lo = i + 1;
				int hi = nums.length - 1;
				int sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
						while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum) {
						lo++;
					} else {
						hi--;
					}
				}
			}
		}
		return res;
	}

	public static List<List<Integer>> threeSum3(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> result = new ArrayList<>();
		int i, j, k, reserve;
		for (i = 0; i < nums.length - 2; i++) {
			reserve = -nums[i];
			j = i + 1;
			k = nums.length - 1;
			while (j < k) {
				if (nums[j] + nums[k] == reserve) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					tmp.add(nums[k]);
					result.add(tmp);
					j++;
					while (j < k && nums[j - 1] == nums[j]) {
						j++;
					}
					k--;
				} else if (nums[j] + nums[k] < reserve) {
					j++;
					while (j < k && nums[j - 1] == nums[j]) {
						j++;
					}
				} else {
					k--;
				}
				while (i + 1 < nums.length - 2 && nums[i] == nums[i + 1]) {
					i++;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		threeSum3(nums);
	}
}
