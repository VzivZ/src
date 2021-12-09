package leetcode.daily.no047;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 47. 全排列 II
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-18 14:47
 **/
public class permutationsII {
    private List<List<Integer>> res = new ArrayList<>(); // 记录最终答案

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        // visited[i] == 0时，未访问；== 1时，已访问
        int[] visited = new int[nums.length];
        Arrays.sort(nums); // 排序后容易去重
        backTrack(res, nums, new ArrayList<>(), visited);
        return res;
    }

    private void backTrack(List<List<Integer>> res, int[] nums, List<Integer> list, int[] visited) {
        // 列表长度为数组长度时，拷贝列表到结果列表中
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue; // 已访问过，跳过这层循环
            // 如果数组相连元素相等，没有先访问后面的元素，就不会存在重复
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) {
                continue;
            }
            // 加入列表中，标记为已访问，回溯求值
            list.add(nums[i]);
            visited[i] = 1;
            backTrack(res, nums, list, visited);
            // 回溯后，重新标记为未访问，删掉最后一个元素
            visited[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
