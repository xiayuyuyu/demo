package concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/13
 */
public class LockDemo2 {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock();
        new Thread(){

            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("线程一获取锁");
                    Thread.sleep(70*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                  lock.unlock();
                    System.out.println("线程一释放锁");
                }

            }
        }.start();

        new Thread(){

            @Override
            public void run() {
                try {
                    lock.lock();
                    System.out.println("线程二获取锁");
                    Thread.sleep(70*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    System.out.println("线程二释放锁");
                }

            }
        }.start();

        Thread.sleep(100*1000);
    }
}
