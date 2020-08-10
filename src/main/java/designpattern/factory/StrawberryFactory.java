package designpattern.factory;

import designpattern.factory.bean.Strawberry;

/**
 * @author xiayu001
 * @version 1.0
 * @className Strawberry
 * @description
 * @date 2019/9/2 21:24
 */
public class StrawberryFactory extends FruitFactory {
    @Override
    public Fruit getFruit() {
        return new Strawberry();
    }
}
