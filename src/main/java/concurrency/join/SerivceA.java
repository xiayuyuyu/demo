package concurrency.join;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/5/26
 */
public class SerivceA {

    synchronized String deal() throws InterruptedException {
        System.out.println("deal执行开始");
        Thread.sleep(5000);
        System.out.println("deal执行完毕");
        return "SUCCESS";
    }
}
