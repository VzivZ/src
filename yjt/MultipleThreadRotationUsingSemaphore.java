package yjt;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 * Created by SunYanhui on 2017/12/4.
 */
public class MultipleThreadRotationUsingSemaphore {
    public static void main(String[] args) {
        PrintABCUsingSemaphore printABC = new PrintABCUsingSemaphore();
        new Thread(printABC::printA).start();
        new Thread(printABC::printB).start();
        new Thread(printABC::printC).start();
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "1");
        map.forEach((k, v) -> {
            System.out.println(k + "-" + v);
        });
    }
}

class PrintABCUsingSemaphore {
    private Semaphore semaphoreA = new Semaphore(1);
    private Semaphore semaphoreB = new Semaphore(0);
    private Semaphore semaphoreC = new Semaphore(0);
    //private int attempts = 0;


    public void printA() {
        print("A", semaphoreA, semaphoreB);
    }

    public void printB() {
        print("B", semaphoreB, semaphoreC);
    }

    public void printC() {
        print("C", semaphoreC, semaphoreA);
    }

    private void print(String name, Semaphore currentSemaphore, Semaphore nextSemaphore) {
        for (int i = 0; i < 3; ) {
            try {
                currentSemaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " print " + name);
                i++;
                nextSemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}