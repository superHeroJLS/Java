/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.atomictest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * <p>验证AtomicReference线程安全，
 *  * AtomicReference通过volatile + CAS保证了线程安全，即给变量加上关键字volatile，volatile变量更新的时候使用CAS进行更新</p>
 *  <p>验证AtomicReference ABA问题：CAS中当前值和当前线程持有的旧值的比较用的是 ==，而不是equals
 *  <ol>
 *      以Map为例：现在有线程t1和线程t2
 *      <li>t1先进入CAS方法，拿到旧map对象就立马阻塞了</li>
 *      <li>t2后进入CAS方法，没有阻塞顺利执行方法，这时t2已经把AtomicReference中的map对象替换成了新map对象</li>
 *      <li>t1结束阻塞继续执行CAS方法，t1用自己持有的旧map对象和AtomicReference中的当前map对象进行比较（使用 == 比较而不是 equals），得到的结果是false</li>
 *      <li>t1得到比较得到结果为false，继续获取AtomicReference中当前map对象，接着执行CAS操作，直到CAS操作成功</li>
 *  </ol>
 *  </p>
 *
 * @Author jiangls
 * @Date 2021/8/31
 */
public class AtomicReferenceABATest {
    static AtomicReference<Map<String, Object>> mapAtomicReference = new AtomicReference<>();

    public static void main(String[] args) throws InterruptedException {

        Map<String, Object> originalMap = new HashMap<>();
        originalMap.put("k1", "v1");
        originalMap.put("k2", "v2");
        mapAtomicReference.set(originalMap);

        Thread t1 = new Thread() {
            @Override
            public void run() {
                Map<String, Object> imap = Collections.singletonMap("k3", "v3");

                mapAtomicReference.accumulateAndGet(imap, (oldMap, map) -> {

                    /**
                     * 当前线程sleep 500ms，模拟mapAtomicReference中的值已经被t2线程修改
                     */
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                    }

                    Map<String, Object> newMap = new HashMap<>();
                    newMap.putAll(oldMap);
                    newMap.putAll(map);
                    return newMap;
                });
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {

                /**
                 * 当前线程sleep 100ms，让t1线程先执行
                 */
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }

                Map<String, Object> imap = Collections.singletonMap("k4", "v4");

                // t2线程中accumulateAndGet方法执行之后，AtomicReference中的值就被修改了
                mapAtomicReference.accumulateAndGet(imap, (oldMap, map) -> {
                    Map<String, Object> newMap = new HashMap<>();
                    newMap.putAll(oldMap);
                    System.out.println("t2 is executing...");
                    return newMap;
                });
            }
        };

        t2.start();
        t1.start();
        t1.join();
        t2.join();

    }
}
