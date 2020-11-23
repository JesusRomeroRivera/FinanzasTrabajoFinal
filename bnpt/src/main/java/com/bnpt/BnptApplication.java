package com.bnpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BnptApplication {

	public static void main(String[] args) {
		SpringApplication.run(BnptApplication.class, args);
	}

}
