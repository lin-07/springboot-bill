package com.lq.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement //开启注解事物的支持
@SpringBootApplication
public class Demo91Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo91Application.class, args);
	}

}
