package com.app.libraryapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class LibraryApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApiGatewayApplication.class, args);
	}

}
