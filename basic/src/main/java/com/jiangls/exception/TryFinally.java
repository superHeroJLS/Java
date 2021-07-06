/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.exception;

/**
 * @Author jiangls
 * @Date 2021/7/6
 */
public class TryFinally {
    public static void main(String[] args) {
        int i = 0;
        while (true) {
            System.out.println("while iteration: " + (i++));
            try {
                tryFinallyTest();
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void tryFinallyTest() {
        try {
            if (true) {
                throw new RuntimeException("runtime exception");
            }
        } finally {
            System.out.println("finally blcok");
        }
    }
}
