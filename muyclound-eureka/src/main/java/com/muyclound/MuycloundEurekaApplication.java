package com.muyclound;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MuycloundEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MuycloundEurekaApplication.class, args);
	}
}
