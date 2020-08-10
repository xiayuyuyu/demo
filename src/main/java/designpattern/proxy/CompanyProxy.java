package designpattern.proxy;

/**
 * @author xiayu001
 * @version 1.0
 * @className CompanyProxy
 * @description
 * @date 2019-06-05 11:34
 */
public class CompanyProxy implements Company {

    private Company target;

    public CompanyProxy(Company target) {
        this.target = target;
    }


    @Override
    public String fire() {
        return target.fire();
    }

}
