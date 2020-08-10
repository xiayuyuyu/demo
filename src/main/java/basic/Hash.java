package basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xiayu001
 * @version 1.0
 * @className Hash
 * @description
 * @date 2019-07-02 10:08
 */
public class Hash {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("str", "我滴老嘎,就住在这个屯");
        map.put("ABCDEa123abc", "ABCDEa123abc");
        map.put("ABCDFB123abc", "ABCDFB123abc");
        map.get("str");
        map.get("nullTest");
        System.out.println(map);

        List<String> list1 = new ArrayList<>();
        list1.add("str1");
        list1.add("str1");
        list1.add("str2");
        System.out.println(list1);


       /* ArrayList<Object> list = new ArrayList<Object>();
        final int N = 10000000;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法前："+(endTime - startTime));

        list = new ArrayList<Object>();
        long startTime1 = System.currentTimeMillis();
        list.ensureCapacity(N);
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long endTime1 = System.currentTimeMillis();
        System.out.println("使用ensureCapacity方法后："+(endTime1 - startTime1));*/

        Map<String, String> concurrentHashmap = new ConcurrentHashMap<>();


    }
}
