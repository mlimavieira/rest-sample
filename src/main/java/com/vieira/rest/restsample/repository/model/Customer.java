package com.vieira.rest.restsample.repository.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Customer {

	@Id
	private String id;

	private String name;
	private String surname;

	private Date createDate;
	private Date updateDate;

	@Version
	private Long version;

}
