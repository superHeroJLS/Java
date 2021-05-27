package com.jiangls.single;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Single7 {
    private static Single7 INSTANCE;

    private Single7(){}

    private static class Single7Holder {
        private final static Single7 INSTANCE = new Single7();
    }

    private static Single7 getInstance() {
        return Single7Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++){
            new Thread(() -> System.out.println(Single7.getInstance().hashCode())).start();
        }
    }
}
