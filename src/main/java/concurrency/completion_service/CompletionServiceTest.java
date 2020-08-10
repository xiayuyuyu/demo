package concurrency.completion_service;

import java.util.concurrent.*;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 10:29
 */
public class CompletionServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CompletionService<Object> completionService = new ExecutorCompletionService<Object>(service);
        long start = System.currentTimeMillis();
        completionService.submit(new TestACallable());
        completionService.submit(new TestBCallable());
        completionService.submit(new TestCCallable());
        System.out.println("after submit");
        for (int i = 0; i < 3; i++) {
            Object s = completionService.take().get();
            if (s instanceof String) {
                System.out.println("" + s.getClass().getName());
            } else if (s instanceof Integer) {
                System.out.println("" + s.getClass().getName());
            } else if (s instanceof Boolean) {
                System.out.println("" + s.getClass().getName());
            }
            System.out.println("result: " + s); // 这个方法是阻塞的
        }
        System.out.println("after get");
        System.out.println("耗时一共" + (System.currentTimeMillis() - start));
        service.shutdown();
    }
}
