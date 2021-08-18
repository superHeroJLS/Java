package com.jiangls.util;

import redis.clients.jedis.*;

import java.util.List;
import java.util.Set;

/**
 * @Author jiangls
 * @Date 2021/8/17
 * <p>源码：https://github.com/redis/jedis</p>
 * <p>文档参考：https://github.com/redis/jedis/wiki/Getting-started</p>
 */
public class JedisUtil {

    /**
     * 连接单个节点Redis Server，这种创建Jedis实例的方式在多线程环境中是不安全的。
     * @param host
     * @param port
     */
    public static Jedis getJedis(String host, int port) {
        return new Jedis(new HostAndPort(host, port));
    }

    /**
     * 创建JedisCluster实例，连接Redis Server
     * @param hostAndPorts
     * @return
     */
    public static JedisCluster getJedisCluster(Set<HostAndPort> hostAndPorts) {
        /*
            抛出异常：redis.clients.jedis.exceptions.JedisDataException: ERR This instance has cluster support disabled
            异常原因：Jedis Cluster无法连接单个节点的Redis Server
         */
        return new JedisCluster(hostAndPorts);
    }

    public static void close(Jedis jedis) {
        if (null != null) {
            jedis.close();
        }
    }

    /**
     * 在多线程编程中，JedisPool线程安全，可以通过JedisPool获取安全可靠的Jedis instance且可以避免产生一些奇怪的问题
     * JedisPool可以连接单个节点的Redis Server
     * @param host
     * @param port
     * @return
     */
    public static JedisPool getJedisPool(String host, int port) {
        return new JedisPool(new JedisPoolConfig(), host, port);
    }

    public static void closeJedisPool(JedisPool pool) {
        if (null != pool && !pool.isClosed()) {
            pool.close();
        }
    }


}
