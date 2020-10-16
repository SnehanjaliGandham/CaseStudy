package com.cms.claimbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ClaimProcessBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClaimProcessBatchApplication.class, args);
	}

}
