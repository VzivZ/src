package leetcode.daily.no222;

import tree.TreeNode;

class Solution {
    public int countNodes(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int count) {
        if (root == null) {
            return count;
        }
        count = dfs(root.left, count + 1);
        return dfs(root.right, count);
    }

}
