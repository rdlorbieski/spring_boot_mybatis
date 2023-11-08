package com.example.statisticsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class StatisticsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatisticsDemoApplication.class, args);
	}

}
