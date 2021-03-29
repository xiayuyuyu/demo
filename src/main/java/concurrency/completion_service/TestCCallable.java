package concurrency.completion_service;

import java.util.concurrent.Callable;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 10:28
 */
public class TestCCallable implements Callable {


    @Override
    public Object call() throws Exception {
        Thread.sleep(6000);
        System.out.println("C执行完成");
        return "CCCCCCCCCCCCC";
    }
}
