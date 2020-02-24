package com.smoothstack.agentAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.agentAPI.entity.Flight;

public interface TravelAgentFlightDAO extends JpaRepository<Flight, Integer> {

}
