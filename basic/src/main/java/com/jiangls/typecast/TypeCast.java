/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.typecast;

/**
 * @Author jiangls
 * @Date 2021/7/12
 */
public class TypeCast {
    public static void main(String[] args) {
        String str = (String) null;
        System.out.println(str);

        // 自定义类强制向下转型 ，编译通过，运行抛出异常
//        Employee e = new Employee();
//        Manager m = (Manager) e;
//        System.out.println(m.getClass().getName());

        // 可以使用instance关键字做判断，这样可以避免编译通过运行异常
        Employee e2 = new Employee();
        if (e2 instanceof Manager) {
            Manager m2 = (Manager) e2;
            System.out.println(m2.getClass().getName());
        }

        // 这样向下转，编译通过，运行通过。m1本来就是Manager类型，将m1转回去是不会报错的。
        Employee e1 = new Manager();
        Manager m1 = (Manager) e1;
        System.out.println(m1.getClass().getName());
        System.out.println("e1 instanceof Employee: " + (e1 instanceof Employee));
        System.out.println("e1 instanceof Manager: " + (e1 instanceof Manager));

    }
}

class Employee{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Manager extends Employee {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
