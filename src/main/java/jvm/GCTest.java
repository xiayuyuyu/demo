package jvm;

/**
 * @author xiayu001
 * @version 1.0
 * @className GCTest
 * @description
 * @date 2019-07-05 19:56
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1, allocation2,allocation3,allocation4,allocation5;
        allocation1 = new byte[61000*1024];
        allocation2 = new byte[1000*1024];
        allocation3 = new byte[1000*1024];
        allocation4 = new byte[1000*1024];
        allocation5 = new byte[1000*1024];
    }
}
