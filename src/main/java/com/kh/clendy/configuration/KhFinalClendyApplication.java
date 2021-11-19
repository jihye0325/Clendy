package com.kh.clendy.configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.kh.clendy")
public class KhFinalClendyApplication {

	public static void main(String[] args) {
		SpringApplication.run(KhFinalClendyApplication.class, args);
	}
}