package annotation;

import java.lang.annotation.*;

/**
 * @author xiayu
 * @version 1.0
 * @className CostTime
 * @description TODO
 * @date 2019/9/26 11:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface CostTime {
    /**
     * @param
     * @return long
     */
    long value() default 0;
}
