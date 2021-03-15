package guava;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/10
 */

public class TestShutDown {

    static void asynExecuteOne() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            public void run() {
                System.out.println("--async execute one ---");
            }
        });
        executor.shutdown();
    }

    static void asynExecuteTwo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            public void run() {
                System.out.println("--async execute two ---");
            }
        });
        executor.shutdown();
        executor.submit(() -> {
            System.out.println("11111111111");
        });
    }


    public static void main(String[] args) {
        //(1)同步执行
        System.out.println("---sync execute---");
        //(2)异步执行操作one
        asynExecuteOne();
        //(3)异步执行操作two
        asynExecuteTwo();
        //(4)执行完毕
        System.out.println("---execute over---");
    }
}

