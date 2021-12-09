package leetcode.daily.no347.pq.test01;

import java.util.PriorityQueue;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-09-07 15:20
 **/
public class App {
    public static void main(String[] args) {
        PriorityQueue<Student> q = new PriorityQueue<>((o1, o2) -> {
            if (o1.getScore() == o2.getScore()) {
                return o1.getName().compareTo(o2.getName());
            }
            //倒序
            return (o1.getScore() - o2.getScore()) * -1;
        });


        //入列
        q.offer(new Student("dafei", 20));
        q.offer(new Student("will", 17));
        q.offer(new Student("setf", 30));
        q.offer(new Student("bunny", 20));

        //出列
        Student student = q.poll();
        System.out.println(student.getName() + " " + student.getScore());  //Student{name='will', score=17}
        student = q.poll();
        System.out.println(student.getName() + " " + student.getScore());   //Student{name='bunny', score=20}
        student = q.poll();
        System.out.println(student.getName() + " " + student.getScore());   //Student{name='dafei', score=20}
        student = q.poll();
        System.out.println(student.getName() + " " + student.getScore());   //Student{name='setf', score=30}

    }
}
