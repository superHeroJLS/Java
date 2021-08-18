package com.jiangls.util;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 * @Author jiangls
 * @Date 2021/8/17
 * <p>参考：https://github.com/redisson/redisson/wiki</p>
 */
public class RedissonUtil {

    /**
     * 连接单个节点的Redis Server
     * @param address
     * @return
     */
    public static RedissonClient getClient(String address) {
        Config config = new Config();
        config.useSingleServer()
                // use "redis://" for connection
                .setAddress(address);

        return Redisson.create(config);

    }

    /**
     * 关闭Redisson instance
     * @param client
     */
    public static void shutdown(RedissonClient client) {
        if (null != client && client.isShutdown() && client.isShuttingDown()) {
            client.shutdown();
        }
    }
}
