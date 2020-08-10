package java8;

import org.junit.Test;

/**
 * @author xiayu
 * @version 1.0
 * @className Test1
 * @description
 * @date 2019/10/8 11:00
 */
public class Test1 {
    @Test
    public void test1() {
        Something something = new Something();
        Converter<String, String> converter = something::startWith;
        String s = converter.convert("java");
        System.out.println(s);
    }

}
