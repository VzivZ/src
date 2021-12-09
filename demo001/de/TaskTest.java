package demo001.de;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @description:
 * @author: VzivZ
 * @date: 2020-06-12 15:05
 **/
public class TaskTest {
    public static void main(String[] args) {
        Timer timer = new Timer();
        // 三秒后开始执行，每隔一秒执行一次
        timer.schedule(new Task(timer), 3 * 1000);
    }
}

class Task extends TimerTask {
    private Timer timer;

    Task(Timer timer) {
        this.timer = timer;
    }

//    private int i = 1;

    @Override
    public void run() {
        System.out.println("****** timer start ******");
        //当执行到第5秒，程序结束
//        if (i++ == 5) {
//            this.timer.cancel();
            System.out.println("#### timer end ####");
//        }
    }
}
