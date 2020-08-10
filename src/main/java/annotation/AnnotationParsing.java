package annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author xiayu
 * @version 1.0
 * @className AnnotationParsing
 * @description
 * @date 2019/9/26 11:25
 */

public class AnnotationParsing {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnnotationParsing.class);

    public static void main(String[] args) {
        try {

            Method[] methods = AnnotationParsing.class.getClassLoader()
                    .loadClass("annotation.AnnotationExample").getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(annotation.MethodInfo.class)) {
                    for (Annotation declaredAnnotation : method.getDeclaredAnnotations()) {
                        System.out.println("Annotation in Method " + method + ":" + declaredAnnotation);
                    }
                    MethodInfo annotation = method.getAnnotation(MethodInfo.class);
                    if (annotation.revision() == 1) {
                        System.out.println("Method with revision no 1 =" + method);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("解析Java注解出错!", e);
        }
    }
}
