package leetcode.node;

import java.util.LinkedList;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-09-15 11:14
 **/
public class CQueue {
    private LinkedList<Integer> A, B;

    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void appendTail(int value) {
        A.addLast(value);
    }

    public int deleteHead() {
        if (!B.isEmpty()) return B.removeLast();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }
}
