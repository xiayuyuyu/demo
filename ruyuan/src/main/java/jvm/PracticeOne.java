package jvm;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xy
 * @version 1.0
 * @description
 * @date 2020/8/29 00:23
 */
public class PracticeOne {

    public static void main(String[] args) {
        String[] array = {};
        Class<? extends String[]> aClass = array.getClass();
        Field[] fields = getAllFields(aClass);
        System.out.println(aClass.getName());
        System.out.println("=========");
        for (Field field : fields) {
            System.out.println(field.getName());
            System.out.println(field.getType());
        }

    }

    public static List<Field> getAllFieldsList(final Class<?> cls) {
        final List<Field> allFields = new ArrayList<>();
        Class<?> currentClass = cls;
        while (currentClass != null) {
            final Field[] declaredFields = currentClass.getDeclaredFields();
            Collections.addAll(allFields, declaredFields);
            currentClass = currentClass.getSuperclass();
        }
        return allFields;
    }

    public static Field[] getAllFields(final Class<?> cls) {
        final List<Field> allFieldsList = getAllFieldsList(cls);
        return allFieldsList.toArray(new Field[0]);
    }


}
