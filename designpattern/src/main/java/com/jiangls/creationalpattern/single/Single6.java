package com.jiangls.creationalpattern.single;

/**
 * lazy loading 懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过双重判断+synchronized解决线程安全问题，但也带来效率下降的问题
 */
public class Single6 {
    // volatile保证可见性和有序性，不加volatile在超高并发下有序性无法被保证，可能某个线程会获取到null值
    private static volatile Single6 INSTANCE;

    private Single6() {}

    public static Single6 getInstance() {
        if (INSTANCE == null) {
            synchronized (Single6.class) {
                if (INSTANCE == null) {
                    // 模拟业务
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    INSTANCE = new Single6();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single6.getInstance().hashCode())).start();
        }
    }

}
