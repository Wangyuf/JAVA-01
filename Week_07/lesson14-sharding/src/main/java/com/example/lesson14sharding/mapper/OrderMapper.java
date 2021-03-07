package com.example.lesson14sharding.mapper;

import com.example.lesson14sharding.model.Order;
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
public interface OrderMapper {

    @Insert("insert into geek_order (id, customer_id, total_price ,created_time, modified_time) " +
            "values " +
            "(#{order.id}, #{order.customerId},10,'2021-03-07 22:00:00','2021-03-07 22:00:00')")
    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    void createOrder(@Param("order") Order order);

    @Select("select * from geek_order where id = #{id} limit 1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "customer_id", property = "customerId"),
            @Result(column = "total_price", property = "totalPrice"),
            @Result(column = "modified_time", property = "createdTime"),
            @Result(column = "modified_time", property = "modifiedTime")
    })
    Order getOrderById(@Param("id") Long id);
}
