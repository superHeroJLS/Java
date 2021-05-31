package com.jiangls.creationalpattern.prototype;

public class Client {
    public static void main(String[] args) {
        Student stu = new Student(123, "Bob", 88);

        Student clonedStu = (Student) stu.clone();
        System.out.println(clonedStu == stu);

        Student copiedStu = stu.copy();
        System.out.println(copiedStu == stu);
    }
}
