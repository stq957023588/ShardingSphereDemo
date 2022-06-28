package com.fool.shardingspheredemo.mappers;

import com.fool.shardingspheredemo.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fool
 * @date 2022/5/27 16:18
 */
@SpringBootTest
class StudentMapperTest {


    @Autowired
    private StudentMapper studentMapper;

    @Test
    void selectByPrimaryKey() {
        Student student = studentMapper.selectByPrimaryKey(1L);
        System.out.println(student);

    }
}
