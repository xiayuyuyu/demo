package concurrency;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/16
 */
public class AtomicSimpleDemo {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final AtomicSimpleDemo demo = new AtomicSimpleDemo();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                @Override
                public void run() {
                    for (int j = 0; j < 1000; j++) {
                        demo.increase();
                    }
                }

                ;
            }.start();
        }
        Thread.sleep(5000);

        System.out.println(demo.inc);

    }
}