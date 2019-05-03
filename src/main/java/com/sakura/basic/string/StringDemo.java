package com.sakura.basic.string;

import redis.clients.jedis.Jedis;

/**
 * jedis操作String
 */
public class StringDemo {
    public static void main(String[] args) {
        // 生成一个Jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("192.168.177.129", 6382);
        jedis.set("hello", "world");
        // 输出结果： world
        String hello = jedis.get("hello");
        System.out.println(hello);
        // 输出结果： 1
        Long counter = jedis.incr("counter");
        System.out.println(counter);
    }
}
