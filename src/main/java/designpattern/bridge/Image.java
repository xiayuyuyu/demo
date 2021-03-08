package designpattern.bridge;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2021/1/29 17:15
 */
public abstract class Image {
    protected ImageImp imp;

    public void setImageImp(ImageImp imp) {
        this.imp = imp;
    }

    public abstract void parseFile(String fileName);
}
