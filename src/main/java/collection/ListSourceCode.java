package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/9/12 02:29
 */

public class ListSourceCode {
    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(random.nextInt(1000));
        }
        System.out.println(list);
    }

}
