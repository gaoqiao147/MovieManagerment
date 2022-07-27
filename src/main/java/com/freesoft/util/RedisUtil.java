package com.freesoft.util;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author zhouwei
 */
public class RedisUtil {
    /**
     *  创建一个jedis的线程池
     */
    public static JedisPool jedisPool;

    public static JedisPool open(String host, int port){
        if(jedisPool == null){
            //设置线程池的参数
            JedisPoolConfig config = new JedisPoolConfig();
            //设置最大线程数量
            config.setMaxTotal(100);
            //设置空闲数
            config.setMaxIdle(2);
            //设置检查项为true，避免为null的情况
            config.setTestOnBorrow(true);
            //创建JedisPool
            jedisPool = new JedisPool(config,host,port,6000,"root");
        }
        return jedisPool;
    }
    /**
     * 关闭线程池
     */
    public static JedisPool close(){
        if(jedisPool != null){
            jedisPool.close();
        }
        return jedisPool;
    }
}
