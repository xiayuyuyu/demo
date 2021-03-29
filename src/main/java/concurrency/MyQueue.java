package concurrency;

import java.util.LinkedList;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/26
 */
public class MyQueue {

    private final static int MAX_SIZE = 100;

    private LinkedList<String> queue = new LinkedList<>();

    public synchronized void offer(String element) {
        try {
            if (queue.size() == MAX_SIZE) {
                wait();//让线程进入等待状态,释放调锁
            }
            queue.addLast(element);
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized String take() {
        //别的线程就可以在队列里去取
        String element = null;
        try {
            if (queue.size() == 0) {
                wait();//将锁释放掉,等待放入
            }
            element = queue.pollFirst();
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return element;
    }
}
