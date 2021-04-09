package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/9
 */
public class ConditionDemo {



    public static void main(String[] args) throws InterruptedException {
         final Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        new Thread() {
            @Override
            public void run() {
                lock.lock();
                System.out.println("线程一加锁");
                try {
                    System.out.println("线程一执行await挂起");
                    condition.await();
                    System.out.println("线程一恢复执行");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程一执行业务代码");
                lock.unlock();
                System.out.println("线程一解锁");

            }
        }.start();

        Thread.sleep(1000);

        new Thread(){
            @Override
            public void run() {
                System.out.println("===线程二尝试获取锁");
                lock.lock();
                System.out.println("===线程二获取到锁");
                System.out.println("===线程二执行signal");
                condition.signal();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===signal执行结束");
                lock.unlock();
                System.out.println("===线程二unlock");

            }
        }.start();
        System.out.println("程序执行结束");

    }
    //线程二解锁执行完,解锁之后,线程一才能继续运行

}
