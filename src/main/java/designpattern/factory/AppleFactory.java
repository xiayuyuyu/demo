package designpattern.factory;

import designpattern.factory.bean.Apple;

/**
 * @author xiayu001
 * @version 1.0
 * @className AppleFactory
 * @description
 * @date 2019/9/2 21:20
 */
public class AppleFactory extends FruitFactory {

    @Override
    public Fruit getFruit() {
        return new Apple();
    }




}
