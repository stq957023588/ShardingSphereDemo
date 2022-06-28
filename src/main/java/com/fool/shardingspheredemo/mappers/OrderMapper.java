package com.fool.shardingspheredemo.mappers;

import com.fool.shardingspheredemo.domain.Order;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author fool
 * @date 2022/4/18 16:58
 */
@Repository
public interface OrderMapper {

    Order selectByPrimaryKey(@Param("id") Long id);

    List<Order> selectByNumbers(@Param("numbers")List<String> numbers);

    List<Order> selectAll();

    int insert(Order order);

    Order selectById(@Param("id") Integer id);
}
