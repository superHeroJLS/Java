package com.jiangls.creationalpattern.prototype;

public class Student {
    private int id;
    private String name;
    private int score;

    public Student() {
    }

    public Student(int id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    /*
        复制新对象并返回:
        但是因为clone()的方法签名是定义在Object中，返回类型也是Object，所以要强制转型，比较麻烦；
        所以，实际上，使用原型模式更好的方式是定义一个copy()方法，返回明确的类型：
         */
    public Object clone() {
        Student std = new Student();
        std.id = this.id;
        std.name = this.name;
        std.score = this.score;
        return std;
    }

    public Student copy() {
        Student std = new Student();
        std.id = this.id;
        std.name = this.name;
        std.score = this.score;
        return std;
    }
}
