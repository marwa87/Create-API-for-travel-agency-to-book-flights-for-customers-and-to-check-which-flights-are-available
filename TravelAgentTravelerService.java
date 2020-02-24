package com.smoothstack.agentAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smoothstack.agentAPI.dao.TravelAgentTravelerDAO;
import com.smoothstack.agentAPI.entity.Traveler;

@Service
public class TravelAgentTravelerService {

	@Autowired
	private TravelAgentTravelerDAO travelDAO;

	@Transactional
	public ResponseEntity<Traveler> getTravelerById(Integer id) {
		Optional<Traveler> traveler = travelDAO.findById(id);		
				
		return !traveler.isPresent() ? new ResponseEntity<Traveler>(HttpStatus.NOT_FOUND) 
			: new ResponseEntity<Traveler>(traveler.get(), HttpStatus.OK);						 
	}	
	
	@Transactional
	public Traveler createTraveler(Traveler traveler) {
		return travelDAO.save(traveler);
	}	

	@Transactional
	public Traveler updateTraveler(Traveler traveler) {
		return travelDAO.save(traveler);
	}	

}
