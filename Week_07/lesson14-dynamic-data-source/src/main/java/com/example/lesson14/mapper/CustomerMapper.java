package com.example.lesson14.mapper;

import com.example.lesson14.model.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @program: lesson14 CustomerMapper.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 17:27
 */
@Mapper
@Repository
public interface CustomerMapper {
    @Insert("insert into geek_customer (id, account, password, mobile, name,created_time, modified_time) values (1,'rootmaster','123456',13500000001,'wanger','2021-03-07 12:00:00','2021-03-07 12:00:00')")
    void addCustomer();

    @Select("select * from geek_customer where id = 1 limit 1")
    @Results({
            @Result(column="id", property="id"),
            @Result(column="account", property="account")
    })
    Customer getCustomer();
}
