package leetcode.daily.no094;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-09-14 10:52
 **/
public class Solution094 {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal02(TreeNode root) {
        helper(root);
        return list;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        list.add(root.val);
        helper((root.right));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();

        do {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                list.add(node.val);
                root = node.right;
            }
        } while (!stack.isEmpty() || root != null);

        return list;
    }
}
