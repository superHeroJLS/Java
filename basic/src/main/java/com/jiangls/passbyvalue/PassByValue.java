package com.jiangls.passbyvalue;

import org.omg.CORBA.IntHolder;

/**
 * 值传递
 *
 * @author Jiangls
 * @date 2022/4/2
 */
public class PassByValue {
    public static void main(String[] args) {
//        IntHolder ih = new IntHolder(3);
//        triple(ih);
//        System.out.println("after invoked triple, ih = " + ih.value);

        /*
         * Test 2: Methods can change the state of object parameters
         * Java是调用方法时，实参是值传递，下面变量harry存储的是Employee实例的内存地址，调用方法updateAndSalary(harry)将harry作为实参传递，
         * 方法updateAndSalary(Employee x)执行的时候，实参x copy了harry存储的值也就是Employee实例的内存地址，所以方法前定义变量harry和方法
         * 执行时实参x存储的都是同一个Employee实例的内存地址，所以在harry和x打印出来的就是同一个Employee实例。
         */
        System.out.println("Testing tripleSalary:");
        Employee harry = new Employee("Harry", 50000d, new PassDemo());
        System.out.println("before harry: " + harry);
        System.out.println(harry.getObj());
        System.out.println(harry.getName());
        System.out.println("Before: salary=" + harry.getSalary());
        updateAndSalary(harry);
        System.out.println("after harry: " + harry);
        System.out.println(harry.getObj());
        System.out.println(harry.getName());
        System.out.println("After: salary=" + harry.getSalary());

        /*
         * Test 3: Methods can't attach new objects to object parameters
         */
//        System.out.println("Testing swap:");
//        Employee a = new Employee("Alice", 70000);
//        Employee b = new Employee("Bob", 60000);
//        System.out.println("Before: a=" + a);
//        System.out.println("Before: b=" + b);
//        System.out.println("Before: a=" + a.getName());
//        System.out.println("Before: b=" + b.getName());
//        swap(a, b);
//        System.out.println("After: a=" + a);
//        System.out.println("After: b=" + b);
//        System.out.println("After: a=" + a.getName());
//        System.out.println("After: b=" + b.getName());
    }

    public static void swap(Employee x, Employee y)
    {
        Employee temp = x;
        x = y;
        y = temp;
        System.out.println("End of method: x=" + x);
        System.out.println("End of method: y=" + y);
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }

    public static void updateAndSalary(Employee x)
    {
        x.raiseSalary(200d);
        x.setName(x.getName() + " updated");
        System.out.println("End of method: harry=" + x);
        System.out.println(x.getObj());
        System.out.println(x.getName());
        System.out.println("End of method: salary=" + x.getSalary());
    }

    /**
     * IntHolder作为参数类型，参数值被传递到方法中之后可以被修改，IntHolder包含一个共有域值，通过它可以访问存储在其中的值。</br>
     * 其他的还有DoubleHolder，StringHolder等
     * @param x
     */
    public static void triple(IntHolder x) {
        x.value = 3 * x.value;
    }

}

class PassDemo {
    public static void main(String[] args) {
        int ox = 3;
        triple(ox);
        System.out.println("after invoked triple, ox = " + ox);

        Integer wox = 3;
        triple(wox);
        System.out.println("after invoked triple, wox = " + wox);


    }

    /**
     * 由于java方法都是值传递，所以不可能编写一个下面这样的能够增加整形参数值的java方法
     * @param x
     */
    public static void triple(int x) {
        x = 3 * x;
    }

    public static void triple2(Integer x) {
        x = 3 * x;
    }


}

class Employee // simplified Employee class
{
    private String name;
    private Double salary;
    private PassDemo obj;

    public Employee(String n, Double s, PassDemo obj)
    {
        name = n;
        salary = s;
        this.obj = obj;
    }

    public String getName()
    {
        return name;
    }

    public PassDemo getObj()
    {
        return obj;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary()
    {
        return salary;
    }

    public void raiseSalary(Double byPercent)
    {
        Double raise = salary * byPercent / 100;
        salary += raise;
    }
}

