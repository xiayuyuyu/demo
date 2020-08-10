package annotation;

import java.lang.annotation.*;

/**
 * @author xiayu
 * @version 1.0
 * @className MethodInfo
 * @description TODO
 * @date 2019/9/26 11:18
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface MethodInfo {
    String author() default "leon";

    String date();

    int revision() default 1;

    String comments();
}
