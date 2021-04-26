package concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/26 上午7:32
 */
public class ReadWriteLockDemo {

    static Map<String, String> map = new HashMap<>();


    private ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private ReadLock readLock = readWriteLock.readLock();

    private WriteLock writeLock = readWriteLock.writeLock();

    static {
        map.put("张三", "100");
        map.put("李四", "90");
        map.put("王五", "80");

    }

    private void readLock() {
        this.readLock.lock();
    }

    private void readUnlock() {
        this.readLock.unlock();
    }

    private void writeLock() {
        this.writeLock.lock();
    }

    private void writeUnlock() {
        this.writeLock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        ReadWriteLockDemo demo = new ReadWriteLockDemo();

        //演示读写锁互斥
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试获取读锁");
            demo.readLock();
            demo.readLock();
            try {
                System.out.println(Thread.currentThread().getName() + "在执行,当前时间:" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(1000*5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("读线程获取结果:" + map.get("张三"));
            } finally {
                demo.readUnlock();
                demo.readUnlock();
            }

        });


        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "尝试获取写锁");
            demo.writeLock();
            try {
                System.out.println(Thread.currentThread().getName() + "在执行,当前时间:" + System.currentTimeMillis() / 1000);
                try {
                    Thread.sleep(1000*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map.put("麻子", "99");
                System.out.println("写线程插入数据成功");
            } finally {
                demo.writeUnlock();

            }

        });
        //读写互斥,先获取到读锁的线程会阻塞后续获取写锁
        //先获取到写锁的线程会阻塞所有尝试获取读或写锁的线程(对调thread1.start() 和thread2.start()即可实现)
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();
        System.out.println("执行完毕");
        System.out.println(map);
    }


}
