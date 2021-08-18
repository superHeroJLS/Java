/*
 * Copyright (c) 2015—2030 GantSoftware.Co.Ltd. All rights reserved.
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * is not allowed to be distributed or copied without the license from
 * GantSoftware.Co.Ltd. Please contact the company for more information.
 */
package com.jiangls;

import com.jiangls.util.JedisUtil;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author jiangls
 * @Date 2021/8/17
 */
public class JedisTest {

    public static void main(String[] args) {
//        set();

//        setWithJedisCluster();

        setWithJedisPool();
    }

    /**
     * 通过Jedis instance添加String缓存
     */
    public static void set() {
        Jedis jedis = JedisUtil.getJedis("127.0.0.1", 6379);

        jedis.set("jediskey", "jedisval", new SetParams().ex(60L));

        jedis.close();
    }

    /**
     * 通过Jedis Cluster instance添加缓存
     */
    public static void setWithJedisCluster() {
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(new HostAndPort("127.0.0.1", 6379));
        JedisCluster jedisCluster = JedisUtil.getJedisCluster(hostAndPortSet);

        jedisCluster.set("jedisClusterKey", "jedisClusterValue", new SetParams().ex(60L));

    }

    /**
     * 通过Jedis Pool获取Jedis instance
     */
    public static void setWithJedisPool() {
        JedisPool pool = JedisUtil.getJedisPool("127.0.0.1", 6379);
        Jedis jedis = pool.getResource();
        try {
            jedis.set("jedisPoolKey", "jedisPoolVal", new SetParams().ex(60L));
        } finally {
            pool.returnResource(jedis);
            JedisUtil.closeJedisPool(pool);
        }
    }


}
