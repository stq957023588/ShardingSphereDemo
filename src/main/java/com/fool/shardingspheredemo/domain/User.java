package com.fool.shardingspheredemo.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName user_00
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;
}