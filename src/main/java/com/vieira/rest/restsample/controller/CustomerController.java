package com.vieira.rest.restsample.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vieira.rest.restsample.dto.CustomerDto;
import com.vieira.rest.restsample.exeption.NotFoundException;
import com.vieira.rest.restsample.exeption.ValidationException;
import com.vieira.rest.restsample.repository.CustomerRepository;
import com.vieira.rest.restsample.repository.model.Customer;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<CustomerDto> list(@RequestParam(value="page", required = false, defaultValue="0") Integer page, 
								  @RequestParam(value="size",  required = false, defaultValue="10") Integer size) {

		Pageable pageable = new PageRequest(page, size);
		Page<Customer> findAll = customerRepository.findAll(pageable);

		return findAll.getContent().stream()
				.map(from -> this.dozerBeanMapper.map(from, CustomerDto.class))
				.collect(Collectors.toList());
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public CustomerDto save(
			@PathVariable(name = "id", required = true) String id,
			@RequestBody CustomerDto dto) {

		Customer findOne = customerRepository.findOne(id);
		
		if(findOne == null) {
			throw new NotFoundException("Customer not found", "Customer not found for the id " + id);
		}
		
		findOne.setName(dto.getName());
		findOne.setSurname(dto.getSurname());
		dto.setId(UUID.randomUUID().toString());

		customerRepository.save(findOne);
		
		return dto;
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public CustomerDto store(@RequestBody(required=true) CustomerDto dto) {
		
		if(StringUtils.isNotEmpty(dto.getId())) {
			throw new ValidationException("Validation error", "Id must be null for this operation");
		}
		
		Customer customer = dozerBeanMapper.map(dto, Customer.class);
		
		customerRepository.save(customer);
		return dto;
	}

}
