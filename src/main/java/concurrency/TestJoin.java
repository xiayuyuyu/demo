package concurrency;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/15
 */
public class TestJoin {
    
    /**
     * 主线程里调用childThread.join() 的时候
     * 底层调用的是synchronized方法，持有了子线程的锁，
     * 然后看到 thread 的public final synchronized void join(long millis)
     * wait(0)陷入永久等待,直接让出时间片
     * 等到childThread执行完之后,会调用jvm底层的notify_all(thread) 才会被唤醒,
     * 这时候子线程的isAlive()肯定是false了,就直接跳出while循环,
     * 此时synchronized join方法就执行结束,主线程释放持有的子线程锁
     *
     * //一个c++函数：
     * void JavaThread::exit(bool destroy_vm, ExitType exit_type) ；
     * ensure_join(this);
     *
     * //翻译成中文叫 确保_join(这个)；代码如下：
     *
     * static void ensure_join(JavaThread* thread) {
     *   Handle threadObj(thread, thread->threadObj());
     *
     *   ObjectLocker lock(threadObj, thread);
     *
     *   thread->clear_pending_exception();
     *
     *   java_lang_Thread::set_thread_status(threadObj(), java_lang_Thread::TERMINATED);
     *
     *   java_lang_Thread::set_thread(threadObj(), NULL);
     *
     * //thread就是当前线程main线程啊。
     *   lock.notify_all(thread);
     *
     *   thread->clear_pending_exception();
     *
     *
     * @param args
     * @throws InterruptedException
     */
    
    
    
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

