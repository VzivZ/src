package leetcode.node;

/**
 * @ClassName ListNode
 * @Description
 * @Author VzivZ
 * @Date 2018/9/13 8:43
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static void main(String[] args) {
        test(null);
    }

    private static void test(Integer a){
        System.out.println(a == 0);
    }
}
