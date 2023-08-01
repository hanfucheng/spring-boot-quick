package com.quick.redis.controller;

import com.alibaba.fastjson.JSONObject;
import com.quick.redis.entity.Company;
import com.quick.redis.service.CompanyService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ApiController {

    @Resource
    private CompanyService companyService;

    //http://127.0.0.1//isCompany/hfc2
    @RequestMapping(value = "/addOne/{key}", method = RequestMethod.GET)
    public Integer addOne(@PathVariable("key") String key) {
        return companyService.addOne(key);

    }

    /**
     * http://127.0.0.1/add
     * 随机添加<=10000 的键值对
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Integer isCompamy() {
        return companyService.add();
    }

    @RequestMapping(value = "/delAll", method = RequestMethod.GET)
    public String del() {
        return companyService.delAll();
    }

    @RequestMapping(value = "/delByKey/{key}", method = RequestMethod.GET)
    public String delByKey(@PathVariable("key") String key) {
        return companyService.delByKey(key);
    }


    @RequestMapping(value = "/string/set", method = RequestMethod.GET)
    public Integer set() {
        String key = "string2";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("raw_value", "娃哈哈(北京)");
        jsonObject.put("clean_value", "娃哈哈(北京)有限公司");
        jsonObject.put("isLabel", 1);
        companyService.set(key,jsonObject.toString());

        return 1;
    }

    @RequestMapping(value = "/string/get", method = RequestMethod.GET)
    public String get() {
        return companyService.get("string2");
    }

    @RequestMapping(value = "/saveCompany/{key}", method = RequestMethod.GET)
    public String saveCompany(@PathVariable("key") String key) {
        Company company = new Company("xx公司", "公益性质");

        return companyService.saveCompany(key,company);
    }
}
