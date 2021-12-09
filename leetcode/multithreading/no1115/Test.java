package leetcode.multithreading.no1115;

/**
 * @description: 1115.交替打印FooBar
 * @author: VzivZ
 * @date: 2020-08-10 10:36
 **/
public class Test {
    public static void main(String[] args) {
        FooBar fb = new FooBar(5);
        Thread t1 = new Thread(new PrintFoo(fb));
        // 一个线程 参数是实现了Runnable的对象
        Thread t2 = new Thread(new PrintBar(fb));
        // 第二个线程 参数是实现了Runnable的对象
        // 题目要求这个两个线程共享FooBar对象fb

        t2.start();  // 注意不能是run()
        t1.start();  // 注意不能是run()
    }
}
