package leetcode.algslv2;

/**
 * @ClassName BeginAnDEnd
 * @Description 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * @Author HeZhe
 * @Date 2018/11/28 16:27
 */
public class BeginAnDEnd {
	public static int[] searchRange(int[] nums, int target) {
		int[] res = {-1, -1};
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				res[0] = i;
				break;
			}
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == target) {
				res[1] = i;
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {5, 7, 7, 8, 8, 10};
		int target = 6;
		int[] arr = searchRange(nums, target);
		for (int a : arr) {
			System.out.println(a);
		}
	}
}
