package leetcode.interview.no0203;

import leetcode.node.ListNode;

/**
 * @description: 面试题 02.03. 删除中间节点
 * 实现一种算法，删除单向链表中间的某个节点（即不是第一个或最后一个节点），假定你只能访问该节点。
 * @author: HeZhe
 * @date: 2020-08-11 10:39
 **/
public class DeleteMiddleNode {
    public void deleteNode(ListNode node) {
        //就是删除 node 结点，
        //实际就是将后面节点的值前移 覆盖当前的节点值
        //然后删除后面一个节点即可
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
