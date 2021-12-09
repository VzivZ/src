package demo001.de;

//import leetcode.node.ListNode;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-04-22 13:42
 **/
public class AssertDemo {
    public static void main(String[] args) {
        String obj = null;
        long time = System.currentTimeMillis();
        if (time % 2 == 0) {
            obj = "jjjjj";
        }
        assert obj != null;
        System.out.println(obj);
    }
}
