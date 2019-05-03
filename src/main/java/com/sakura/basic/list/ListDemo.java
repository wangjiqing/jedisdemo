package com.sakura.basic.list;

import redis.clients.jedis.Jedis;

import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // 生成一个Jedis对象，这个对象负责和指定Redis节点进行通信
        Jedis jedis = new Jedis("192.168.177.129", 6382);
        jedis.rpush("mylist", "1", "2", "3");
        // 输出结果： [1, 2, 3]
        List<String> mylist = jedis.lrange("mylist", 0, -1);
        System.out.println(mylist);
    }
}
