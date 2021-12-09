package leetcode.node.dfs;

import tree.TreeNode;

import java.util.*;

/**
 * @description: 107. 二叉树的层次遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其自底向上的层次遍历为：
 * <p>
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: VzivZ
 * @date: 2020-09-08 17:07
 **/
public class BinaryTreeLevelOrderTraversalIi {
    private List<List<Integer>> nodePool = new ArrayList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return nodePool;
        traverse(root, 0);
        Collections.reverse(nodePool);
        return nodePool;
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) return;
        if (nodePool.size() - 1 < level)
            nodePool.add(new ArrayList<>());
        nodePool.get(level).add(root.val);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }


    public List<List<Integer>> levelOrderBottom02(TreeNode root) {
        //边界条件判断
        if (root == null)
            return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        //根节点入队
        queue.add(root);
        //如果队列不为空就继续循环
        while (!queue.isEmpty()) {
            //BFS打印，levelNum表示的是每层的结点数
            int levelNum = queue.size();
            //subList存储的是每层的结点值
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                //出队
                TreeNode node = queue.poll();
                subList.add(Objects.requireNonNull(node).val);
                //左右子节点如果不为空就加入到队列中
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            //把每层的结点值存储在res中，（从下往上打印，关键点在这）
            res.add(0, subList);
        }
        return res;
    }
}
