package com.example.ClientAuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@EnableDiscoveryClient
@SpringBootApplication
 @ComponentScan("com.example.*") 
public class EurekaClientAuthApplication {

	public static void main(String[] args) {
		System.out.println("Starting of application");
		SpringApplication.run(EurekaClientAuthApplication.class, args);
	}

}
