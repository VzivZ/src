package demo001;

import java.util.Stack;

/**
 * @description:
 * @author: VzivZ
 * @date: 2019-10-31 16:11
 **/
public class NodeDemo<T> {
    public void reverse(ListNode<T> head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode<T> currentNode = head;
        Stack<ListNode<T>> stack = new Stack<>();
        while (currentNode != null) {
            stack.push(currentNode);
            ListNode<T> tempNode = currentNode.next;
            currentNode.next = null; // 断开连接
            currentNode = tempNode;
        }

        head = stack.pop();
        currentNode = head;

        while (!stack.isEmpty()) {
            currentNode.next = stack.pop();
            currentNode = currentNode.next;
        }
    }
}

class ListNode<T> {
    private T val;

    public ListNode(T val) {
        this.val = val;
    }

    ListNode<T> next;
}
