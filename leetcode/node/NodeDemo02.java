package leetcode.node;

/**
 * @ClassName NodeDemo02
 * @Description 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @Author VzivZ
 * @Date 2018/9/13 9:21
 */
public class NodeDemo02 {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode result = null;
		if (l1.val < l2.val) {
			result = l1;
			result.next = mergeTwoLists(l1.next, l2);
		} else {
			result = l2;
			result.next = mergeTwoLists(l1, l2.next);
		}
		return result;
	}

	public static ListNode mergeTwoNode(ListNode l1, ListNode l2) {

		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode result;
		ListNode temp1;
		ListNode temp2;

		if (l1.val < l2.val) {
			result = l1;
			temp1 = l1.next;
			temp2 = l2;
		} else {
			result = l2;
			temp1 = l1;
			temp2 = l2.next;
		}
		ListNode temp = result;

		while (temp1 != null || temp2 != null) {
			if(temp1.val < temp2.val){
				temp.next = temp1;
				temp = temp1;
				temp1 = temp1.next;
			}else{
				temp.next = temp1;
				temp = temp2;
				temp2 = temp2.next;
			}
		}
		temp.next = temp1==null ? temp2:temp1;
		return result;
	}
}
