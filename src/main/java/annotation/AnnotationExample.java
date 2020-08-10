package annotation;

/**
 * @author xiayu
 * @version 1.0
 * @className AnnotationExample
 * @description
 * @date 2019/9/26 11:42
 */
public class AnnotationExample {

    @MethodInfo(date = "20190926",comments = "方法 sayHello")
    public void sayHello() {
        System.out.println("hello!");
    }
}
