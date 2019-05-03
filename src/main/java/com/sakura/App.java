package com.sakura;

import redis.clients.jedis.Jedis;

public class App {
    public static void main(String[] args) {
        // 生成一个Jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("192.168.177.129", 6382);
        // jedis执行set操作
        jedis.set("hello", "world");
        // jedis执行get操作
        String hello = jedis.get("hello");
        System.out.println(hello);
    }
}
