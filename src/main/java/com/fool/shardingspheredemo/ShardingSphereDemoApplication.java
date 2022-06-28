package com.fool.shardingspheredemo;

import com.fool.shardingspheredemo.algorithm.keygen.RedisKeyGenerateAlgorithm;
import org.apache.shardingsphere.spi.ShardingSphereServiceLoader;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fool.shardingspheredemo.mappers")
public class ShardingSphereDemoApplication {

    public static void main(String[] args) {
        ShardingSphereServiceLoader.register(RedisKeyGenerateAlgorithm.class);
        SpringApplication.run(ShardingSphereDemoApplication.class, args);
    }

}
