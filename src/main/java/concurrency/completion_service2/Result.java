package concurrency.completion_service2;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/29 11:24
 */
public class Result {

    private String a;

    private boolean b;

    private Integer c;

    public Result() {
    }

    public Result(String a, boolean b, Integer c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "Result{" +
                "a='" + a + '\'' +
                ", b=" + b +
                ", c=" + c +
                '}';
    }
}
