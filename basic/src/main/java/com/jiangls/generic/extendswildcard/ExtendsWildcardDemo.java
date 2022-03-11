package com.jiangls.generic.extendswildcard;

/**
 * 泛型，extends关键字例子，
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
 *                <li>T extends Number</li>
 *                <li>? extends Number</li>
 *                <li>? extends T</li>
 *         </ol>
 *         以上使用泛型的地方和extends通配符泛型可以产生9种组合。
 *     </ol>
 *     <ol>
 *         以下简单介绍extends通配符泛型常见的使用场景：
 *         <li> ? extends Number 这种 ? extends 通配符能在方法参数中使用，也能在返回类型中使用</li>
 *         <li> T extends Number 这种 T extends 通配符类型能在在类定义中使用、能在方法返回类型中使用、能在方法参数中使用</li>
 *         <li> ? extends T 这种通配符一般用在方法参数中，限定 ? 继承的是 T 类型，但是在方法中无法使用 ? 来做一些类型判断</li>
 *     </ol>
 * </p>
 *
 * @author Jiangls
 * @date 2022/1/4
 */
public class ExtendsWildcardDemo {

    public static void main(String[] args) {

    }

    static int add(Pair<? extends Number> p) {
        Number first = p.getFirst();
        Number last = p.getLast();
        /*
            p无法调用setFirst() setLast()方法，编译报错：
            incompatible types: Integer cannot be converted to CAP#1
            where CAP#1 is a fresh type-variable:
                CAP#1 extends Number from capture of ? extends Number

            为什么不能调用2个set方法呢？原因是编译器只知道容器内是Number或者它的派生类，但具体是什么类型不知道。可能是Number？可能是Integer？也可能是Double？
            编译器在看到后面用Number赋值以后，集合里并没有限定参数类型是Number。而是标上一个占位符：CAP#1，来表示捕获一个Number或Number的子类，具体是什么类不知道，代号CAP#1。
            然后无论是想往里插入Number或者Integer或者Double编译器都不知道能不能和这个CAP#1匹配，所以就都不允许。

            换句话说，使用<? extends Number>通配符作为方法参数，表示方法内部代码对于传入方法内的参数只读不写（恶意调用set(null)除外）
         */
//        p.setFirst(first);
//        p.setLast(last);
        return p.getFirst().intValue() + p.getFirst().intValue();
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
