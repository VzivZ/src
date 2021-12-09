package leetcode.daily.no347.pq;

import java.util.PriorityQueue;

/**
 * @description: PriorityQueue 基本使用
 * @author: HeZhe
 * @date: 2020-09-07 15:17
 **/
public class Test {
    public static void main(String[] args) {
        PriorityQueue<String> q = new PriorityQueue<>();
        //入列
        q.offer("1");
        q.offer("2");
        q.offer("5");
        q.offer("3");
        q.offer("4");

        //出列
        System.out.println(q.poll());  //1
        System.out.println(q.poll());  //2
        System.out.println(q.poll());  //3
        System.out.println(q.poll());  //4
        System.out.println(q.poll());  //5
    }
}
