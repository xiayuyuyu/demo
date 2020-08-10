package concurrency.completion_service;

import java.util.concurrent.Callable;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 10:28
 */
public class TestACallable implements Callable {

    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
        System.out.println("A执行完成");
        return true;
    }
}
