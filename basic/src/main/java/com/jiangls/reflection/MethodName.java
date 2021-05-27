package com.jiangls.reflection;

import java.util.Arrays;

public class MethodName {
    public static void main(String[] args) {
        // print all method name
        Arrays.stream(MethodName.class.getDeclaredMethods()).forEach(method -> System.out.println(method));
    }


    private void methodOfInstance() {
    }

    private static void methodOfStatic() {
    }
}
