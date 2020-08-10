package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author xiayu001
 * @version 1.0
 * @className LockDemo
 * @description
 * @date 2019-07-12 10:21
 */
public class LockDemo {

    private volatile int count;

    private Lock lock = new ReentrantLock();

    public void incr() {
        lock.lock();
        try {
            count++;
            System.out.println("thread"+Thread.currentThread()+";"+"count:"+getCount());
        }finally {
            lock.unlock();
        }
    }

    public int getCount(){
        return count;
    }

}
