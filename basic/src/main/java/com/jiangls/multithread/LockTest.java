/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.multithread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用jclasslib plugin查看ReentrantLock.lock()是否有特殊的JVM指令。
 * 结论：没有特殊的字节码，和调用普通的实例方法一样，使用的是invokevirtual指令。
 * @Author jiangls
 * @Date 2021/8/3
 */
public class LockTest {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }
}
