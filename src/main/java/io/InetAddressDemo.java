package io;

import com.sun.tools.javac.util.List;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/8/10 18:04
 */
public class InetAddressDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        address = InetAddress.getByName("www.zhihu.com");
        System.out.println(address);
    }
}
