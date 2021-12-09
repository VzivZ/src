package leetcode.algslv2;

import java.util.Arrays;

/**
 * @ClassName TopK002
 * @Description 数组中的第K个最大元素
 * 在未排序的数组中找到第 k 个最大的元素。
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * @Author VzivZ
 * @Date 2018/11/28 10:35
 */
public class TopK002 {
	public static int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	//冒泡排序
	public static void sort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - 1 - i; j++) {
				if (nums[j] > nums[j + 1]) {
					int temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}
			}
		}
	}

	//选择排序
	public static void selectionSort(int[] arr) {
		int min;
		for (int i = 0; i < arr.length; i++) {
			// 初始化未排序序列中最小数据数组下标
			min = i;
			for (int j = i+1; j < arr.length; j++) {
				// 在未排序元素中继续寻找最小元素，并保存其下标
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			// 将未排序列中最小元素放到已排序列末尾
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}

	/**
	 * 堆排序的主要入口方法，共两步。
	 */
	public static void sort002(int[] arr) {
	    /*
         *  第一步：将数组堆化
         *  beginIndex = 第一个非叶子节点。
         *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
         *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
         */
		int len = arr.length - 1;
		int beginIndex = (len - 1) >> 1;
		for (int i = beginIndex; i >= 0; i--) {
			maxHeapify(arr, i, len);
		}

        /*
         * 第二步：对堆化数据排序
         * 每次都是移出最顶层的根节点A[0]，与最尾部节点位置调换，同时遍历长度 - 1。
         * 然后从新整理被换到根节点的末尾元素，使其符合堆的特性。
         * 直至未排序的堆长度为 0。
         */
		for (int i = len; i > 0; i--) {
			swap(arr, 0, i);
			maxHeapify(arr, 0, i - 1);
		}
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * 调整索引为 index 处的数据，使其符合堆的特性。
	 *
	 * @param index 需要堆化处理的数据的索引
	 * @param len   未排序的堆（数组）的长度
	 */
	private static void maxHeapify(int[] arr, int index, int len) {
		int li = (index << 1) + 1; // 左子节点索引
		int ri = li + 1;           // 右子节点索引
		int cMax = li;             // 子节点值最大索引，默认左子节点。

		if (li > len) return;       // 左子节点索引超出计算范围，直接返回。
		if (ri <= len && arr[ri] > arr[li]) // 先判断左右子节点，哪个较大。
			cMax = ri;
		if (arr[cMax] > arr[index]) {
			swap(arr, cMax, index);      // 如果父节点被子节点调换，
			maxHeapify(arr, cMax, len);  // 则需要继续判断换下后的父节点是否符合堆的特性。
		}
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi || arr == null || arr.length <= 1) {
			return;
		}
		int mid = (lo + hi) >> 1;
		int i = lo;
		int j = hi;
		while (i <= j) {
			while (arr[i] < arr[mid]) {
				i++;
			}
			while (arr[j] > arr[mid]) {
				j--;
			}
			int tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
			i++;
			j--;

		}
		quickSort(arr, lo, mid - 1);
		quickSort(arr, mid + 1, hi);
	}


	public static void main(String[] args) {
		int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
		int k = 4;
//		sort(nums);
//		quickSort(nums, 0, nums.length - 1);
//		sort002(nums);
		selectionSort(nums);
		System.out.println(nums[0]);
//		System.out.println(findKthLargest(nums, k));
	}
}
