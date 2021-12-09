package leetcode.daily.no257;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * 输出: ["1->2->5", "1->3"]
 * <p>
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-04 10:19
 **/
public class BinaryTreePaths {
    private static List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) return list;
        binaryTreePaths(root, list, "");
        return list;
    }

    /**
     * 深度优先遍历
     *
     * @param note 根节点
     * @param list 结果集
     * @param path 记录结果
     */
    private static void binaryTreePaths(TreeNode note, List<String> list, String path) {
        path += String.valueOf(note.val);
        if (note.left == null && note.right == null) {
            list.add(path);
            return;
        }
        if (note.left != null) binaryTreePaths(note.left, list, path + "->");
        if (note.right != null) binaryTreePaths(note.right, list, path + "->");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node02 = new TreeNode(2);
        TreeNode node03 = new TreeNode(3);
        TreeNode node05 = new TreeNode(5);

        root.left = node02;
        root.right = node03;
        node02.right = node05;

        List<String> list = binaryTreePaths(root);
        list.forEach(s -> {
            System.out.println(s);
            System.out.println();
        });
    }
}
