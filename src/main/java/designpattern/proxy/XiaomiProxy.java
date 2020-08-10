package designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author xiayu001
 * @version 1.0
 * @className XiaomiProxy
 * @description
 * @date 2019-06-05 11:51
 */
public class XiaomiProxy {

    private Xiaomi xiaomi = new Xiaomi();

    public Phone getPrxoy() {
        return (Phone) Proxy.newProxyInstance(XiaomiProxy.class.getClassLoader(), xiaomi.getClass().getInterfaces(),
                new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sendSMS")) {
                    System.out.println("短信一毛钱一条哈");
                    method.invoke(xiaomi, args);
                }
                if (method.getName().equals("sendWeChat")) {
                    System.out.println("发微信只要流量");
                    method.invoke(xiaomi, args);
                }
                return null;
            }
        });
    }

}
