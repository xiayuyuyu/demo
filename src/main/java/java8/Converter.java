package java8;

/**
 * @author xiayu
 * @version 1.0
 * @className Converter
 * @description TODO
 * @date 2019/10/8 11:01
 */
@FunctionalInterface
public interface Converter<F, T> {
    /**
     * convert
     * @param from
     * @return T
     */
    T convert(F from);

}
