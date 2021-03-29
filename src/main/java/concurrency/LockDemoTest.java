package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiayu001
 * @version 1.0
 * @className LockDemoTest
 * @description
 * @date 2019-07-12 10:51
 */
public class LockDemoTest implements Runnable{

    private LockDemo lockDemo;

    public LockDemoTest(LockDemo lockDemo) {
        this.lockDemo = lockDemo;
    }

    @Override
    public void run() {
        lockDemo.incr();
    }

    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        Thread t1 = new Thread(new LockDemoTest(demo));
        Thread t2 = new Thread(new LockDemoTest(demo));
        t1.start();
        t2.start();
//        ExecutorService service = Executors.newFixedThreadPool(5);
//        for (int i = 0; i < 10; i++) {
//            service.execute(new LockDemoTest(demo));
//        }
    }

}
