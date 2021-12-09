package leetcode.multithreading.no1115;

import leetcode.multithreading.no1115.FooBar;

/**
 * @description:
 * @author: HeZhe
 * @date: 2020-08-10 10:33
 **/
public class PrintBar implements Runnable {
    private FooBar fb;

    public PrintBar(FooBar fb) {
        this.fb = fb;
    }

    @Override
    // 同上
    public void run() {
        try {
            fb.bar(() -> System.out.print("Bar"));
            // 同上
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
