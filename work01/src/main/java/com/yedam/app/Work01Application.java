package com.yedam.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.yedam.app.**.mapper" ) //mybatis
public class Work01Application {

	public static void main(String[] args) {
		SpringApplication.run(Work01Application.class, args);
	}

}
