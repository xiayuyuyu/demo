package concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/22 上午1:00
 */
public class CachedThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 500; i++) {
            executorService.submit(new MyTask());
        }

        executorService.shutdown();

    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("current thread is running :" + Thread.currentThread());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
        }
    }
}
