package com.ust.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SwaggerController {
	
	@GetMapping("/")
	public String callSwaggerUI() {
		return "redirect:/swagger-ui.html";
	}

}
