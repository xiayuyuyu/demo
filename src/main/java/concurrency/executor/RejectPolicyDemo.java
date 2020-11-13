package concurrency.executor;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StopWatch;

import java.sql.SQLOutput;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/11/13 17:02
 */
public class RejectPolicyDemo {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(10);
        executor.setKeepAliveSeconds(10);
        executor.setThreadNamePrefix("syncDataCpCheckExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        for (int i = 0; i < 100; i++) {
            executor.execute(new SingleRunnable(i));
        }
        stopWatch.stop();
        System.out.println("执行完毕共耗时"+stopWatch.prettyPrint());
    }

    static class SingleRunnable implements Runnable {

        private int i;

        public SingleRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName()+"正在执行"+this.i+"任务");
                Thread.sleep(500);
                System.out.println(Thread.currentThread().getName()+"执行"+this.i+"任务完毕========");
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }


}
