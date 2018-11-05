package com.sxdxswxy.drugsys.common.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * redis配置
 *
 * @author Justdwiwt
 */
@Configuration
public class RedisConfiguration {

    // 从配置文件读取数据，默认null(String)
    @Value("${spring.redis.nodes:null}")
    private String nodes;
    @Value("${spring.redis.pool.max-idle:1}")
    private Integer maxIdle;
    @Value("${spring.redis.pool.min-idle:0}")
    private Integer minIdle;
    // max-active
    @Value("${spring.redis.pool.max-active:1}")
    private Integer maxTotal;
    @Value("${spring.redis.pool.max-wait:1}")
    private Integer maxWait;
    @Value("${spring.redis.timeout:0}")
    private Integer timeout;

    /**
     * 获取JedisPoolConfig对象
     *
     * @return JedisPoolConfig对象
     */
    private JedisPoolConfig getConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMinIdle(minIdle);
        config.setMaxTotal(maxTotal);
        config.setMaxWaitMillis(maxWait);
        return config;
    }

    /**
     * 创建jedis分片连接池对象
     *
     * @return jedis分片连接池对象
     */
    @Bean
    public ShardedJedisPool getPool() {
        List<JedisShardInfo> infoList = new ArrayList<>();
        if (!("null".equals(nodes))) {
            String[] hostAndPorts = nodes.split(",");
            for (String node : hostAndPorts) {
                //每个node格式192.168.198.40:6379
                String[] hostAndPort = node.split(":");
                //生成一个info对象,添加到list中
                JedisShardInfo info = new JedisShardInfo(hostAndPort[0],
                        Integer.parseInt(hostAndPort[1]), timeout);
                infoList.add(info);
            }
            //用config对象和list对象生产jedis分片连接池
            return new ShardedJedisPool(getConfig(), infoList);
        }
        return null;
    }

}
