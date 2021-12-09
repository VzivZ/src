package leetcode.node;

import leetcode.node.ListNode;

import java.util.LinkedList;

/**
 * @description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @author: HeZhe
 * @date: 2020-09-15 10:34
 **/
public class NodeDemo003 {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }
}
