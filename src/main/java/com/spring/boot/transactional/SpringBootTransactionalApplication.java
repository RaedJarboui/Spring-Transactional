package com.spring.boot.transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringBootTransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTransactionalApplication.class, args);
	}

}
