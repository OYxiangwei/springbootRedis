package com.test.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Component
@SuppressWarnings("all")

public class RedisUtil {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //将字符串值 value 关联到 key 。
    public void set(String key , String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }
    // 返回 key 所关联的字符串值
    public String get(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
    //获取键过期时间
    public long getttl(String key , TimeUnit timeUnit){
        return stringRedisTemplate.getExpire(key,timeUnit);
    }
    //设置键过期时间
    public boolean expire(String key,long timeout,TimeUnit timeUnit){
        return stringRedisTemplate.expire(key, timeout, timeUnit);
    }
    //获取旧值并且更新值
    public String getSet(String key, String value){
        return stringRedisTemplate.opsForValue().getAndSet(key, value);
    }
    //删除
    public boolean delete(String key){
        return stringRedisTemplate.delete(key);
    }
    //Hset  将哈希表 key 中的域 field 的值设为 value
    public void hset(String key,String field ,Object value){
        stringRedisTemplate.opsForHash().put(key,field,value);
    }
    //Hget 返回哈希表 key 中给定域 field 的值。
    public String hget(String key, String field){
        return (String) stringRedisTemplate.opsForHash().get(key,field);
    }
}
