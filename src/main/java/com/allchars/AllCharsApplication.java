package com.allchars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@EnableAutoConfiguration
public class AllCharsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AllCharsApplication.class, args);
	}

}
