package com.jiangls.single;

/**
 * lazy loading 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降的问题
 */
public class Single4 {
    private static Single4 INSTANCE;

    private Single4() {
    }

    public synchronized static Single4 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Single4();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single4.getInstance().hashCode())).start();
        }
    }
}
