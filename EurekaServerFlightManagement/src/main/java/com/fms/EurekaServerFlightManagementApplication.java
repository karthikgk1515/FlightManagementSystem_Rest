package com.fms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerFlightManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerFlightManagementApplication.class, args);
	}

}
