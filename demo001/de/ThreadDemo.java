package demo001.de;

import java.util.concurrent.Executors;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-05-20 11:28
 **/
public class ThreadDemo {
    public static void main(String[] args) {
        //单个线程
        Executors.newSingleThreadExecutor();
        //缓存线程
        Executors.newCachedThreadPool();
        //固定线程
        Executors.newFixedThreadPool(2);
        //定时线程
        Executors.newScheduledThreadPool(3);
    }
}
