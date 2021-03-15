package concurrency;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/3/12
 */
public class TestDaemon {
    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i++) {
                    System.out.println(this.getName()+"我在执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println(this.getName()+"执行结束了");
            }
        };
        //加了这行,thread 里内容不会执行完,因为主线程和thread线程都为daemon线程,没有用户线程了之后,daemon线程会自动退出,虚拟机关闭
        //只要有用户线程一直在运行,jvm就一直不会退出
        thread.setDaemon(true);
        thread.start();
        System.out.println(Thread.currentThread().getName()+"执行结束了");


    }

}
