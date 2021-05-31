package com.jiangls.creationalpattern.factorymethod;

import java.math.BigDecimal;

/**
 * 有了NumberFactory工厂接口，再编写一个工厂的实现类。<br/>
 * NumberFactory工厂接口中要求parse方法返回类型为Number，NumberFactoryImpl返回的实际类型是BigDecimal
 */
public class NumberFactoryImpl implements NumberFactory {

    @Override
    public Number parse(String s) {
        return new BigDecimal(s);
    }
}
