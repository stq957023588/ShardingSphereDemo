package com.fool.shardingspheredemo.mappers;

import com.fool.shardingspheredemo.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fool
 * @date 2022/5/27 15:19
 */
@SpringBootTest
class PersonMapperTest {


    @Autowired
    private PersonMapper personMapper;

    @Test
    void selectByPrimaryKey() {

        Person person = personMapper.selectByPrimaryKey(1L);
        System.out.println(person);

    }
}
