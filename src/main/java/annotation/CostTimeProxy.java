package annotation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import sun.rmi.runtime.Log;

import java.lang.reflect.Method;

/**
 * @author xiayu
 * @version 1.0
 * @className CostTimeProxy
 * @description
 * @date 2019/9/26 11:51
 */
public class CostTimeProxy implements MethodInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(CostTimeProxy.class);

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz) {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        if (!method.isAnnotationPresent(CostTime.class)) {
            return methodProxy.invokeSuper(o, args);
        }
        //获取注解信息
        CostTime costTime = method.getAnnotation(CostTime.class);
        long limitTime = costTime.value();
        //记录方法执行前后的时间,取差
        long startTime = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o, args);
        long diffTime = System.currentTimeMillis() - startTime;
        if (limitTime <= 0 || diffTime >= limitTime) {
            String methodName = method.getName();
            LOGGER.warn("通过注解监控方法 {} 的执行耗时为: {}", methodName, diffTime);
        }
        return result;
    }
}
