package com.paytm.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AutoConfiguration
public class PaytmIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaytmIntegrationApplication.class, args);
	}

}
