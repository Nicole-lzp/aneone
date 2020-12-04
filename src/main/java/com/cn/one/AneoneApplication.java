package com.cn.one;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.cn.one.mapper")
public class AneoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(AneoneApplication.class, args);
	}

}
