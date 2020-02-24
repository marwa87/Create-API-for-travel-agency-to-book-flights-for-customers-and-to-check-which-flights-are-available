package com.smoothstack.agentAPI.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smoothstack.agentAPI.entity.Traveler;

public interface TravelAgentTravelerDAO extends JpaRepository<Traveler, Integer>{

}
