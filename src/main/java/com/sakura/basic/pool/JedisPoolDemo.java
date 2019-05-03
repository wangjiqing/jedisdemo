package com.sakura.basic.pool;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisPoolDemo {
    public static void main(String[] args) {
        // 初始化Jedis连接池，通常来讲JedisPool是单例的。
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        JedisPool jedisPool = new JedisPool(poolConfig, "192.168.177.129", 6382);
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            String pong = jedis.ping();
            // 返回结果：PONG
            System.out.println(pong);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                // 归还连接池
                jedis.close();
            }
        }

    }
}
