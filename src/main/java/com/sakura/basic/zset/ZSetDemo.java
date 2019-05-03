package com.sakura.basic.zset;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

import java.util.Set;

public class ZSetDemo {
    public static void main(String[] args) {
        // 生成一个Jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("192.168.177.129", 6382);
        jedis.zadd("myzset", 99, "tom");
        jedis.zadd("myzset", 66, "peter");
        jedis.zadd("myzset", 33, "james");
        // 输出结果：[[[106, 97, 109, 101, 115],33.0], [[112, 101, 116, 101, 114],66.0], [[116, 111, 109],99.0]]
        Set<Tuple> myzset = jedis.zrangeWithScores("myzset", 0, -1);
        System.out.println(myzset);
    }
}
