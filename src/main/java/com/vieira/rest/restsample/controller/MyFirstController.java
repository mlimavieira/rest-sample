package com.vieira.rest.restsample.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vieira.rest.restsample.dto.CustomerDto;

@RestController
@RequestMapping("/v1")
public class MyFirstController {

	
	@ResponseBody
	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		return "Hello World!!";
	}
	
	@ResponseBody
	@RequestMapping(value="/greetings", method=RequestMethod.GET)
	public String hello(@RequestParam(name="name") String name) {
		return "Hello " + name;
	}
}
