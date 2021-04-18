package concurrency;

import org.omg.CORBA.TCKind;

import java.util.concurrent.Semaphore;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/18
 */
public class SemaphoreDemo {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("线程一执行完毕");
                    semaphore.release(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("线程二执行一个计算任务");
                    semaphore.release(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        semaphore.acquire(1);
        System.out.println("等待一个线程完成任务即可");

    }

}
