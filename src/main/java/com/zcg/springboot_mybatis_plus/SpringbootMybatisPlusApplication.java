package com.zcg.springboot_mybatis_plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zcg.springboot_mybatis_plus.mapper")
public class SpringbootMybatisPlusApplication {
	//浏览器访问：http://localhost:8080/h2-console
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisPlusApplication.class, args);
	}

}
