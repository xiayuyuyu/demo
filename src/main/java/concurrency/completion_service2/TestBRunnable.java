package concurrency.completion_service2;

import java.util.concurrent.CountDownLatch;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 10:28
 */
public class TestBRunnable implements Runnable {

    Result result;

    CountDownLatch countDownLatch;

    public TestBRunnable(Result result, CountDownLatch countDownLatch) {
        this.result = result;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("B执行完成");
        result.setB(true);
        countDownLatch.countDown();
    }
}
