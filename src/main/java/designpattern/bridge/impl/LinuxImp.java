package designpattern.bridge.impl;

import designpattern.bridge.ImageImp;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/1/29 17:18
 */
public class LinuxImp implements ImageImp {

    @Override
    public void doPaint(Matrix m) {
        //调用Linux系统的绘制函数绘制像素矩阵
        System.out.print("在Linux操作系统中显示图像：");

    }
}
