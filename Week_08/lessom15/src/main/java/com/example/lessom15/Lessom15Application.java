package com.example.lessom15;

import com.example.lessom15.model.OrderEntity;
import com.example.lessom15.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories
@Slf4j
public class Lessom15Application implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(Lessom15Application.class, args);
	}

	@Autowired
	private OrderRepository repository;

	@Override
	public void run(String... args) throws Exception {
//		INSERT INTO `geek_order` (`id`, `shop_id`, `customer_id`, `total_price`, `remark`) VALUES (5, 10, 10, 1, "ds0 order0");

		// 新增
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(5L);
		orderEntity.setCustomerId(10L);
		orderEntity.setShopId(10L);
		orderEntity.setTotalPrice(1L);
		orderEntity.setRemark("ds0 order0");
//		repository.save(orderEntity);

		// 修改
		orderEntity = new OrderEntity();
		orderEntity.setId(5L);
		orderEntity.setTotalPrice(1L);
		orderEntity.setRemark("ds0 order0 update");
		repository.saveAndFlush(orderEntity);

		// 查询
//		repository.getOne(5L);

		// 删除
//		repository.deleteById(5L);

	}
}
