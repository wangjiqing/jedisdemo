package com.sakura.other.pipline;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.Date;

public class PiplineDemo {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.177.129", 6382);
        /* 直接操作redis */
        long start1 = new Date().getTime();
        for (int i = 0; i < 10000; i++) {
            jedis.hset("hashkey:" + i, "field" + i, "value" + i);
        }
        long end1 = new Date().getTime();
        System.out.println(end1 - start1);  // 3758

        /* 使用pipline操作redis */
        long start2 = new Date().getTime();
        for (int i = 0; i < 100; i++) {
            Pipeline pipeline = jedis.pipelined();
            for (int j = 0; j < (i + 1) * 100; j++) {
                pipeline.hset("hashkey:" + j, "field" + j, "value" + j);
            }
            pipeline.syncAndReturnAll();
        }
        long end2 = new Date().getTime();
        System.out.println(end2 - start2);  // 860
    }
}
