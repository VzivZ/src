package leetcode.algslv2;

/**
 * @ClassName ColorSorted
 * @Description 颜色分类
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * 示例:
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 * 进阶：
 * 一个直观的解决方案是使用计数排序的两趟扫描算法。
 * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 * @Author HeZhe
 * @Date 2018/11/26 13:11
 */
public class ColorSorted {
	//冒泡暴力解决
	public static void sortColors(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
				}
			}
		}
	}

	//看不懂
	public static void sortColors2(int[] nums) {
		int i = -1, j = -1, k = -1;
		for (int m = 0; m < nums.length; m++) {
			if (nums[m] == 0) {
				nums[++k] = 2;
				nums[++j] = 1;
				nums[++i] = 0;
			} else if (nums[m] == 1) {
				nums[++k] = 2;
				nums[++j] = 1;
			} else {
				nums[++k] = 2;
			}
		}
	}

	//重写数组
	public void sortColors3(int[] nums) {

		int r = 0, w = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				r++;
			} else if (nums[i] == 1) {
				w++;
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (i < r) {
				nums[i] = 0;
			} else if (i < r + w) {
				nums[i] = 1;
			} else {
				nums[i] = 2;
			}
		}
	}

	public static void sortColors4(int[] nums) {

		int left = 0;

		int right = nums.length - 1;

		for (int i = 0; i <= right; i++) {
			if (nums[i] == 0) {
				swap(nums, left, i);
				left++;
			} else if (nums[i] == 2) {
				swap(nums, right, i);
				right--;
				//i-- 是因为交换了之后还要重复判断交换过来的数是什么
				i--;
			}
		}
	}

	private static void swap(int[] nums, int start, int i) {
		int temp = nums[start];
		nums[start] = nums[i];
		nums[i] = temp;
	}

	public static void main(String[] args) {
		int[] nums = {2, 0, 2, 1, 1, 0};
		sortColors4(nums);
		System.out.println(nums[0]);
	}
}
