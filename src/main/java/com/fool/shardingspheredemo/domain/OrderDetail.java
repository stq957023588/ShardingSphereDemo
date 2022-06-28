package com.fool.shardingspheredemo.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 *
 * @TableName order_detail_00
 */
@Data
public class OrderDetail implements Serializable {
    /**
     *
     */
    private Long id;

    /**
     *
     */
    private Long orderId;

    /**
     *
     */
    private Integer productId;

    /**
     *
     */
    private Object quantity;

    /**
     *
     */
    private BigDecimal unitPrice;

    /**
     *
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}
