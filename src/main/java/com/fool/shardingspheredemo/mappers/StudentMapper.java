package com.fool.shardingspheredemo.mappers;

import com.fool.shardingspheredemo.domain.Student;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.fool.shardingspheredemo.domain.Student
 */
@Repository
public interface StudentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);


}




