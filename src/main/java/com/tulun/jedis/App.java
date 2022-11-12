package com.tulun.jedis;

import redis.clients.jedis.Jedis;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Jedis jedis = new Jedis("127.0.0.1", 6379);//本地主机 及  默认端口
        //set操作
        jedis.set("tulun","java");
        //get获取
        String value = jedis.get("tulun");
        System.out.println(value);

//        字符串
        jedis.set("hello","value");
        System.out.println(jedis.get("hello"));

//        hash（是（key-value的）map 的集合）
        jedis.hset("myhash","k1","v1");
        jedis.hset("myhash","k2","v2");
        System.out.println(jedis.hgetAll("myhash"));

//        list
        jedis.rpush("mylist","l1");
        jedis.rpush("mylist","l2");
        jedis.lpush("mylist","left");
        System.out.println(jedis.lrange("mylist",0,-1));

//        set
        jedis.sadd("myset","a");
        jedis.sadd("myset","b");
        jedis.sadd("myset","c");
        System.out.println(jedis.smembers("myset"));


//        zset（关联一个分数）
        jedis.zadd("myzset",1,"1");
        jedis.zadd("myzset",4,"10");
        jedis.zadd("myzset",3,"13");
        Iterator<String> myzset = jedis.zrangeByScore("myzset", 1, 4).iterator();
        while (myzset.hasNext()) {
            System.out.println(myzset.next());
        }
    }
}
