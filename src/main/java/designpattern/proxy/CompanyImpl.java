package designpattern.proxy;

/**
 * @author xiayu001
 * @version 1.0
 * @className CompanyImpl
 * @description
 * @date 2019-06-05 11:28
 */
public class CompanyImpl implements Company {

    @Override
    public String fire() {
        return "you are fired! get out right now";
    }
}
