package leetcode.algslv2;

/**
 * @ClassName FzOrz
 * @Description 寻找峰值
 * 峰值元素是指其值大于左右相邻值的元素。
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * 示例 1:
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * 你的解法应该是 O(logN) 时间复杂度的。
 * @Author VzivZ
 * @Date 2018/11/28 15:46
 */
public class FzOrz {
	public static int findPeakElement(int[] nums) {
		if (nums.length == 1) {
			return 0;
		}
		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				if (nums[i] > nums[i + 1]) {
					return i;
				}
			} else if (i > 0 && i + 1 < nums.length) {
				if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
					return i;
				}
			}
			if (i == nums.length - 1) {
				if (nums[i] > nums[i - 1]) {
					return i;
				}
			}
		}
		return 0;
	}

	public static int findPeakElement2(int[] nums) {
		//二分法
		//由于两端都是负无穷，因此只要左右两端任一端比中点大，意味着那一侧有峰
		int left = 0, right = nums.length - 1;
		int mid = left + (right - left) / 2;
		while (left <= right) {
			//最后的结果，left 和right相邻且nums[left]比左边大，nums[right]比右边大
			//故这二者的最大值即为峰值，返回其下标即可
			if (mid == left) return nums[right] > nums[left] ? right : left;
			if (nums[mid] < nums[mid + 1]) {
				left = mid;
			} else if (nums[mid] > nums[mid + 1]) {
				right = mid;
			}
			mid = left + (right - left) / 2;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 1, 3, 5, 6, 4};
		int a = findPeakElement(nums);
		System.out.println(a);
	}
}
