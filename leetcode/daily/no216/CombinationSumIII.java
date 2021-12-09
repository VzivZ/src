package leetcode.daily.no216;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-11 09:34
 **/
public class CombinationSumIII {

    private List<List<Integer>> results = new ArrayList<>();
    private List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        getResults(k, n, 1);
        return results;
    }

    private void getResults(int k, int n, int start) {
        if (k == 0 && n == 0) {
            results.add(new ArrayList<>(tmp));
        }
        if (n <= 0 || k <= 0) return;
        for (int i = start; i < 10; i++) {
            tmp.add(i);
            getResults(k - 1, n - i, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSumIII combinationSumIII = new CombinationSumIII();
        System.out.println(combinationSumIII.combinationSum3(3, 7));
    }

}
