package com.vieira.rest.restsample.repository;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;

import com.vieira.rest.restsample.repository.model.Customer;

public class CustomerEventListener
		extends
			AbstractMongoEventListener<Customer> {

	@Override
	public void onBeforeConvert(BeforeConvertEvent<Customer> event) {

		Customer customer = event.getSource();

		customer.setCreateDate(customer.getCreateDate() == null
				? new Date()
				: customer.getCreateDate());
		customer.setUpdateDate(customer.getUpdateDate() == null
				? customer.getCreateDate()
				: new Date());

	}

	@Override
	public void onBeforeSave(BeforeSaveEvent<Customer> event) {
		super.onBeforeSave(event);
	}
}
