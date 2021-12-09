package leetcode.algslv2.dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-10 16:58
 **/
public class CoinChangeProblem {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        recursion(coins, amount, 0, coins.length - 1);
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }

    private int minCount = Integer.MAX_VALUE;

    /**
     * 1、按金额从大到小，从多到少（排序，用余数一步到位）
     * 2、预判低于最优解，终止递归（可以返回最优解，不过提升有限，意义不大）
     * 3、能整除即可返回
     */
    private void recursion(int[] coins, int amount, int count, int index) {
        if (index < 0 || count + amount / coins[index] >= minCount) return;
        if (amount % coins[index] == 0) {
            minCount = Math.min(minCount, count + amount / coins[index]);
            return;
        }
        for (int i = amount / coins[index]; i >= 0; i--) {
            recursion(coins, amount - i * coins[index], count + i, index - 1);
        }
    }

    /* 基本的 N 叉树节点 */
    class TreeNode {
        int val;
        List<TreeNode> children;
    }

    private void traverse(TreeNode root) {
        for (TreeNode child : root.children)
            traverse(child);
    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(2);
    }
}
