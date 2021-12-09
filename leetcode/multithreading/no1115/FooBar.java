package leetcode.multithreading.no1115;

import java.util.concurrent.Semaphore;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-08-10 10:20
 **/
public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    Semaphore foo = new Semaphore(1);//foo方法可以访问的共享资源为1
    Semaphore bar = new Semaphore(0);//bar方法可以访问的共享资源为0

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            foo.acquire();//foo方法获得信号量，并将信号量内部的计数器减1，计数器值为0后,线程进入休眠。
            printFoo.run();
            bar.release();//bar方法释放信号量，并将信号量内部的计数器加1
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            bar.acquire();//bar方法获得信号量，并将信号量内部的计数器减1，计数器值为0后,线程进入休眠。
            printBar.run();
            foo.release();//foo方法释放信号量，并将信号量内部的计数器加1
        }
    }
}
