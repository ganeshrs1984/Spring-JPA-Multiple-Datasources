package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class DemoController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String demo(){
		return "Hello";
	}
	
}
