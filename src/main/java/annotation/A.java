package annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author xiayu
 * @version 1.0
 * @className Test
 * @description
 * @date 2019/9/26 12:39
 */
public class A {
    private static final Logger LOGGER = LoggerFactory.getLogger(A.class);

    @CostTime
    public void doSomeThing() {
        LOGGER.info("执行Test类中的doSomething方法!");
    }

    @CostTime(50)
    public void doSomeThing2() {
        LOGGER.info("执行Test类中的doSomething2方法!");
    }

}
