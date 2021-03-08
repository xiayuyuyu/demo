package designpattern.bridge.impl;

import designpattern.bridge.Image;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/1/29 17:21
 */
public class BMPImage extends Image {
    @Override
    public void parseFile(String fileName) {
        //模拟解析BMP文件并获得一个像素矩阵对象m;
        Matrix m = new Matrix();
        imp.doPaint(m);
        System.out.println(fileName + "，格式为BMP。");

    }
}
