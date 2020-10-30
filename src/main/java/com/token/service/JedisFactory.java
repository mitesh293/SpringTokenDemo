package com.token.service;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JedisFactory {
    private static JedisFactory jedisFactory;
    @Autowired
    private JedisCluster jedisCluster;
    @Autowired
    private JedisPool jedisPool;

    public static JedisFactory getJedisFactory() {
        return jedisFactory;
    }

    public static void setJedisFactory(JedisFactory jedisFactory) {
        JedisFactory.jedisFactory = jedisFactory;
    }

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }

    public static JedisFactory getInstance(String redisServer,String maxTotalConnection,String maxWaitMillis){
        if(jedisFactory == null){
            jedisFactory = new JedisFactory();
            try{
                if(redisServer != null){
                    String [] redisServerHostPorts = redisServer.split(",");
                    System.out.println("CAllled get instance.....");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return jedisFactory;
    }
}
