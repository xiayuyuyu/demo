package guava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;

import java.util.concurrent.TimeUnit;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/10
 */
public class ExecutorServiceImpl extends AbstractExecutionThreadService {


    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            // do our work
            try {
                Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
                System.out.println("do our work.....");
            } catch (Exception e) {
                //处理异常，这里如果抛出异常，会使服务状态变为failed同时导致任务终止。
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorServiceImpl service = new ExecutorServiceImpl();

        service.addListener(new Listener() {
            @Override
            public void starting() {
                System.out.println("服务开始启动.....");
            }

            @Override
            public void running() {
                System.out.println("服务开始运行");
                ;
            }

            @Override
            public void stopping(State from) {
                System.out.println("服务关闭中");
            }

            @Override
            public void terminated(State from) {
                System.out.println("服务终止");
            }

            @Override
            public void failed(State from, Throwable failure) {
                System.out.println("失败，cause：" + failure.getCause());
            }
        }, MoreExecutors.directExecutor());
        System.out.println("没调用startAsync:" + service.state());
        service.startAsync().awaitRunning();
        System.out.println("服务状态为:" + service.state());

        Thread.sleep(10 * 1000);

        service.stopAsync().awaitTerminated();

        System.out.println("服务状态为:" + service.state());
    }

}

