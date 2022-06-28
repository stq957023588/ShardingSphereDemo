package com.fool.shardingspheredemo.mappers;

import com.fool.shardingspheredemo.domain.User;
import org.springframework.stereotype.Repository;

/**
 * @Entity com.fool.shardingspheredemo.domain.User
 */
@Repository
public interface UserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}




