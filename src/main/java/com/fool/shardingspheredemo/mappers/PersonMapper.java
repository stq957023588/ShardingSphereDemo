package com.fool.shardingspheredemo.mappers;

import com.fool.shardingspheredemo.domain.Person;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.fool.shardingspheredemo.domain.Person
 */
@Repository
public interface PersonMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Person record);

    int insertSelective(Person record);

    Person selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Person record);

    int updateByPrimaryKey(Person record);



}




