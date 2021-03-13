package com.example.lessom15.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @program: lessom15 OrderEntity.java
 * @description:
 * @author: cc
 * @create: 2021-03-13 23:46
 */
@Entity
@Table(name = "geek_order")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {

    @Id
    private Long id;

    @Column(name = "shop_id", updatable = false)
    public Long shopId;

    @Column(name = "customer_id", updatable = false)
    public Long customerId;

    @Column(name = "total_price")
    public Long totalPrice;

    public String remark;
}
