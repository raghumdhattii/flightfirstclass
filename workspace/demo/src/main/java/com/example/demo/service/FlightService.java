package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.flight.Flight;
@Service
public interface FlightService {
	
	Flight saveFlight(Flight f);
	Flight updateFlight(Flight f);
	Flight getFlightById(int id);
	List<Flight>getFlight();
	void deleteFlight(int id);

}
