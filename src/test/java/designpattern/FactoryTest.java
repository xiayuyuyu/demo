package designpattern;

import designpattern.factory.*;
import org.junit.Test;

/**
 * @author xiayu001
 * @version 1.0
 * @className FactoryTest
 * @description
 * @date 2019/9/2 21:06
 */
public class FactoryTest {
    @Test
    public void simple_test() {

        Fruit fruit = SimpleFactory.getFruit(SimpleFactory.APPLE_TYPE);
        fruit.draw();
    }

    @Test
    public void abstractFactory_test() {
        FruitFactory factory = new StrawberryFactory();
        Fruit fruit = factory.getFruit();
        fruit.draw();

    }
}
