package concurrency.join;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/5/26
 */
public class TestA {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(System.currentTimeMillis()/1000);
        SerivceA a = new SerivceA();
        SerivceA b = new SerivceA();
        a.deal();
        b.deal();
        System.out.println(System.currentTimeMillis()/1000);
    }
}
