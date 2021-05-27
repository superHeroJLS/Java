package com.jiangls.single;

/**
 * 和Single1相同，不过实例化在static块中
 */
public class Single2 {
    private static final Single2 INSTANCE;
    static {
        INSTANCE = new Single2();
    }

    private Single2() {
    }

    public Single2 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Single2 instance1 = new Single2();
        Single2 instance2 = new Single2();
        System.out.println("instance1 == instance2: " + (instance1 == instance2));
    }
}
