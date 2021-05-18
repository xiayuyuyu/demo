package collection;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/23
 */
public class ConcurrentLinkedQueueTest {

    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
        for (int i = 1; i <= 10; i++) {
            queue.offer("第" + i);
            System.out.println("入列" + i);
        }

//        for (int i = 0; i < 200; i++) {
//            new Thread(){
//                @Override
//                public void run() {
//                    System.out.println("入列");
//                    queue.offer(System.currentTimeMillis()+"");
//                }
//            }.start();
//        }

    }


}
