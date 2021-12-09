package leetcode.algslv2;

import java.util.*;

/**
 * @ClassName TopK
 * @Description 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * 示例 1:
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * @Author HeZhe
 * @Date 2018/11/26 14:20
 */
public class TopK {
	public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new TreeMap<>();
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());

		for (int i = 0; i < nums.length; i++) {
//			if (map.containsKey(nums[i])) {
//				map.put(nums[i], map.get(nums[i]) + 1);
//			} else {
//				map.put(nums[i], 1);
//			}
			//等同于上述注释写法
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			pq.add(entry);

		for (int i = 0; i < k; i++)
			list.add(pq.poll().getKey());

		return list;
	}

	public static List<Integer> topKFrequent2(int[] nums, int k) {

		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 2, 2, 3};
		int k = 2;
		topKFrequent(nums, k);
	}
}
