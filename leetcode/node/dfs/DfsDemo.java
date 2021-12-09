package leetcode.node.dfs;

import tree.TreeNode;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-08-11 16:05
 **/
public class DfsDemo {
    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        dfs(root.right);
    }
}
