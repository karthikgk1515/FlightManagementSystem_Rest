package com.fms.service;

import java.util.List;

import com.fms.dto.Flight;



public interface FlightServiceI {
	String addFlight(Flight flight);

	String updateFlight(Flight flight);

	void deleteFlight(int flightNumber);

	List<Flight> viewFlight();


}
