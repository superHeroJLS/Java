package com.jiangls.generic.genericsandvarargs;

import java.util.Arrays;

/**
 * @author Jiangls
 * @date 2022/1/4
 */
public class GenericsAndVarargsDemo {

    /**
     * 直接调用asArray(T...)似乎没有问题，但是在另一个方法中，我们返回一个泛型数组就会产生ClassCastException，
     * 原因还是因为擦拭法，在pickTwo()方法内部，编译器无法检测K[]的准确类型，因此返回了Object[]。<br>
     *
     * 问题的根源：可变参数的方法，实际接收的是一个数组，所以调用可变参数的方法时，会把参数封装成一个数组。<br>
     * 如果在泛型方法里，调用泛型可变参数的方法，那么入参会被擦拭成Object数组。即在pickTwo()方法中K会被擦拭成Object类型。<br>
     *
     * 建议可以看看GenericsAndVarargsDemo.class反编译出来的代码：
     * 31行反编译结果，发现会有一个强制向下转型：String[] arr = (String[])asArray("one", "two", "three");<br>
     * 33行反编译结果，发现会有一个强制向下转型：String[] firstTwo = (String[])pickTwo("one", "two", "three");<br>
     *
     * 更详细的解释请参考《Effective Java》“Item 32: Combine generics and varargs judiciously”。<br>
     *
     * 如果在方法内部创建了泛型数组，最好不要将它返回给外部使用。<br>
     * @param args
     */
    public static void main(String[] args) {
        String[] arr = asArray("one", "two", "three");
        System.out.println(Arrays.toString(arr));
        // ClassCastException:
        String[] firstTwo = pickTwo("one", "two", "three");
        System.out.println(Arrays.toString(firstTwo));
    }

    static <K> K[] pickTwo(K k1, K k2, K k3) {
        K[] arr = asArray(k1, k2);
        return arr;
    }

    static <T> T[] asArray(T... objs) {
        T[] arr = objs;
        return arr;
    }
}
