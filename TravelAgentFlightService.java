package com.smoothstack.agentAPI.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.agentAPI.dao.TravelAgentFlightDAO;
import com.smoothstack.agentAPI.entity.Flight;

@Service
public class TravelAgentFlightService {

	@Autowired
	private TravelAgentFlightDAO flightDAO;
	
	@Transactional
	public List<Flight> getAllFlights(int size) {
		Pageable limit = PageRequest.of(0,size);
		return flightDAO.findAll(limit).getContent();		
	}

	@Transactional
	public ResponseEntity<Flight> getFlightById(Integer id) {
		Optional<Flight> flight = flightDAO.findById(id);		
				
		return !flight.isPresent() ? new ResponseEntity<Flight>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<Flight>(flight.get(), HttpStatus.OK);						 
	}
}
