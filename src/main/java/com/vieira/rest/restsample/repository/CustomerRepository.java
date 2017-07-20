package com.vieira.rest.restsample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.vieira.rest.restsample.repository.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {

	List<Customer> findByNameContaining(String name);
	
}
