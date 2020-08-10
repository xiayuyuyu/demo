package file;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/31 15:00
 */
public class PropertiesDemo {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("card", "4321432");
        properties.setProperty("mobile", "13122931882");
        System.out.println(properties);
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            map.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()));

        }
        System.out.println(map);

//        Iterator<Object> iterator = properties.keySet().iterator();
//        while (iterator.hasNext()) {
//            iterator.next().toString();
//        }
    }
}
