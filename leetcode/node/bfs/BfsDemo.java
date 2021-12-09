package leetcode.node.bfs;

import tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-08-11 16:08
 **/
public class BfsDemo {
    void aaa(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // Java 的 pop 写作 poll()
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
