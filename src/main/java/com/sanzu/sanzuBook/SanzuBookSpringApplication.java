package com.sanzu.sanzuBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
//@MapperScan("com.sanzu.sanzuBook.dao.mapper")
public class SanzuBookSpringApplication {

	public static void main(String[] args) {

		SpringApplication.run(SanzuBookSpringApplication.class, args);
	}

}
