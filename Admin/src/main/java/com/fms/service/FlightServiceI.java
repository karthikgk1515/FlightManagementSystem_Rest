package com.fms.service;

import java.util.List;

import com.fms.dto.Flight;



public interface FlightServiceI {
	Flight addFlight(Flight flight);

	String updateFlight(Flight flight);

	void deleteFlight(int flightNumber);

	List<Flight> viewFlight();
	
	Flight viewFlight(int flightnumber);


}
