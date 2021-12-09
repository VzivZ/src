package leetcode.algslv1;

import leetcode.node.ListNode;

/**
 * @ClassName MergeTwoNode
 * @Description 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author VzivZ
 * @Date 2018/11/16 13:40
 */
public class MergeTwoNode {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergedHead;
        ListNode temp1;
        ListNode temp2;
        if (l1.val < l2.val) {
            mergedHead = l1;
            temp1 = l1.next;
            temp2 = l2;
        } else {
            mergedHead = l2;
            temp1 = l1;
            temp2 = l2.next;
        }
        ListNode temp = mergedHead;
        while (temp1.next != null || temp2.next != null) {
            if (temp1.val < temp2.val) {
                temp.next = temp1;
                temp = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp = temp2;
                temp2 = temp2.next;
            }
        }
        temp.next = temp1 == null ? temp2 : temp1;
        return mergedHead;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode mergeHead;

        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists2(l1.next, l2);
        } else {
            mergeHead = l2;
            mergeHead.next = mergeTwoLists2(l1, l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        test(null);


        node1.next = node2;
        node2.next = node3;

        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(3);
        ListNode nodeC = new ListNode(4);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        ListNode a = mergeTwoLists(node1, nodeA);
        System.out.println(a.val);
    }

    public static void test(Integer a) {
        System.out.println(a == 0);
    }

}
