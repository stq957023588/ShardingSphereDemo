package com.fool.shardingspheredemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author fool
 * @date 2022/4/22 9:28
 */
@Configuration
public class RedisConfig {

    @Bean("stringLongRedisTemplate")
    public RedisTemplate<String ,Long> stringLongRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<String, Long> stringLongRedisTemplate = new RedisTemplate<>();
        stringLongRedisTemplate.setConnectionFactory(redisConnectionFactory);
        return stringLongRedisTemplate;
    }

}
