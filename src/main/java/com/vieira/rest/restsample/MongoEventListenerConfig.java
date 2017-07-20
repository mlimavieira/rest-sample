package com.vieira.rest.restsample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vieira.rest.restsample.repository.CustomerEventListener;

@Configuration
public class MongoEventListenerConfig {

	@Bean
	public CustomerEventListener findandUpdateMongoEventListner() {
		return new CustomerEventListener();
	}
}
