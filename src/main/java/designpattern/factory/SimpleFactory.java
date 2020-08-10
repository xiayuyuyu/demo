package designpattern.factory;

import designpattern.factory.bean.Apple;
import designpattern.factory.bean.Strawberry;

/**
 * @author xiayu001
 * @version 1.0
 * @className SimpleFactory
 * @description
 * @date 2019/9/2 20:55
 */
public class SimpleFactory {
    public static final String APPLE_TYPE = "1";

    public static final String STRAWBERRY_TYPE = "2";

    public static Fruit getFruit(String type) {
        if (APPLE_TYPE.equals(type)) {
            return new Apple();
        } else if (STRAWBERRY_TYPE.equals(type)) {
            return new Strawberry();
        }
        return null;
    }


}
