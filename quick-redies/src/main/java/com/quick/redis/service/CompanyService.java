package com.quick.redis.service;

import com.quick.redis.entity.Company;

/**
 * Created with IDEA
 * User: vector
 * Data: 2017/9/26
 * Time: 21:27
 * Description:
 */
public interface CompanyService {
    /**
     * 获取公司值
     *
     */
    Integer addOne(String key);

    Integer add();

    String delAll();

    /**
     * 根据key,清空键值对
     * @param key
     * @return
     */
    String delByKey(String key);

    void set(String key, String value);

    String get(String key);

    /**
     * 保存公司
     * @param c
     * @return
     */
     String saveCompany(String key,Company c);
}
