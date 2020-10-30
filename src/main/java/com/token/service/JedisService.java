package com.token.service;

import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisCluster;

@Component
public class JedisService {
    public void deleteValueFromSet(String tableName,String column,String columnValue,String member){
        try {
            JedisCluster jedis = getJedisConnection();
            System.out.println(jedis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JedisCluster getJedisConnection() {
        JedisCluster jedis = JedisFactory.getInstance("http://localhost:8080,22","50","20").getJedisCluster();
        return jedis;
    }
}
