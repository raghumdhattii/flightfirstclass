package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.flight.Flight;
import com.example.demo.repository.FlightRepository;
@Service
public class FlightServiceImpl implements FlightService {

	@Autowired
	FlightRepository flightRep;
	
	@Override
	public Flight saveFlight(Flight f) {
		return flightRep.save(f);
	}

	@Override
	public Flight updateFlight(Flight f) {
	Flight oldflight = flightRep.getById(f.getId());
		oldflight.setAirlineName(f.getAirlineName());
		oldflight.setFlightName(f.getFlightName());
		return flightRep.save(oldflight);
	}

	@Override
	public Flight getFlightById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Flight> getFlight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFlight(int id) {
	flightRep.deleteById(id);	

	}

}
