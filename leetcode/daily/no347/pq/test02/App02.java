package leetcode.daily.no347.pq.test02;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-07 20:07
 **/
public class App02 {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>((u1, u2) -> {
            if (u1.number.charAt(0) == u2.number.charAt(0)) {
                // 如果两人的号都是A开头或者都是V开头,比较号的大小:
                return u1.number.compareTo(u2.number);
            }
            if (u1.number.charAt(0) == 'V') {
                // u1的号码是V开头,优先级高:
                return -1;
            } else {
                return 1;
            }
        });
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        System.out.println(q.poll()); // Boss/V1
        System.out.println(q.poll()); // Bob/A1
        System.out.println(q.poll()); // Alice/A2
        System.out.println(q.poll()); // null,因为队列为空
    }
}
