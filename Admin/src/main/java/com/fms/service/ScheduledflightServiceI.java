package com.fms.service;

import java.util.List;

import com.fms.dto.Airport;
import com.fms.dto.Scheduledflight;

public interface ScheduledflightServiceI {
	Scheduledflight addScheduledflight(Scheduledflight schedule, int flightnumber, String source, String destination);

	Scheduledflight updateScheduleFlight(Scheduledflight schedule,int flightnumber, String source, String destination);

	void deleteScheduledFlight(int scheduleId);

	List<Scheduledflight> viewScheduledFlight();
	
	Scheduledflight viewScheduledFlight(int scheduledflightid);
	
	Airport addAirport(Airport airport);
	
	List<Airport> viewAirport();
	
	 Airport getAirport(String airportName);
}
