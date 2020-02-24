package com.smoothstack.agentAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.agentAPI.entity.TravelAgent;

public interface TravelAgentDAO extends JpaRepository<TravelAgent, Integer>{

	
}
