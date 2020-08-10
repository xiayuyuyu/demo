package annotation;

/**
 * @author xiayu
 * @version 1.0
 * @className CostTimeTest
 * @description
 * @date 2019/9/26 12:46
 */
public class CostTimeTest {

    private static A a;

    static {
        CostTimeProxy aProxy = new CostTimeProxy();
        a = (A) aProxy.getProxy(A.class);
    }

    public static void main(String[] args) {
        a.doSomeThing();
        a.doSomeThing2();
    }

}
