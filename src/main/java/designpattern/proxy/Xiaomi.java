package designpattern.proxy;

/**
 * @author xiayu001
 * @version 1.0
 * @className
 * @description
 * @date 2019-06-05 11:46
 */
public class Xiaomi implements Phone {

    @Override
    public void sendSMS(String sms) {
        System.out.println("发送短信成功:"+sms);
    }

    @Override
    public void sendWeChat(String weChatMessage) {
        System.out.println("发送微信成功:"+weChatMessage);
    }
}
