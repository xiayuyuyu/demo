package collection;

import java.util.HashMap;
import java.util.Random;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/9/14 14:42
 */
public class HashMapSourceCode {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            String r = random.nextInt(1000) + "";
            map.put(i, r);
        }
        System.out.println(map);
    }
}
