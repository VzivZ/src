package leetcode.daily.no077;

import java.util.LinkedList;
import java.util.List;

/**
 * @description: 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * 示例:
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-08 09:58
 **/
public class Combinations {
    private List<List<Integer>> paths = new LinkedList<>();     // 总路径
    private List<Integer> path = new LinkedList<>();            // 某条路径

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return paths;
    }

    private void backtrack(int index, int n, int k) {
        int size = path.size();
        // 约束条件
        if (k - size > n - index + 1) {
            return;
        }
        // 结束条件
        if (size == k) {
            paths.add(new LinkedList(path));
            return;
        }

        // 选择列表
        for (int i = index; i <= n; i++) {
            path.add(i);                    // 选一个
            backtrack(i + 1, n, k);         // 进入下一层
            path.remove(path.size() - 1);   // 下一层返回，撤销选择
        }
    }
}
