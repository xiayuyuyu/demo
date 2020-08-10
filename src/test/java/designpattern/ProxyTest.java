package designpattern;

import designpattern.proxy.*;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * @author xiayu001
 * @version 1.0
 * @className ProxyTest
 * @description
 * @date 2019-06-05 11:31
 */
public class ProxyTest {

    @Test
    public void proxy_test() {
        Company target = new CompanyImpl();
        CompanyProxy proxy = new CompanyProxy(target);
        proxy.fire();
    }

    @Test
    public void jdk_proxy_test() {
        XiaomiProxy xiaomiProxy = new XiaomiProxy();
        Phone prxoy = xiaomiProxy.getPrxoy();
        prxoy.sendSMS("给10086发短信说我想喝奶茶了");
        prxoy.sendWeChat("给女朋友发短信说午饭吃什么");
    }

    @Test
    public void cglib_proxy_test() {
        Person person = (Person) new CglibProxy().getInstance(new Person());
        person.say("我滴老嘎");
        person.say("就住在这个屯");
    }
}
