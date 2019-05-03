package com.sakura.basic.hash;

import redis.clients.jedis.Jedis;

import java.util.Map;

public class HashDemo {
    public static void main(String[] args) {
        // 生成一个Jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("192.168.177.129", 6382);
        jedis.hset("myhash", "f1", "v1");
        jedis.hset("myhash", "f2", "v2");
        // 输出结果： {f1=v1, f2=v2}
        Map<String, String> map = jedis.hgetAll("myhash");
        System.out.println(map);
    }
}
