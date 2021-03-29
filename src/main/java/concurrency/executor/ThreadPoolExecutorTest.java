package concurrency.executor;

import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/11
 */
public class ThreadPoolExecutorTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue workQueue = new ArrayBlockingQueue(10);
        TimeUnit unit = TimeUnit.MILLISECONDS;
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 1000, unit, workQueue);
        System.out.println("当前线程"+Thread.currentThread());
        for (int i = 0; i < 10; i++) {
            executor.submit(new TestCallable());
        }
        executor.shutdown();
        Thread.sleep(12 * 1000);

        for (int i = 0; i < 10; i++) {
            System.out.println("isShutdown:" + executor.isShutdown());
            System.out.println("isTerminated:" + executor.isTerminated());
            System.out.println("isTerminating:" + executor.isTerminating());
        }


    }
}

class TestCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        Uninterruptibles.sleepUninterruptibly(1, TimeUnit.SECONDS);
        System.out.println("当前线程"+Thread.currentThread()+"开始执行callAble");
        return "===========";
    }
}