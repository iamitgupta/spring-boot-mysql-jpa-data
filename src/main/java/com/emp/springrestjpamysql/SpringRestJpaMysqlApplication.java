package com.emp.springrestjpamysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.emp.springrestjpamysql.repo")
@SpringBootApplication
public class SpringRestJpaMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestJpaMysqlApplication.class, args);
	}
	
	
	

}
