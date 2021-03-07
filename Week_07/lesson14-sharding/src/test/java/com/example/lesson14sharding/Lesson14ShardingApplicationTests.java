package com.example.lesson14sharding;

import com.example.lesson14sharding.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson14ShardingApplicationTests {

	@Autowired
	OrderService orderService;

	@Test
	void contextLoads() {
		// 主库创建
		orderService.createOrder();
		//主库创建并查询
		orderService.createAndGet();
		// 从库查询 主库创建
		orderService.getAndCreate();
		// 从库读取
		orderService.getOrderById();
		// 从库读取
		orderService.getOrderById();
		// 从库读取
		orderService.getOrderById();

	}

}
