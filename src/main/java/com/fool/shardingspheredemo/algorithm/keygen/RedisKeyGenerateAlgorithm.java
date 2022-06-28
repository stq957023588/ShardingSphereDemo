package com.fool.shardingspheredemo.algorithm.keygen;

import com.fool.shardingspheredemo.utils.SpringContextUtils;
import lombok.Generated;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Properties;

/**
 * @author fool
 * @date 2022/4/21 17:04
 */
public class RedisKeyGenerateAlgorithm implements KeyGenerateAlgorithm {
    public static final String TYPE = "REDIS";
    private Properties props = new Properties();

    private RedisTemplate<String ,Long> redisTemplate;
    private String redisKey;

    /**
     *
     * @return
     */
    @Override
    public Comparable<?> generateKey() {
        return this.redisTemplate.opsForValue().increment(this.redisKey);
    }

    @Override
    public void init() {
        this.redisTemplate = SpringContextUtils.getBean(RedisTemplate.class,"stringLongRedisTemplate");
        this.redisKey = getProps().getProperty("redis-key", "redis-distributed-key");
    }

    @Override
    public String getType() {
        return TYPE;
    }


    @Override
    public Properties getProps() {
        return this.props;
    }

    @Override
    public void setProps(Properties props) {
        this.props = props;
    }

}
