package com.quick.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created with IDEA
 * User: hfc
 * Data: 20211005
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company implements Serializable {

    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 标签
     */
    private String label;

}
