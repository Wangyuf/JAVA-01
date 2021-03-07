package com.example.lesson14;

import com.example.lesson14.model.Customer;
import com.example.lesson14.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson14ApplicationTests {

	@Autowired
	CustomerService customerService;

	@Test
	void contextLoads() {
		customerService.addCustomer();
		customerService.getCustomer();
	}
}
