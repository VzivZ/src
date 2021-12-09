package leetcode.algslv1;

import leetcode.node.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName Palindrome
 * @Description 回文链表
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * @Author HeZhe
 * @Date 2018/11/16 14:46
 */
public class Palindrome {
	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		List<Integer> temp = new ArrayList<>();
		temp.add(head.val);
		while (head.next != null) {
			temp.add(head.next.val);
			head = head.next;
		}
		for (int i = 0; i < temp.size(); i++) {
			int a = temp.get(i);
			int b = temp.get(temp.size() - 1 - i);
			if (a != b) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPalindrome2(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode slow = head;
		ListNode fast = head;
		Stack<Integer> stack = new Stack<>();
		stack.push(head.val);
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			stack.push(slow.val);
		}
		if (fast.next == null) {
			stack.pop();
		}
		while (slow.next != null) {
			slow = slow.next;
			int tmp = stack.pop();
			if (tmp != slow.val) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(-129);
		ListNode node3 = new ListNode(-129);
		ListNode node4 = new ListNode(1);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		System.out.println(isPalindrome2(node1));
	}
}
