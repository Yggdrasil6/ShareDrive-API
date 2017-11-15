package com.yggdrasil.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.Protocol;
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private String host = Protocol.DEFAULT_HOST;
    private int port = Protocol.DEFAULT_PORT;
    private int database;

//    @Bean
//    @Profile("cmbredis")
//    public JedisCommands redisCluster() {
//        final RedisClusterFactory redisClusterFactory = new RedisClusterFactory();
//        try {
//            return redisClusterFactory.getCluster();
//        } catch (Exception e) {
//            logger.warn("Get cluster error", e);
//        }
//        return null;
//    }

    @Bean
    @ConditionalOnMissingBean(RedisTemplate.class)
    public RedisTemplate<String, Object> restTemplate() {
        return configRedisTemplate(new JedisConnectionFactory(), new RedisTemplate<>());
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDatabase(int database) {
        this.database = database;
    }

    private RedisTemplate<String, Object> configRedisTemplate(JedisConnectionFactory connectionFactory, RedisTemplate<String, Object> redisTemplate) {
        connectionFactory.setHostName(this.host);
        connectionFactory.setPort(this.port);
        connectionFactory.setDatabase(this.database);
        connectionFactory.afterPropertiesSet();

        redisTemplate.setConnectionFactory(connectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}
