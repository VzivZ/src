package leetcode.algslv1;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Merge
 * @Description 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明:
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * @Author HeZhe
 * @Date 2018/11/22 13:50
 */
public class Merge {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		List<Integer> nums = new ArrayList<>();
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				nums.add(nums1[i]);
				i++;
			} else {
				nums.add(nums2[j]);
				j++;
			}
		}
		while (i < m) nums.add(nums1[i++]);
		while (j < n) nums.add(nums2[j++]);
		for (int x = 0; x < nums.size(); x++) nums1[x] = nums.get(x);
	}

	public static void merge2(int[] nums1, int m, int[] nums2, int n) {
		int end = m + n - 1;
		m--;
		n--;
		while (m >= 0 && n >= 0) {
			if (nums2[n] > nums1[m]) {
				nums1[end--] = nums2[n--];
			} else {
				nums1[end--] = nums1[m--];
			}
		}
		while (n >= 0) {
			nums1[end--] = nums2[n--];
		}
	}



	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 0, 0, 0};
		int[] nums2 = {2, 5, 6};
		int m = 3, n = 3;
		merge2(nums1, m, nums2, n);
		System.out.println(nums1);
	}
}
