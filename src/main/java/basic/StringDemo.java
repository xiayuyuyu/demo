package basic;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/7/30 14:28
 */
public class StringDemo {


    public static void main(String[] args) {
        String a = "2";
        a = a + "11111";
        System.out.println(a);

        int x = 1;
//        System.out.println(x++);
        System.out.println(x);
        System.out.println(++x);
        System.out.println(x);
        System.out.println(++x);
        System.out.println(x);

        System.out.println(SecurityUtils.getMD5Str("11111"));
        System.out.println(SecurityUtils.getMD5Str("11111").length());
    }
}
