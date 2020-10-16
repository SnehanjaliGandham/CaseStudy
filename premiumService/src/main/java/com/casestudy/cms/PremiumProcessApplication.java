package com.casestudy.cms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This is the main class to perform premium and transaction functionalities
 * 
 * @author javacloudmc427
 *
 */
/**
 * @author javacloudmc427
 *
 */
@SpringBootApplication
 @EnableEurekaClient
@EnableSwagger2
public class PremiumProcessApplication {

	public static void main(String[] args) {
		SpringApplication.run(PremiumProcessApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	

}
