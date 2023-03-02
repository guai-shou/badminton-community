package com.cloud.badminton.framework.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/2 23:11
 */
@Component
public class RedisUtils {
    private RedisUtils() {}

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    /*设置过期时间 key*/
    public boolean expire(final String key, final Long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    public boolean expire(String key, Long timeout, TimeUnit unit) {
        final Boolean ret = redisTemplate.expire(key, timeout, unit);
        return ret != null && ret;
    }

    /*删除单个 key*/
    public boolean delKey(final String key) {
        final Boolean ret = redisTemplate.delete(key);
        return ret != null && ret;
    }

    /*删除多个 key*/
    public long delKeys(final Collection<String> keys) {
        final Long ret = redisTemplate.delete(keys);
        return ret == null ? 0 : ret;
    }

    /*设置 key 和 value*/
    public void setValue(final String key, final Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /*设置有效 key 和 value 有效单位: 分钟*/
    public void setValueExpire(final String key, final Object value,final long timeout) {
        redisTemplate.opsForValue().set(key, value,timeout,TimeUnit.MINUTES);
    }

    /*获取 key 中对应的值*/
    public Object getValue(final String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /*在list存入数据*/
    public  long listPush(final String key, final Object value) {
        Long count = redisTemplate.opsForList().rightPush(key, value);
        return count == null ? 0 : count;
    }

    /*往List中存入多个数据*/
    public  long listPushAll(final String key, final Collection<Object> values) {
        Long count = redisTemplate.opsForList().rightPushAll(key, values);
        return count == null ? 0 : count;
    }

    /*从List中获取begin到end之间的元素*/
    public List<Object> listGet(final String key, final int start, final int end) {
        return redisTemplate.opsForList().range(key, start, end);
    }

    /*从List中获取全部元素*/
    public List<Object> listGetAllAndRemove(final String key) {
        final ListOperations<String, Object> list = redisTemplate.opsForList();
        final Long size = list.size(key);
        if (size == null)
            return new LinkedList<>();
        return list.leftPop(key, size);
    }


    /**
     * 确定哈希hashKey是否存在
     *
     * @param key 键
     * @param hkey hash键
     * @return true=存在；false=不存在
     */
    public  boolean hasHashKey(final String key,String hkey) {
        Boolean ret = redisTemplate.opsForHash().hasKey(key,hkey);
        return ret != null && ret;
    }

    /**
     * 往Hash中存入数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @param value 值
     */
    public  void hashPut(final String key, final Long hKey, final Object value) {
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * 往Hash中存入多个数据
     *
     * @param key Redis键
     * @param values Hash键值对
     */
    public  void hashPutAll(final String key, final Map<Long, Object> values) {
        redisTemplate.opsForHash().putAll(key, values);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @param hKey Hash键
     * @return Hash中的对象
     */
    public  Object hashGet(final String key, final Long hKey) {
        return redisTemplate.opsForHash().get(key, hKey);
    }

    /**
     * 获取Hash中的数据
     *
     * @param key Redis键
     * @return Hash对象
     */
    public Map<Object, Object> hashGetAll(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

}
