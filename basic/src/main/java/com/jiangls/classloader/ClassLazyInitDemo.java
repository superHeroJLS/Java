package com.jiangls.classloader;

/**
 * Java 中类的初始化实际上也采取了延迟加载的技术，
 * 即一个类被Java 虚拟机加载之后，该类的所有静态变量的值都仍然是其默认值
 * （引用型变量的默认值为null , boolean 变量的默认值为false ），
 * 直到有个线程初次访问了该类的任意一个静态变量才使这个类被初始化--类的静态初始化块（static{}）被执行，
 * 类的所有静态变量被赋予初始值
 */
public class ClassLazyInitDemo {
    public static void main(String[] args) {
        System.out.println(Collaborator.class.hashCode());
        System.out.println(Collaborator.number);
        System.out.println(Collaborator.flag);
    }

    static class Collaborator {
        static int number = 1;
        static boolean flag = false;
        static {
            System.out.println(Collaborator.class.getName() + "initializing...");
        }
    }
}
