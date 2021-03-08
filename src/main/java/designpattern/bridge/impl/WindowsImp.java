package designpattern.bridge.impl;

import designpattern.bridge.ImageImp;

/**
 * @author xy
 * @version 1.0
 * @description https://blog.csdn.net/lovelion/article/details/7464204
 * @date 2021/1/29 17:17
 */
public class WindowsImp implements ImageImp {

    @Override
    public void doPaint(Matrix m) {
        //调用Windows系统的绘制函数绘制像素矩阵
        System.out.print("在Windows操作系统中显示图像：");

    }
}
