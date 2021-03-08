package hutool;

import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RandomUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/1/21 15:12
 */
public class CsvDemo {
    public static void main(String[] args) {
        CsvWriter writer = CsvUtil.getWriter("../../test.csv", CharsetUtil.CHARSET_UTF_8);
        List<List<String>> list = new ArrayList<>();
//        List<String> list = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                String abc = "哈哈"+RandomUtil.randomInt(10);
                row.add(abc);
            }
//            String text = row.stream().collect(Collectors.joining(","));
            list.add(row);
            Console.log("行内容为{}",row);
        }

        writer.write(list);

    }
}
