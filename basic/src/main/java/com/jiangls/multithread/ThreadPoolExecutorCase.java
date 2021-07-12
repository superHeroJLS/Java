/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls.multithread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadPoolExecutor使用
 *
 * @Author jiangls
 * @Date 2021/7/12
 */
public class ThreadPoolExecutorCase {

    public static void main(String[] args) {
        new ThreadPoolExecutorCase().doInit();
    }

    private DataManager datamanager = new DataManager();
    // 创建线程池，单个线程，工作队列数量1
    private static final ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1,
            0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1), new DaemonThreadFactory());
    private static final Boolean flag = Boolean.FALSE;

    public void doInit() {
        try {
            // 构造数据级授权信息
            String bizData = datamanager.buildData();

            // 创建task
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    while (Boolean.TRUE) {
                        try {
                            // 推送数据级授权信息
                            datamanager.registerDataAcl(bizData);
                            break;
                        } catch (Exception e) {
                        }
                        // 推送出现异常，休眠10秒，再次推送
                        try {
                            TimeUnit.SECONDS.sleep(10);
                        } catch (Exception e) {
                        }
                    }
                }
            };

            // task提交至ThreaPool执行
            tp.submit(task);
        } catch (Exception e) {
            System.out.println("推动数据级授权信息失败：" + e.getMessage());
        }
    }

    // 自定义ThreadFactory，生成的Thread默认是daemon线程，参考DefaultThreadFactory的实现
    private static class DaemonThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;
        private static Boolean isDaemon = Boolean.TRUE;

        DaemonThreadFactory() {
            this(Boolean.TRUE);
        }

        DaemonThreadFactory(Boolean isDaemon) {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (isDaemon) {
                t.setDaemon(Boolean.TRUE);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

}

class DataManager {
    public void registerDataAcl(String data) {
        // 模拟数据注册操作
        try {
            System.out.println("executing DataManager.registerDataAcl()");
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String buildData() {
        return "{'key': 'value'}";
    }
}
