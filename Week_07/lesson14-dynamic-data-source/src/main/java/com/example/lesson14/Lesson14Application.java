package com.example.lesson14;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan({"com.example.lesson14.mapper"})
public class Lesson14Application {

	public static void main(String[] args) {
		SpringApplication.run(Lesson14Application.class, args);
	}

}
