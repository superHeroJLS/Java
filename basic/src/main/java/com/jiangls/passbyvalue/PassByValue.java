package com.jiangls.passbyvalue;

import org.omg.CORBA.IntHolder;

/**
 * 值传递
 *
 * @author Jiangls
 * @date 2022/4/2
 */
public class PassByValue {
    public static void main(String[] args) {
        IntHolder ih = new IntHolder(3);
        triple(ih);
        System.out.println("after invoked triple, ih = " + ih.value);
    }

    /**
     * IntHolder作为参数类型，参数值被传递到方法中之后可以被修改，IntHolder包含一个共有域值，通过它可以访问存储在其中的值。</br>
     * 其他的还有DoubleHolder，StringHolder等
     * @param x
     */
    public static void triple(IntHolder x) {
        x.value = 3 * x.value;
    }

}

class PassDemo {
    public static void main(String[] args) {
        int ox = 3;
        triple(ox);
        System.out.println("after invoked triple, ox = " + ox);

        Integer wox = 3;
        triple(wox);
        System.out.println("after invoked triple, wox = " + wox);


    }

    /**
     * 由于java方法都是值传递，所以不可能编写一个下面这样的能够增加整形参数值的java方法
     * @param x
     */
    public static void triple(int x) {
        x = 3 * x;
    }

    public static void triple2(Integer x) {
        x = 3 * x;
    }


}

