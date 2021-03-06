package leetcode.daily.no040;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-10 09:53
 **/
public class CombinationSumII {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        return null;
//    }
//
//    private void getResults(int[] candidates, int begin, int target){
//        if(target == 0) return;
//        for (int i = begin; i < candidates.length; i++) {
//            if(candidates[i] > target) return;
//            getResults(candidates,i,target - candidates[i]);
//        }
//    }

    private List<List<Integer>> list = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return list;
    }

    private void dfs(int[] candidates, int target, int index) {
        if (target == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                path.add(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

    }
}
