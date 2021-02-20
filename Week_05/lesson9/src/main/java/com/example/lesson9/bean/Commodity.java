package com.example.lesson9.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @program: lesson9 Commodity.java
 * @description:
 * @author: cc
 * @create: 2021-02-21 02:47
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commodity {

    private Long id;
    private BigDecimal amount;
    private BigDecimal price;

}