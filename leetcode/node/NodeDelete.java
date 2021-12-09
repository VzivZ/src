package leetcode.node;

/**
 * @ClassName NodeDelete
 * @Description
 * @Author HeZhe
 * @Date 2018/9/17 13:06
 */
public class NodeDelete {
	public static void deleteNode(ListNode node)    {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	public static ListNode removeElements(ListNode head, int val) {
		if(head == null){
			return null;
		}
		if(head.val==val){
			head=head.next;
		}
		if(head==null){
			return null;
		}
		ListNode node = head;
		while(node.next!=null){
			if(node.next.val==val){
				node.next = node.next.next;
			}else {
				node = node.next;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(6);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(4);
		ListNode node6 = new ListNode(5);
		ListNode node7 = new ListNode(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node6.next=node7;
		System.out.println(node1.val);
		ListNode node = removeElements(node1,6);
		System.out.println(node.val);
	}
}
