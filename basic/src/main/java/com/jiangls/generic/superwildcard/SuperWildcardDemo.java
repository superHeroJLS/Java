package com.jiangls.generic.superwildcard;

/**
 * 泛型，super关键字例子，
 * 参考1：<a href="https://www.liaoxuefeng.com/wiki/1252599548343744/1265105899616928">https://www.liaoxuefeng.com/wiki/1252599548343744/1265105899616928</a><br>
 * 参考2：<a href="https://www.cnblogs.com/wcss/p/11867393.html">https://www.cnblogs.com/wcss/p/11867393.html</a>
 *
 * <p>
 *     <ol>
 *         <ol>
 *             一个类中可以使用泛型的地方有3个：
 *             <li>类定义泛型</li>
 *             <li>方法返回值类型</li>
 *             <li>方法参数类型</li>
 *         </ol>
 *         <ol>
 *             extends通配符泛型种类：
 *                <li>T super Integer</li>
 *                <li>? super Integer</li>
 *                <li>? super T</li>
 *         </ol>
 *         以上使用泛型的地方和super通配符泛型可以产生9种组合。
 *     </ol>
 *     <ol>
 *         以下简单介绍super通配符泛型常见的使用场景：
 *         <li> ? super Integer 这种super通配符可以在方法参数中使用</li>
 *     </ol>
 * </p>
 *
 * @author Jiangls
 * @date 2022/1/4
 */
public class SuperWildcardDemo {
    public static void main(String[] args) {
        Pair<Number> p1 = new Pair<>(12.3, 4.56);
        Pair<Integer> p2 = new Pair<>(123, 456);
        setSame(p1, 100);
        setSame(p2, 200);
        System.out.println(p1.getFirst() + ", " + p1.getLast());
        System.out.println(p2.getFirst() + ", " + p2.getLast());
    }

    static void setSame(Pair<? super Integer> p, Integer n) {
        p.setLast(n);

        /*
            p可以调用getFirst()方法，但是不建议调用get方法。

            为什么不建议待用get方法。因为调用getFirst()方法返回的类型是不确定的，可以通过强制向下转为Integer，这种做法是不安全的，
            代码在运行的时候很可能会抛出类型转换异常java.lang.ClassCastException。
            （唯一例外是可以获取Object的引用，然后来获取o实例类型的名称：Object o = p.getFirst();o.getClass().getName()；）

            换句话说，使用<? super Integer>通配符作为方法参数，表示方法内部代码对于参数只写，不读。

         */
        // 强制向下转型，很可能会抛出类型转换异常java.lang.ClassCastException
        Integer first = (Integer) p.getFirst();

        Object o = p.getFirst();
        System.out.println("o class name: " + o.getClass().getName());
    }
}

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
    public T getLast() {
        return last;
    }
    public void setFirst(T first) {
        this.first = first;
    }
    public void setLast(T last) {
        this.last = last;
    }
}
