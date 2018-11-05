package com.sxdxswxy.drugsys.common.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * redisCluster配置
 *
 * @author Justdiwiwt
 */
@Configuration
public class RedisClusterConfig {

    @Value("${spring.redis.cluster.nodes:null}")
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
     * config配置对象
     *
     * @return config对象
     */
    private GenericObjectPoolConfig getConfig() {
        GenericObjectPoolConfig config = new GenericObjectPoolConfig();
        config.setMaxIdle(maxIdle);
        config.setMaxTotal(maxTotal);
        config.setMaxWaitMillis(maxWait);
        config.setMinIdle(minIdle);
        return config;
    }

    /**
     * 创建jedisCluster对象
     *
     * @return jedisCluster对象
     */
    @Bean
    public JedisCluster getCluster() {
        Set<HostAndPort> nodeSet = new HashSet<>();
        //处理字符串
        if (!("null".equals(nodes))) {
            String[] clusterNodes = nodes.split(",");
            for (String node : clusterNodes) {
                String[] hostAndPort = node.split(":");
                nodeSet.add(new HostAndPort(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
            }
            return new JedisCluster(nodeSet, timeout, getConfig());
        }
        return null;
    }

}
