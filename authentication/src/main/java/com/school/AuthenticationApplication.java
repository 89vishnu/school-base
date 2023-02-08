package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication
@EnableAutoConfiguration
/**
 * Based on the dependencies that you have added.
 * @EnableAutoConfiguration of the Spring Application Context,
 * attempting to configure beans that you are likely to need.
 * Auto-configuration classes are usually applied based on your classpath
 * **/
@ComponentScan
/**
 *  @ComponentScan is used to specify the packages that we want to be scanned.
 *  @ComponentScan tells Spring to scan the current package and all of its sub-packages.
 * **/
@Configuration
/**
 * Spring Configuration annotation indicates that the class has @Bean definition methods.
 * So Spring container can process the class and generate Spring Beans to be used in the application.
 * **/
@SpringBootConfiguration
/**
 * It is a class-level annotation that is part of the Spring Boot framework.
 * It implies that a class provides Spring Boot application configuration.
 * It can be used as an alternative to Spring’s standard @Configuration annotation
 *    so that configuration can be found automatically
 * **/
public class AuthenticationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

}
