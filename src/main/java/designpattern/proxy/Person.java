package designpattern.proxy;

/**
 * @author xiayu
 * @version 1.0
 * @className Person
 * @description
 * @date 2019/9/16 11:49
 */
public class Person {

    public String say(String str) {
        System.out.println("Person say: "+ str);
        return "Person say:" + str;
    }

}
