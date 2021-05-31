package com.jiangls.creationalpattern.factorymethod;

/**
 * 我们希望实现一个解析字符串到Number的Factory，可以定义如下
 */
public interface NumberFactory {
    Number parse(String s);

    //获取工厂实例，getFactory是给公开给Client调用的
    static NumberFactory getFactory() {
        return impl;
    }

    static NumberFactory impl = new NumberFactoryImpl();
}
