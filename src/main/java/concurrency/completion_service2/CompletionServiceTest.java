package concurrency.completion_service2;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 10:29
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        StopWatch stopWatch = new StopWatch();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(0);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(10);
        executor.setThreadNamePrefix("mutiQueryExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        CompletionService<Result> completionService = new ExecutorCompletionService<Result>(executor);
        Result result = new Result();
        CountDownLatch countDownLatch = new CountDownLatch(3);
        List<Future<Result>> futures = new ArrayList<>();
        stopWatch.start("main");
        futures.add(completionService.submit(new TestARunnable(result, countDownLatch), result));
        futures.add(completionService.submit(new TestBRunnable(result, countDownLatch), result));
        futures.add(completionService.submit(new TestCRunnable(result, countDownLatch), result));

        Object o = completionService.take().get();


        countDownLatch.await();


        for (int i = 0; i < futures.size(); i++) {
            System.out.println(futures.get(i).get());
        }
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
        System.out.println(result);
        executor.shutdown();
    }
}
