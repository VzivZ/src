package leetcode.tencent.node;

import leetcode.node.ListNode;

/**
 * @ClassName SortNodeList
 * @Description
 * @Author VzivZ
 * @Date 2018/11/2 15:00
 */
public class SortNodeList {
	public static ListNode sortList(ListNode head) {
		if (head == null)
			return head;
		//定义一个新的链表用于存储排序好的链表
		ListNode newHead = new ListNode(0);
		//cur用于遍历要排序的链表，pre指向排序好的链表，next暂存剩下的链表
		ListNode cur = head;
		ListNode pre = newHead;
		ListNode next;
		while (cur != null) {
			//保存cur后面的链表
			next = cur.next;
			//一般都选择在当前元素后面插入，因为这样比较方便，也不会出现边界异常的现象
			while (pre.next != null && pre.next.val < cur.val) {
				pre = pre.next;
			}
			//插入到相应位置
			cur.next = pre.next;
			pre.next = cur;
			//恢复pre和cur的值
			pre = newHead;
			cur = next;
		}
		return newHead.next;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(6);
		ListNode node6 = new ListNode(5);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		ListNode a = sortList(node1);
		while (a != null) {
			System.out.print(a.val + " ");
			a = a.next;
		}
	}
}
