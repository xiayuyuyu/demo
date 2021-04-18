package concurrency;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/16
 */
public class VisibilityDemo {
    static int i = 0;

    public static void main(String[] args) {


        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10000; j++) {
                    System.out.println("线程1读取i>>>: " + i);
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 0; j < 10000; j++) {

                    System.out.println("线程2读取i : " + i);
                }
            }
        }.start();

        for (int j = 0; j < 10000; j++) {
            System.out.println("主线程读取i===== : " + (++i));
        }
    }
}
