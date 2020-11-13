package basic;

import com.sun.xml.internal.ws.util.Pool;

import java.lang.reflect.Field;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/10/30 15:40
 */

public class ReflectionDemo {

    private String fieldStr;
    private double fieldDouble;
    private Double fieldBigDouble;
    private char fieldChar;
    private Character fieldCharacter;

    private String[] arrayString;
    private double[] arrayDouble;
    private Double[] arrayBigDouble;
    private long[] arrayLong;
    private Long[] arrayBigLong;
    private float[] arrayFloat;
    private Float[] arrayBigFloat;
    private char[] arrayCharacter;
    private Character[] arrayBigCharacter;
    private int[] arrayInteger;
    private Integer[] arrayBigInteger;
    private Integer[][][] arrayBigIntegerArray;
    private Object[][][] objects;
    private Transfer transfer;



    public static void main(String[] args) throws IllegalAccessException {
        ReflectionDemo reflectionDemo = new ReflectionDemo();
//        System.out.println(reflectionDemo.getClass().getClassLoader().getResource("/"));
        Field[] declaredFields = reflectionDemo.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            Class<?> type = field.getType();
            System.out.println("-----------");
            System.out.println("field.getName():  "+field.getName());
            System.out.println("filedType:  "+type);
            System.out.println("type.getName():  "+type.getName());
            System.out.println("type.getSimpleName():  "+type.getSimpleName());
            System.out.println("field.get(reflectionDemo) instanceof Object[]:  "+(field.get(reflectionDemo) instanceof Object[]));
//            System.out.println("type.getCanonicalName():  "+type.getCanonicalName());
//            System.out.println("field.getClass().getName():  "+field.getClass().getName());
        }

    }
}
