package com.kn.covidtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CovidTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CovidTrackerApplication.class, args);
	}

}
