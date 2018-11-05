package com.sxdxswxy.drugsys.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * redisServiceFunc
 *
 * @author Justdwiwt
 */
@Service
public class RedisService {

    @Autowired(required = false)
    private ShardedJedisPool pool;

    /**
     * 无超时注入
     *
     * @param key   key
     * @param value value
     */
    public void set(String key, String value) {
        ShardedJedis jedis = pool.getResource();
        jedis.set(key, value);
        pool.returnResource(jedis);
    }

    /**
     * 有超时注入
     *
     * @param key     key
     * @param value   value
     * @param seconds s
     */
    public void set(String key, String value, Integer seconds) {
        ShardedJedis jedis = pool.getResource();
        jedis.set(key, value);
        jedis.expire(key, seconds);
        pool.returnResource(jedis);
    }

    /**
     * 存在
     *
     * @param key key
     * @return {@code true }存在
     * <p>{@code false }不存在</p>
     */
    public Boolean exists(String key) {
        ShardedJedis jedis = pool.getResource();
        Boolean exists = jedis.exists(key);
        pool.returnResource(jedis);
        return exists;
    }

    /**
     * 取值
     *
     * @param key key
     * @return value
     */
    public String get(String key) {
        ShardedJedis jedis = pool.getResource();
        String value = jedis.get(key);
        pool.returnResource(jedis);
        return value;
    }

    /**
     * 删除key
     *
     * @param key String
     */
    public void del(String key) {
        ShardedJedis jedis = pool.getResource();
        jedis.del(key);
        pool.returnResource(jedis);
    }

}
