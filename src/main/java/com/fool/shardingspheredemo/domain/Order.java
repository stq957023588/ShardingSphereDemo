package com.fool.shardingspheredemo.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author fool
 * @date 2022/4/18 16:58
 */
@Data
public class Order {

    private Long id;

    private String number;

    private BigDecimal totalPrice;

    private Integer state;

    private Date createTime;
}
