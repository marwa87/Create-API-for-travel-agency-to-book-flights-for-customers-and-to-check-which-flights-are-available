package com.smoothstack.agentAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.agentAPI.entity.Flight;
import com.smoothstack.agentAPI.service.TravelAgentFlightService;

@RestController
@RequestMapping("/travelagent")
public class TravelAgentFlightController {

	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private TravelAgentFlightService flightService;
	
	@GetMapping(value ="/flights", produces = { XML, JSON })
	public List<Flight> getAllFlights(@RequestParam(required = false, defaultValue = "100") int size) {		
		return flightService.getAllFlights(size);
	}	
	
	@GetMapping(value = "/flight/{id}", produces = { XML, JSON })
	public ResponseEntity<Flight> getFlightById(@PathVariable Integer id) {
		return flightService.getFlightById(id);								 
	}

}
