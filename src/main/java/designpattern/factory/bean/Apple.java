package designpattern.factory.bean;

import designpattern.factory.Fruit;

/**
 * @author xiayu001
 * @version 1.0
 * @className Apple
 * @description
 * @date 2019/9/2 20:56
 */
public class Apple implements Fruit {
    @Override
    public String draw() {
        System.out.println("我是个苹果啊~");
        return "我是个苹果啊~";
    }
}
