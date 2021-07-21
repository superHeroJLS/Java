/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.reference;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author jiangls
 * @Date 2021/7/21
 */
public class ReferenceMain {
    public static void main(String[] args) {
        Goods cpu = new Goods("cpu");
        // WeakReference
        WeakReference<Goods> memoryWeakReference = new WeakReference<>(new Goods("memory"));

        // 这里新建的new Goods("cpu")只被order成员变量引用
        Order order = new Order(cpu, memoryWeakReference);

        // 手动gc，看看WeakReference是否被回收，休眠，让gc完成
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (order.getGoods() != null) {
            // 强引用对象，只要被引用就不会被JVM的GC回收
            System.out.println(order.getGoods().getName());
        } else {
            // 强引用对象只要从GC Roots不可达，才会被JVM的GC回收
            System.out.println("goods cpu was gc");
        }

        if (order.getGoodsRef() != null && order.getGoodsRef().get() != null) {
            System.out.println(order.getGoodsRef().get().getName());
        } else {
            // WeakReference引用的对象，只要JVM发生了GC，这个对象就会被回收
            System.out.println("memoryWeakReference was gc");
        }

    }
}
