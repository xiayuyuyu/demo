package concurrency;

import java.util.concurrent.*;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/25 16:36
 */
public class CountDownLatchDemo {


    static class CallableA implements Callable<String> {

        private CountDownLatch countDownLatch;

        public CallableA(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public String call() throws Exception {
            System.out.println("开始烧水...");
            Thread.sleep(5000);
            System.out.println("烧水烧完咯...");
            countDownLatch.countDown();
            return "烧水烧完咯,耗时5000ms";
        }
    }

    static class CallableB implements Callable<String> {
        private CountDownLatch countDownLatch;

        public CallableB(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public String call() throws Exception {
            System.out.println("开始煮玉米...");
            Thread.sleep(10000);
            System.out.println("煮玉米煮好咯...");
            countDownLatch.countDown();
            return "煮玉米煮好咯,耗时10000ms";
        }
    }

    static class CallableC implements Callable<String> {
        private CountDownLatch countDownLatch;

        public CallableC(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public String call() throws Exception {
            System.out.println("开始穿鞋...");
            Thread.sleep(2000);
            countDownLatch.countDown();
            System.out.println("穿鞋穿好咯...");
            return "穿鞋穿好咯,耗时2000ms";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Long start = System.currentTimeMillis();
        System.out.println("准备出门");
        CountDownLatch countDownLatch = new CountDownLatch(3);

        ExecutorService executor = Executors.newCachedThreadPool();

        Future<String> futureA = executor.submit(new CallableA(countDownLatch));
        Future<String> futureB = executor.submit(new CallableB(countDownLatch));
        Future<String> futureC = executor.submit(new CallableC(countDownLatch));

        countDownLatch.await(50, TimeUnit.SECONDS);
        System.out.println("全干完了,揣兜出门,一共耗时:" + (System.currentTimeMillis() - start));
        executor.shutdown();
    }


}

