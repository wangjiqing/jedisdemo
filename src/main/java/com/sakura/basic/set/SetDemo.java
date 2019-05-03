package com.sakura.basic.set;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        // 生成一个Jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("192.168.177.129", 6382);
        jedis.sadd("myset", "a", "b", "a");
        // 输出结果： [b, a]
        Set<String> myset = jedis.smembers("myset");
        System.out.println(myset);
    }
}
