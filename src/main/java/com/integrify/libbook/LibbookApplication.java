package com.integrify.libbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.integrify.libbook.bean")
public class LibbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibbookApplication.class, args);
	}

}
