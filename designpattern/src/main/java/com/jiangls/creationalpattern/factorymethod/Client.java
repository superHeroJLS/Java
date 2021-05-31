package com.jiangls.creationalpattern.factorymethod;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @Author jiangls
 * @Date 2020/8/31 15:22
 */
public class Client {
    public static void main(String[] args) {
        /*
        获取抽象工厂 > 调用抽象工厂方法
        客户端在调用的时候，工厂接口NumberFactory以及抽象产品Number打交道。
        调用方可以完全忽略真正的工厂NumberFactoryImpl和实际的产品BigDecimal，这样做的好处是允许创建产品的代码独立地变换，而不会影响到调用方
        */
        NumberFactory factory = NumberFactory.getFactory();
        Number result = factory.parse("123.456");
        System.out.println(result instanceof BigDecimal);

        /*
        调用静态工厂方法。
        静态工厂方法广泛地应用在Java标准库中，例如Integer.valueOf("12")、MessageDigest.getInstance("MD5")
         */
        Number number = StaticNumberFacotry.parse("123.444");
        System.out.println(number instanceof BigDecimal);

        /*
        调用静态工厂方法获取LocalDate
         */
        LocalDate localDate = LocalDateFactory.fromInt(20200831);
        System.out.println("year: " + localDate.getYear());
        System.out.println("month: " + localDate.getMonth().getValue());
        System.out.println("day of month: " + localDate.getDayOfMonth());

    }
}
