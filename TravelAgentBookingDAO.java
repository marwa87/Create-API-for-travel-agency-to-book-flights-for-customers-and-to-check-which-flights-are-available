package com.smoothstack.agentAPI.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.smoothstack.agentAPI.entity.Booking;

public interface TravelAgentBookingDAO extends JpaRepository<Booking, Integer>{

	@Query(value = "SELECT * FROM utopiaairlines.booking WHERE traveler_id = ?1", nativeQuery = true)
	Optional<List<Booking>> getBookingsOfTravler(Integer id);

	@Query(value = "SELECT * FROM utopiaairlines.booking WHERE flight_id = ?1", nativeQuery = true)
	Optional<List<Booking>> getBookingsOfFlight(Integer id);
	
	@Query(value = "SELECT * FROM utopiaairlines.booking WHERE travel_agent_id = ?1", nativeQuery = true)
	Optional<List<Booking>> getBookingsOfTravelAgent(Integer id);	

	@Modifying
	@Query(value = "UPDATE utopiaairlines.flight SET number_of_tickets = number_of_tickets - 1 WHERE flight_id = ?1", nativeQuery = true)
	public int decrementFlightTickets(Integer id);
	
	@Modifying
	@Query(value = "UPDATE utopiaairlines.flight SET number_of_tickets = number_of_tickets + 1 WHERE flight_id = ?1", nativeQuery = true)
	public int incrementFlightTickets(Integer id); 
	
	@Modifying
	@Query(value = "UPDATE utopiaairlines.traveler SET traveler_funds = traveler_funds + (SELECT ticket_price FROM utopiaairlines.flight WHERE flight_id = ?2) WHERE traveler_id = ?1", nativeQuery = true)
	public int refundTravelerFunds(Integer travelerId, Integer flightId);
	
	@Modifying
	@Query(value = "UPDATE utopiaairlines.traveler SET traveler_funds = traveler_funds - (SELECT ticket_price FROM utopiaairlines.flight WHERE flight_id = ?2) WHERE traveler_id = ?1", nativeQuery = true)
	public int chargeTraveler(Integer travelerId, Integer flightId);
	
	
}
