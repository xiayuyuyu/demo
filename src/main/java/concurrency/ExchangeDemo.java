package concurrency;

import java.util.concurrent.Exchanger;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/4/18
 */
public class ExchangeDemo {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread() {
            @Override
            public void run() {
                try {
                    String data = exchanger.exchange("线程一的数据");
                    System.out.println("线程一获取到线程二交换过来的数据:"+data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    String data = exchanger.exchange("线程二的数据");
                    System.out.println("线程二获取到线程一交换过来的数据:"+data);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
