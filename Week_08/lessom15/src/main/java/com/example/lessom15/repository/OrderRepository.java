package com.example.lessom15.repository;

import com.example.lessom15.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

/**
 * @program: lessom15 OrderRepository.java
 * @description:
 * @author: cc
 * @create: 2021-03-13 23:51
 */
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {


}
