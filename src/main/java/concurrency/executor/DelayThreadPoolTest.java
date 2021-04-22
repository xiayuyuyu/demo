package concurrency.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

import static java.util.concurrent.TimeUnit.SECONDS;


/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/22 上午1:00
 */
public class DelayThreadPoolTest {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        System.out.println("current thread is running :" + Thread.currentThread() + ",now:" + System.currentTimeMillis() / 1000);

        scheduledExecutorService.schedule(new MyTask(), 5L, SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new MyTask(), 1, 5, SECONDS);


        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("每隔五秒执行一次");
            }
        }, 1, 5, SECONDS);
//        scheduledExecutorService.shutdown();


    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("current thread is running :" + Thread.currentThread() + ",now:" + System.currentTimeMillis() / 1000);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
