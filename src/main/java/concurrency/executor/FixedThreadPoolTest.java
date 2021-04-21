package concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/22 上午1:00
 */
public class FixedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 20; i++) {
            executorService.submit(new SingleThreadPoolTest.MyTask());
        }

        executorService.shutdown();

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("current thread is running :" + Thread.currentThread());
        }
    }
}
