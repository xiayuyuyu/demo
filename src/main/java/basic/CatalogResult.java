package basic;

import java.util.StringJoiner;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/28 19:26
 */
public class CatalogResult {

    private String result1;

    private Integer result2;

    private Long result3;

    public CatalogResult() {
    }

    public CatalogResult(String result1, Integer result2, Long result3) {
        this.result1 = result1;
        this.result2 = result2;
        this.result3 = result3;
    }


    public String getResult1() {
        return result1;
    }

    public void setResult1(String result1) {
        this.result1 = result1;
    }

    public Integer getResult2() {
        return result2;
    }

    public void setResult2(Integer result2) {
        this.result2 = result2;
    }

    public Long getResult3() {
        return result3;
    }

    public void setResult3(Long result3) {
        this.result3 = result3;
    }

    @Override
    public String toString() {
        return "CatalogResult{" +
                "result1='" + result1 + '\'' +
                ", result2=" + result2 +
                ", result3=" + result3 +
                '}';
    }
}
