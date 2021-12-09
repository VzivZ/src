package leetcode.daily.no039;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 39. 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *  
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: HeZhe
 * @date: 2020-09-09 10:04
 **/
public class CombinationSum {

    private List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }


    private void getResult(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i])
                continue;
            //选择当前节点，类似于从当前节点开始往下遍历
            cur.add(candidates[i]);
            getResult(result, cur, candidates, target - candidates[i], i);
            //回到当前节点的时候我们把当前节点给移除,
            // 然后通过循环走同一层的其他节点。
            //举个例子，比如上面图中，最开始的时候
            // 我们先选择2，然后沿着这个分支走下去，
            //当回到当前分支的时候我们把2给移除，然后
            // 选择同一层的下一个3，沿着这个节点
            //分支走下去……
            cur.remove(cur.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = solution.combinationSum(candidates, target);
        System.out.println("outcome => " + res);
    }

}
