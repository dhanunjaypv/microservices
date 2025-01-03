package com.sailotech.registryAndDiscoverService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegistryAndDiscoverServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryAndDiscoverServiceApplication.class, args);
	}

}
