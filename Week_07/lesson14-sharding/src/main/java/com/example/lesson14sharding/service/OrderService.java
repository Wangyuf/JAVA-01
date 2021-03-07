package com.example.lesson14sharding.service;

import com.example.lesson14sharding.mapper.OrderMapper;
import com.example.lesson14sharding.model.Order;
import org.apache.shardingsphere.infra.hint.HintManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: lesson14 CustomerService.java
 * @description:
 * @author: cc
 * @create: 2021-03-07 17:28
 */
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    public Long createOrder() {
        //通过日志可以看出插入数据默认使用了主库ds0
        Order order = new Order();
        order.setId(1L);
        order.setCustomerId(1L);
        orderMapper.createOrder(order);
        System.out.println("createOrder ===> " + order.getId());
        return order.getId();
    }

    public Order getOrderById() {
        //通过日志可以看出查询数据轮询了配置文件中的ds1和ds2
        Order order = orderMapper.getOrderById(2L);
        System.out.println("getOrderById ===> " + order.totalPrice);
        return order;
    }

    public Order createAndGet() {
        //强制使用主库 避免写完读问题
        HintManager.getInstance().setPrimaryRouteOnly();
        Long orderId = createOrder();
        Order order = orderMapper.getOrderById(orderId);
        System.out.println("createAndGet ===> " + order.totalPrice);
        HintManager.clear();
        HintManager.getInstance().close();
        return order;
    }

    public Order getAndCreate() {
        Order order = orderMapper.getOrderById(2L);
        createOrder();
        System.out.println("getAndCreate ===> " + order.toString());
        return order;
    }
}
