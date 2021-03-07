package com.example.lesson14.model;

import lombok.Data;

import java.util.Date;

/**
 * @program: lesson14 Customer.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 17:28
 */
@Data
public class Customer {

    public Long id;

    public String account;

    public String password;

    public String mobile;

    public String name;

    private Date createdTime;

    public Date modifiedTime;
}
