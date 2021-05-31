package com.jiangls.creationalpattern.single;

/**
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全。
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化，实际开发使用的例子
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
public class Single1 {

    private static final Single1 INSTANCE = new Single1();

    private Single1() {
    }

    public static Single1 getInstance() {
        return INSTANCE;
    }

    public static void main(String[] args) {
        Single1 instance1 = Single1.getInstance();
        Single1 instance2 = Single1.getInstance();
        System.out.println("instance1 == instance2: " + (instance1 == instance2));
    }
}
