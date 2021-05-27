package com.jiangls.single;

/**
 * lazy loading 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Single3 {
    private static Single3 INSTANCE;

    private Single3() {
    }

    public static Single3 getINSTANCE() {
        if (INSTANCE == null) {
            try {
                // 模拟业务场景
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Single3();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single3.getINSTANCE().hashCode())).start();
        }
    }

}
