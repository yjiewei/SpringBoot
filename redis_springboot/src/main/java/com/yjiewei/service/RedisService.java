package com.yjiewei.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 该对象操作的是String，也可以存放实体类，只需要将实体类转换成json字符串即可
 * @author yjiewei
 * @date 2021/9/3
 */
@Service
public class RedisService {

    /**
     * 如果不用StringRedisTemplate，而使用RedisTemplate，可能存在存储乱码的情况
     * 原因是后者使用Redis默认的内部序列化器
     */
    @Resource
    public StringRedisTemplate stringRedisTemplate;

    /**
     * set redis
     * @param key
     * @param value
     */
    public void setString(String key, String value) {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set(key, value);
    }

    /**
     * get redis
     * @param key
     * @return
     */
    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * set redis : hash类型
     * hset key filed value
     * @param key
     * @param filedKey 域信息，把它看成key的属性就可以
     * @param value
     */
    public void setHash(String key, String filedKey, String value){

        HashOperations<String, Object, Object> hashOperation = stringRedisTemplate.opsForHash();
        hashOperation.put(key, filedKey, value);
    }

    /**
     * get redis : hash类型
     * hget key filed
     * @param key
     * @param filedKey
     * @return
     */
    public String getHash(String key, String filedKey) {
        return (String) stringRedisTemplate.opsForHash().get(key, filedKey);
    }

    /**
     * leftPush list
     * @param key
     * @param value
     * @return
     */
    public long setList(String key, String value) {
        ListOperations<String, String> opsForList = stringRedisTemplate.opsForList();
        return opsForList.leftPush(key, value); // 从左边推入
    }

    /**
     * get list
     * @param key
     * @param start
     * @param end
     * @return
     */
    public List<String> getList(String key, long start, long end) {
        return stringRedisTemplate.opsForList().range(key, start, end);
    }
}
