package com.fool.shardingspheredemo.mappers;

import com.fool.shardingspheredemo.domain.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Entity com.fool.shardingspheredemo.domain.OrderDetail
 */
@Repository
public interface OrderDetailMapper {

    int deleteByPrimaryKey(Long id);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);


    List<OrderDetail> selectByOrderIdList(@Param("orderIds") List<Long> orderIds);

    List<OrderDetail> selectByOrderId(@Param("orderId") Long orderId);
}




