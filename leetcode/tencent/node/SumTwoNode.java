package leetcode.tencent.node;

import leetcode.node.ListNode;

/**
 * @ClassName SumTwoNode
 * @Description
 * @Author VzivZ
 * @Date 2018/11/2 8:20
 */
public class SumTwoNode {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String l1Str = "";
		String l2Str = "";
		while (l1 != null) {
			l1Str += String.valueOf(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			l2Str += String.valueOf(l2.val);
			l2 = l2.next;
		}
		Integer l3 = Integer.parseInt(l1Str) + Integer.parseInt(l2Str);
		String[] a = l3.toString().split("");
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		for (int i = 0; i < a.length; i++) {
			int tmp = Integer.parseInt(a[i]);
			cur.next = new ListNode(tmp);
			cur = cur.next;
		}
		return dummy.next;
	}

	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int d1 = l1 == null ? 0 : l1.val;
			int d2 = l2 == null ? 0 : l2.val;
			int sum = d1 + d2 + carry;
			carry = sum >= 10 ? 1 : 0;
			cur.next = new ListNode(sum % 10);
			cur = cur.next;
			if (l1 != null) l1 = l1.next;
			if (l2 != null) l2 = l2.next;
		}
		if (carry == 1) cur.next = new ListNode(1);
		return dummy.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);

		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		addTwoNumbers(node1, node4);
	}
}
