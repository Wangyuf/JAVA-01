package com.example.lesson14sharding.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: lesson14 Order.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 17:28
 */
@Data
public class Order {

    public Long id;

    public Long customerId;

    public BigDecimal totalPrice;

    private Date createdTime;

    public Date modifiedTime;
}
