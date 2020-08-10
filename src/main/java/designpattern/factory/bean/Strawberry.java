package designpattern.factory.bean;

import designpattern.factory.Fruit;

/**
 * @author xiayu001
 * @version 1.0
 * @className Strawberry
 * @description
 * @date 2019/9/2 20:57
 */
public class Strawberry implements Fruit {


    @Override
    public String draw() {
        System.out.println("我是个草莓啊~");
        return "我是个草莓呀~";
    }
}
