package com.fool.shardingspheredemo.runners;

import com.fool.shardingspheredemo.algorithm.keygen.RedisKeyGenerateAlgorithm;
import org.apache.shardingsphere.sharding.spi.KeyGenerateAlgorithm;
import org.apache.shardingsphere.spi.ShardingSphereServiceLoader;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author fool
 * @date 2022/4/22 9:14
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Collection<KeyGenerateAlgorithm> keyGenerateAlgorithms = ShardingSphereServiceLoader.getSingletonServiceInstances(KeyGenerateAlgorithm.class);
        keyGenerateAlgorithms.add(new RedisKeyGenerateAlgorithm());
    }
}
