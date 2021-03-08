package designpattern.bridge;

import designpattern.bridge.impl.Matrix;

/**
 * @author xiayu
 * @version 1.0
 * @className ImageImp
 * @description TODO
 * @date 2021/1/29 17:16
 */
public interface ImageImp {

    void doPaint(Matrix m);  //显示像素矩阵m

}
