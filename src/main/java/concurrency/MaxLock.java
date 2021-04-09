package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/9
 */
public class MaxLock {


    public static void main(String[] args) {
        final ReadWriteLock rwlock = new ReentrantReadWriteLock();
        final Lock rlock = rwlock.readLock();

        for (int i = 0; i < 65535; i++) {
            rlock.lock();

        }
        for (int i = 0; i < 65535; i++) {
            rlock.unlock();

        }
    }
}
