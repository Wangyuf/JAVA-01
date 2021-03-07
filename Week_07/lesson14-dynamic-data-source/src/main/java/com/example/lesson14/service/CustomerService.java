package com.example.lesson14.service;

import com.example.lesson14.annotation.DataSource;
import com.example.lesson14.mapper.CustomerMapper;
import com.example.lesson14.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: lesson14 CustomerService.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 17:28
 */
@Service
public class CustomerService {


    @Autowired
    CustomerMapper customerMapper;

    /**
     * 添加
     *
     * 使用注解默认将数据插入到master
     */
    @DataSource
    public void addCustomer() {
        customerMapper.addCustomer();
    }

    /**
     * 查询
     * @return
     *
     * 使用注解指定到slave查询 没有注解则随机一个数据源
     */
    @DataSource("slave")
    public Customer getCustomer() {
        Customer customer = customerMapper.getCustomer();
        System.out.println("getCustomer ===> "+customer);
        return customer;
    }
}
