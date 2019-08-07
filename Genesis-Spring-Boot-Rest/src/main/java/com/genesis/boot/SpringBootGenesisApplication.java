package com.genesis.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.genesis.controllers", "com.genesis.data" })
public class SpringBootGenesisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGenesisApplication.class, args);
	}

}
