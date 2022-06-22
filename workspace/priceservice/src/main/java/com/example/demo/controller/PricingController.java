package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PricingController {
	
	@GetMapping("/price")
	public Double Pricing() {
		return 1000.0;
		}

}
