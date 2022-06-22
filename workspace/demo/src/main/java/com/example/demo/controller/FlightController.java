package com.example.demo.controller;


import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.flight.Flight;
import com.example.demo.service.FlightService;

@RestController
public class FlightController {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/flight")
	public String helloWorld() {
		return "Hello word method";
	}
	
	@PostMapping("/addflight")
	public Integer createFlight(@Valid @RequestBody Flight f) {
		Flight f1= flightService.saveFlight(f);
		return f1.getId();
	}
	
	@PutMapping("/updateflight")
	public Integer modifyFlight(@RequestBody Flight f) {
		Flight f1= flightService.updateFlight(f);
		return f1.getId();
	}
	
	@GetMapping("/getFlightPrice")
	public Double getFlightPrice() {
		RestTemplate temp= new RestTemplate();
		return temp.getForObject("http://localhost:8082/price", Double.class);
		
	}
	
	@DeleteMapping("/flight/{id}")
	public void deleteFlight(@PathVariable int id) {
		
		flightService.deleteFlight(id);
		
	}
		//error and exception handling
		@ResponseStatus(code = HttpStatus.BAD_REQUEST)
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public Map<String, String>handleException(MethodArgumentNotValidException exception){
			Map<String, String>message= new HashMap<>();
			exception.getAllErrors().forEach(error ->{
			String fieldName = ((FieldError)error).getField();
				String errormessage = ((FieldError)error).getDefaultMessage();
				message.put(fieldName, errormessage);
			});
			return message;
		}
		
	}




