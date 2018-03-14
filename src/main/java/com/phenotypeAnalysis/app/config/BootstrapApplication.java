package com.phenotypeAnalysis.app.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.phenotypeAnalysis.app")
@EntityScan("com.phenotypeAnalysis.app")
@EnableJpaRepositories("com.phenotypeAnalysis.app.repository") 
public class BootstrapApplication {
	public static void main(String[] args) { 
		SpringApplication.run(BootstrapApplication.class, args);
	}
}