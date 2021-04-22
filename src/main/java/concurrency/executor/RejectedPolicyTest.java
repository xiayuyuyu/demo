package concurrency.executor;

import java.util.concurrent.*;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/22 下午10:51
 */
public class RejectedPolicyTest {
    public static void main(String[] args) {
//        ThreadFactory threadFactory = new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//
//                Thread thread = new Thread(r);
//                thread.setName("MyThread");
//                return thread;
//            }
//        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 20, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    String msg = String.format("Thread pool is EXHAUSTED!" +
                                    " Thread Name: %s, Pool Size: %d (active: %d, core: %d, max: %d, largest: %d), Task: %d (completed: %d)," +
                                    " Executor status:(isShutdown:%s, isTerminated:%s, isTerminating:%s), in !",
                            Thread.currentThread().getName(), executor.getPoolSize(), executor.getActiveCount(), executor.getCorePoolSize(), executor.getMaximumPoolSize(), executor.getLargestPoolSize(),
                            executor.getTaskCount(), executor.getCompletedTaskCount(), executor.isShutdown(), executor.isTerminated(), executor.isTerminating()
                    );
                    System.out.println(msg);
                    executor.getQueue().offer(r, 60, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for (int i = 0; i < 1000; i++) {
            int finalI = i;
            threadPoolExecutor.submit(
                    () -> {
                        System.out.println("当前线程:" + Thread.currentThread().getName() + ",第" + (finalI+1) + "个任务正在执行");
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
            );
        }


    }
}