package leetcode.algslv1;

import leetcode.node.ListNode;

/**
 * @ClassName NodeDelete
 * @Description 删除链表的倒数第N个节点
 * 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 * @Author VzivZ
 * @Date 2018/11/16 10:25
 */
public class NodeDelete2 {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode preNode = head;
		ListNode curNode = head;

		for (int i = 0; i < n; i++) {
			curNode = curNode.next;
		}

		if (curNode == null) {
			return preNode.next;
		}

		while (curNode.next != null) {
			preNode = preNode.next;
			curNode = curNode.next;
		}

		preNode.next = preNode.next.next;

		return head;

	}

	public static ListNode remove(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		int len = 0;
		ListNode cur = head;
		//计算链表的长度
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		//计算正向的位置
		int where = len - n + 1;
		if (where == 1) {
			return head.next;
		}
		cur = head;
		int i = 0;
		while (cur != null) {
			i++;
			if (i == where - 1) {
				cur.next = cur.next.next;
			}
			cur = cur.next;
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;

		remove(node1, 2);
		System.out.println(node1.val);

	}
}
