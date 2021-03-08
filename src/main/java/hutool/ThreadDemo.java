package hutool;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/2/25 18:14
 */
public class ThreadDemo {

    public static void main(String[] args) {
        DemoThread thread = new DemoThread();
        thread.start();
    }





}

class DemoThread extends Thread{

    @Override
    public void run() {
        System.out.println("启动了"+Thread.currentThread().getName());
        super.run();
    }
}