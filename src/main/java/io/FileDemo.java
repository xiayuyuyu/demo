package io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/1/20 15:49
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100; i++) {
            sb.append(random.nextInt(100)).append(System.getProperty("line.separator"));
        }

        // 创建文件
        System.out.println(sb.toString());
        File file = new File("address.csv");
        // 判断文件否存在
        if (!file.isDirectory()) {
            file.createNewFile();
        } else {
            System.out.println("文件已存在");
        }
        // 创建输出流FileOutputStream对象out
        FileOutputStream out = new FileOutputStream(file);
        out.write(sb.toString().getBytes("UTF-8"));
        // 关闭输出流
        out.close();
    }
}
