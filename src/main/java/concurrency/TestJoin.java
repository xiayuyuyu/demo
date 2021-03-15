package concurrency;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/15
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread1();
        Thread t2 = new Thread2();
        Thread t3 = new Thread3();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        System.out.println(Thread.currentThread().getName()+"执行结束");
    }


}

class Thread1 extends Thread {

    @Override
    public void run() {
        System.out.println("线程1在执行");
    }
}


class Thread2 extends Thread {

    @Override
    public void run() {
        System.out.println("线程2在执行");
    }
}


class Thread3 extends Thread {

    @Override
    public void run() {
        System.out.println("线程3在执行");
    }
}

