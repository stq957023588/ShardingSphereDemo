package com.fool.shardingspheredemo.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName student
 */
@Data
public class Student implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    private static final long serialVersionUID = 1L;
}