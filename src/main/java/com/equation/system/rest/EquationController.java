package com.equation.system.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EquationController {
	
	@RequestMapping
	public String getEquationInfo() {
		return "Borjius training App - :-)";
	}

}
