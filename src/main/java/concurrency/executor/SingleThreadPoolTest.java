package concurrency.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/21
 */
public class SingleThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 20; i++) {
            executorService.submit(new MyTask());
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
