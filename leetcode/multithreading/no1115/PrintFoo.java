package leetcode.multithreading.no1115;

import leetcode.multithreading.no1115.FooBar;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-08-10 10:32
 **/
public class PrintFoo implements Runnable {
    private FooBar fb;

    public PrintFoo(FooBar fb) {
        this.fb = fb;
    }

    @Override
    // Runnable 必须override run()
    public void run() {
        try {
            fb.foo(() -> System.out.print("Foo"));
            // lambda表达式实现override run() 打印"Foo"
            // due to 题目要求foo方法要传入一个Runnable printFoo
            // 而且printFoo.run()是打印"Foo"
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
