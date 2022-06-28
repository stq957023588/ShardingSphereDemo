package com.fool.shardingspheredemo.mappers;

import java.util.Date;

import com.fool.shardingspheredemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fool
 * @date 2022/5/11 11:31
 */
@SpringBootTest
class UserMapperTest {


    @Autowired
    private UserMapper userMapper;

    @Test
    void enTest() {
        User user = new User();
        user.setUsername("fool");
        user.setPassword("1234");

        userMapper.insertSelective(user);

    }

    @Test
    void selectTest() {

        User user = userMapper.selectByPrimaryKey(1L);
        System.out.println(user);

    }
}
