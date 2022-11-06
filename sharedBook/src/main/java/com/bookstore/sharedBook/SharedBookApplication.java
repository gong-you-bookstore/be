package com.bookstore.sharedBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SharedBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedBookApplication.class, args);
	}

}
