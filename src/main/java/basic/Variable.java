package basic;

import javax.naming.Name;
import javax.sound.midi.Soundbank;

/**
 * @author xiayu001
 * @version 1.0
 * @className Variable
 * @description
 * @date 2019-06-10 15:03
 */
public class Variable {

    private String name;
    private static String id = "10000";

    private static final String url = "www.baidu.com";

    public void doNothing() {
//        局部变量不能用访问修饰符修饰
//        public String text;
//        局部变量不能被static修饰
//        static String text;
//        局部变量可以被final修饰
        final String text;
//        成员变量创建但未初始化时,会默认赋值,局部变量则不会赋值,会直接报错
//        System.out.println(text);
        System.out.println(name);
    }


    public static void doSomething() {
//        静态方法中只能引用静态变量(即类变量,成员变量,静态方法
//        doNothing();
//        System.out.println(name);
        System.out.println(url);
        System.out.println(id);
    }

    public static void main(String[] args) {
//        System.out.println(name);
        System.out.println(id);
        System.out.println(url);
        doSomething();
    }

}
