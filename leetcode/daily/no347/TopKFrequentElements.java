package leetcode.daily.no347;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @description: 347. 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: HeZhe
 * @date: 2020-09-07 11:27
 **/
public class TopKFrequentElements {
    private static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        pq.addAll(map.entrySet());
        int[] arr = new int[k];
        for (int i = 0; i < k; i++)
            arr[i] = Objects.requireNonNull(pq.poll()).getKey();

        return arr;
    }


    public int[] topKFrequent02(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> counter = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // 定义小根堆，根据数字频率自小到大排序
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> counter.get(v1) - counter.get(v2));
        // 遍历数组，维护一个大小为 k 的小根堆：
        // 不足 k 个直接将当前数字加入到堆中；否则判断堆中的最小次数是否小于当前数字的出现次数，若是，则删掉堆中出现次数最少的一个数字，将当前数字加入堆中。
        counter.forEach((num, cnt) -> {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (counter.get(pq.peek()) < cnt) {
                pq.poll();
                pq.offer(num);
            }
        });
        // 构造返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    public int[] topKFrequent03(int[] nums, int k) {
        // 统计每个数字出现的次数
        Map<Integer, Integer> counterMap = IntStream.of(nums).boxed().collect(Collectors.toMap(e -> e, e -> 1, Integer::sum));
        // 一个数字最多出现 nums.length 次，因此定义一个长度为 nums.length + 1 的数组，freqList[i] 中存储出现次数为 i 的所有数字。
        List<Integer>[] freqList = new List[nums.length + 1];
        for (int i = 0; i < freqList.length; i++) {
            freqList[i] = new ArrayList<>();
        }
        counterMap.forEach((num, freq) -> {
            freqList[freq].add(num);
        });
        // 按照出现频次，从大到小遍历频次数组，构造返回结果。
        int[] res = new int[k];
        int idx = 0;
        for (int freq = freqList.length - 1; freq > 0; freq--) {
            for (int num : freqList[freq]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 2, 3};
        int k = 2;
        int[] arr = topKFrequent(nums, k);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
