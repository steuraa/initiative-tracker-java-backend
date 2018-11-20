package com.steuraa.inittrackerjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class InittrackerjavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InittrackerjavaApplication.class, args);
	}
}
