package concurrency;


/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/26
 */
public class VolatileTest2 {
    public static int count = 0;


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    increment();
                }
            }
        };
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    increment();
                }
            }
        };
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("最终"+VolatileTest2.count);

    }

    static synchronized void increment() {
        VolatileTest2.count++;
        System.out.println(Thread.currentThread().getName()+":"+VolatileTest2.count);
    }


}
