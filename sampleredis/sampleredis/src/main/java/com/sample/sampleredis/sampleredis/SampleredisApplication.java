package com.sample.sampleredis.sampleredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SampleredisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleredisApplication.class, args);
	}

}
