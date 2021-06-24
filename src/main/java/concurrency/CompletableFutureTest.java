package concurrency;

import java.util.concurrent.CompletableFuture;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/6/18
 */
public class CompletableFutureTest {
    
    
    public static void main(String[] args) {
        String result = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello");
            return "hello";
        }).thenApply(r -> {
            System.out.println("world");
            return r + " world";
        }).join();
        System.out.println(result);
    }
    
}
