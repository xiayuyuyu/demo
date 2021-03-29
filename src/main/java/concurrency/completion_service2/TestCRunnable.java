package concurrency.completion_service2;

import java.util.concurrent.CountDownLatch;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 10:28
 */
public class TestCRunnable implements Runnable {


    Result result;

    CountDownLatch countDownLatch;

    public TestCRunnable(Result result, CountDownLatch countDownLatch) {
        this.result = result;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始执行");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("C执行完成");
        result.setC(111111111);
        countDownLatch.countDown();
    }
}
