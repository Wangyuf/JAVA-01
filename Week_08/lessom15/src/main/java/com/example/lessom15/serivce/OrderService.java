package com.example.lessom15.serivce;

import com.example.lessom15.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: lessom15 OrderService.java
 * @description:
 * @author: cc
 * @create: 2021-03-14 00:25
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository coffeeRepository;
    public void getOrder(){
        coffeeRepository.findAll();
    }
}
