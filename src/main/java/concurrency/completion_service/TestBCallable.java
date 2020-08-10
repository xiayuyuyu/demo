package concurrency.completion_service;

import java.util.concurrent.Callable;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 10:28
 */
public class TestBCallable implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(500);
        System.out.println("B执行完成");
        return 11111111;
    }
}
