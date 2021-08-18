package com.jiangls;

import com.jiangls.util.RedissonUtil;
import lombok.SneakyThrows;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author jiangls
 * @Date 2021/8/17
 */
public class RedissonDistributedLock {

    public static void main(String[] args) {
//        list();

//        buyWithoutDistributedLock();

        buyWithDistributedLock();
    }

    /**
     * 获取由Redisson实现的List
     */
    public static void list() {
        // 本地启动redis-server，端口为6379
        RedissonClient client = RedissonUtil.getClient("redis://127.0.0.1:6379");

        RList<String> redissonList = client.getList("redissonList");
        redissonList.add("redisson");
        redissonList.expire(60, TimeUnit.SECONDS);

        RedissonUtil.shutdown(client);
    }

    /**
     * 商品总数为100
     */
    private static int amountOfGoods = 1000;

    /**
     *
     * 抢购商品，多线程实现，不使用分布式锁
     */
    public static void buyWithoutDistributedLock() {
        List<Thread> threadList = new ArrayList<>();

        for (int i = 1000; i > 0; i--) {
            threadList.add(new MyThread());
        }
        
        threadList.forEach(thread -> thread.start());
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     *
     * 抢购商品，多线程实现，使用分布式锁保证线程安全
     * <p>参考文档：https://github.com/redisson/redisson/wiki/8.-%E5%88%86%E5%B8%83%E5%BC%8F%E9%94%81%E5%92%8C%E5%90%8C%E6%AD%A5%E5%99%A8</p>
     */
    public static void buyWithDistributedLock() {
        List<Thread> threadList = new ArrayList<>();
        RedissonClient redissonClient = RedissonUtil.getClient("redis://127.0.0.1:6379");
        RLock distributedLock = redissonClient.getLock("amountOfGoods");

        for (int i = 1000; i > 0; i--) {
            threadList.add(new MyThreadSafety(distributedLock));
        }

        threadList.forEach(thread -> thread.start());
        threadList.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        redissonClient.shutdown();
    }

    private static class MyThread extends Thread {

        @Override
        public void run() {

            // 模拟业务操作
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 消费一件商品，多线程环境中线程不安全
            System.out.println("amount of goods remaining:" + amountOfGoods--);
        }
    }

    private static class MyThreadSafety extends Thread {

        /**
         * Redisson实现的分布式锁
         */
        RLock distributedLock;

        public MyThreadSafety(RLock distributedLock) {
            this.distributedLock = distributedLock;
        }

        @Override
        public void run() {

            // 模拟业务操作
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 消费一件商品，使用分布式锁，保证线程安全
            try {
                boolean locked = distributedLock.tryLock(5, 5, TimeUnit.SECONDS);
                if (locked) {
                    System.out.println("amount of goods remaining:" + amountOfGoods--);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                distributedLock.unlock();
            }
        }
    }


}
