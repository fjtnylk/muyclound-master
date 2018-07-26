package com.muyclound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
//@EnableHystrix
//@EnableFeignClients
//@EnableEurekaClient
public class MuycloundProviderOmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuycloundProviderOmcApplication.class, args);
	}
}
