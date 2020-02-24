package com.smoothstack.agentAPI.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.smoothstack.agentAPI.entity.TravelAgent;
import com.smoothstack.agentAPI.service.TravelAgentService;

@RestController
@RequestMapping(value = "/travelagent")
public class TravelAgentController {
	
	private final String XML = "application/xml";
	private final String JSON = "application/json";
	
	@Autowired
	private TravelAgentService agentService;	
	
	@GetMapping(value = "/{id}", produces = { XML, JSON })
	public ResponseEntity<TravelAgent> getTravelAgentById(@PathVariable Integer id) {
		return agentService.getTravelAgentById(id);								 
	}
	
	@PostMapping(value ="/new", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.CREATED)
	public TravelAgent createTravelAgent(@Valid @RequestBody TravelAgent travelAgent) {
		return agentService.createTravelAgent(travelAgent);
	}	

	@PutMapping(value ="/", produces = { XML, JSON }, consumes = { XML, JSON })
	@ResponseStatus(HttpStatus.OK)
	public TravelAgent updateTravelAgent(@Valid @RequestBody TravelAgent travelAgent) {
		return agentService.updateTravelAgent(travelAgent);
	}	

}
