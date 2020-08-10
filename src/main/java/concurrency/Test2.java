package concurrency;

import java.util.Date;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/8/4 14:13
 */
public class Test2 {

    private static boolean active = true;

    public void run() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (active) {
                    dowork();
                }
            }
        });
        thread.start();

    }

    private void stop() {
        active = false;
    }
    private void dowork() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" dowork:"+new Date().toString());

    }

    public static void main(String[] args) throws InterruptedException {
        Test2 test2 = new Test2();
        test2.run();
        test2.run();
        test2.run();
        test2.run();
        test2.run();
        test2.run();
        Thread.sleep(1000);
        test2.stop();
    }
}
