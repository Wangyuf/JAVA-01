package com.example.lesson14sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.lesson14.mapper"})
public class Lesson14ShardingApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson14ShardingApplication.class, args);
	}

}
