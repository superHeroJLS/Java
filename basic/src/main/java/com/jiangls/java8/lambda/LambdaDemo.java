package com.jiangls.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author jiangls
 * @Date 2021/9/18
 */
public class LambdaDemo {

    public static void main(String[] args) {
        lambdaForeachReturn();
    }


    public static void lambdaForeachReturn() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

        AtomicReference<String> tmp = new AtomicReference<>();
        /**
         * forEach中执行 return 之后，仅仅只是退出本次循环，并不会退出循环体
         */
        list.forEach(str -> {
            tmp.set(str);
            if (str.equals("2")) {
                return;
            }
        });

        System.out.println("tmp: " + tmp);
    }
}
