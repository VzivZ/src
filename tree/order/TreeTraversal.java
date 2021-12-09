package tree.order;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @description: 二叉树遍历  https://www.jianshu.com/p/456af5480cee
 * @author: HeZhe
 * @date: 2020-09-14 14:34
 **/
public class TreeTraversal {
    // 递归前序遍历
    private static void recursionPreOrderTraversal(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        recursionPreOrderTraversal(root.left);
        recursionPreOrderTraversal(root.right);

    }

    //非递归前序遍历
    private List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，它的左右子树一定都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                list.add(node.val);
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                node = node.right;
            }
        }
        return list;
    }

    // 递归中序遍历
    private static void recursionMiddleOrderTraversal(TreeNode root) {
        if (root == null) return;
        recursionMiddleOrderTraversal(root.left);
        System.out.print(root.val + " ");
        recursionMiddleOrderTraversal(root.right);
    }

    /*
     * 和非递归先序遍历类似，唯一区别是考查到当前节点时，并不直接输出该节点。
     *
     * 而是当考查节点为空时，从栈中弹出的时候再进行输出(永远先考虑左子树，直到左子树为空才访问根节点)。
     */
    // 非递归中序遍历
    public static void middleOrderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<>();
        TreeNode node = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    // 递归后序遍历
    private static void recursionPostOrderTraversal(TreeNode root) {
        if (root != null) {
            recursionPostOrderTraversal(root.left);
            recursionPostOrderTraversal(root.right);
            System.out.print(root.val + " ");
        }
    }

    // 非递归后序遍历
    public static void postOrderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }

}
