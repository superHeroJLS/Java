package com.jiangls.single;

/**
 * lazy loading 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降的问题
 * 妄图通过缩小synchronized块提高效率，但是并不行
 */
public class Single5 {
    private static Single5 INSTANCE;

    private Single5(){}

    public static Single5 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 妄图通过缩小synchronized块提高效率，但是并不行
            synchronized (Single5.class) {
                INSTANCE = new Single5();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single5.getInstance().hashCode())).start();
        }
    }

}
