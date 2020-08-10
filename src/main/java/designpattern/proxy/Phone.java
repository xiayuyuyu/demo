package designpattern.proxy;

/**
 * @author xiayu001
 * @version 1.0
 * @className Phone
 * @description
 * @date 2019-06-05 11:45
 */
public interface Phone {
    void sendSMS(String sms);

    void sendWeChat(String weChatMessage);
}
