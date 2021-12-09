package leetcode.algslv1;

//import org.junit.Test;

/**
 * @ClassName DpDemo001
 * @Description 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 * @Author VzivZ
 * @Date 2018/11/23 9:16
 */
public class DpDemo001 {
	public int maxSubArray(int[] nums) {
		int[] result = nums.clone();
		int maxSum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (result[i - 1] > 0) {
				result[i] = nums[i] + result[i - 1];
			}
			if (result[i] > maxSum) {
				maxSum = result[i];
			}
		}
		return maxSum;
	}

	public int maxSubArray2(int[] nums) {
		int temp = 0, res = Integer.MIN_VALUE;
		int len = nums.length;
		for (int num : nums) {
			if (temp < 0) temp = 0;  //如果前面的和小0，那么重新开始求和
			temp += num;
			res = Math.max(res, temp);
		}
		return res;
	}

	private int maxSubArray3(int[] nums) {
		return divide(nums, 0, nums.length - 1);
	}

	private int divide(int[] nums, int l, int r) {
		if (l == r) return nums[l];
		if (l == r - 1) return Math.max(nums[l], Math.max(nums[r], nums[l] + nums[r]));

		int mid = (l + r) >> 1;//右移一位相当于除以2  = =！
		int lRes = divide(nums, l, mid - 1);
		int rRes = divide(nums, mid + 1, r);

		int mRes = nums[mid];
		int sum = mRes;
		for (int i = mid - 1; i >= l; i--) {
			sum += nums[i];
			mRes = Math.max(mRes, sum);
		}
		sum = mRes;    //保存已经计算过的左边的最大子序和
		for (int i = mid + 1; i <= r; i++) {
			sum += nums[i];
			mRes = Math.max(mRes, sum);
		}
		return Math.max(lRes, Math.max(rRes, mRes));
	}

//	@Test
	public void test() {
		int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
		System.out.println(maxSubArray3(nums));
	}
}
