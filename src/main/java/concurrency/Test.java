package concurrency;

import basic.CatalogResult;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/28 21:30
 */
public class Test {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(0);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(100);
        executor.setKeepAliveSeconds(10);
        executor.setThreadNamePrefix("mutiQueryExecutor-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();

        CountDownLatch countDownLatch = new CountDownLatch(3);
        CatalogResult result = new CatalogResult();
        CompletionService<CatalogResult> objectExecutorCompletionService = new ExecutorCompletionService<>(executor);
        CallableDemo callableDemo = new CallableDemo(countDownLatch, result);

        objectExecutorCompletionService.submit(callableDemo);

//        countDownLatch.await(50,TimeUnit.SECONDS);
        System.out.println(objectExecutorCompletionService.take().get());

        System.out.println(System.currentTimeMillis() - start);



    }
}
