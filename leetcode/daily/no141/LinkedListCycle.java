package leetcode.daily.no141;

import leetcode.node.ListNode;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-10-09 10:07
 **/
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode a = head;
        ListNode b = head.next;
        while (b != null) {
            if (a == b) return true;
            a = a.next;
            if (b.next != null)
                b = b.next.next;
            else
                return false;
        }
        return false;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (root == null)
            return 0;
        int lh = height(root.left), rh = height(root.right);
        if (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, rh) + 1;
        } else {
            return -1;
        }
    }


    public ListNode detectCycle(ListNode head) {
        //1 是否有环？
        //使用快慢指针
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {//2.1 有环
                //找到入环的第一个节点？
                //思路：
                //1 设 a 表示起点到第一个入环节点的距离，这是个未知值
                //2 设 a + b 是快慢指针第一次相遇的节点，这是已知的
                //3 设 a + b + c 是整个链表的长度（不循环的情况下）
                // 由于存在 快指针走的长度是 慢指针的 2 倍，∴2（a+b） = a + b + c + b
                // 即 a = c，所以求出c即可
                ListNode ans = head;
                while (ans != fast) {
                    ans = ans.next;
                    fast = fast.next;
                }
                return ans;
            }
        }
        //2.2 无环
        return null;

    }

    //530. 二叉搜索树的最小绝对差
    //给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        preOrder(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int abs = Math.abs(list.get(i) - list.get(i - 1));
            if (abs < min)
                min = abs;
        }
        return min;
    }

    private List<Integer> list = new ArrayList<>();

    private void preOrder(TreeNode node) {
        if (node == null) return;
        preOrder(node.left);
        list.add(node.val);
        preOrder(node.right);
    }

}
