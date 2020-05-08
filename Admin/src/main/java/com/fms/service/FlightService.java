package com.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Flight;
import com.fms.repository.FlightRepository;

@Service
public class FlightService implements FlightServiceI {
	
	@Autowired
	private FlightRepository flightDao;
	

	public String addFlight(Flight flight) {
		flightDao.save(flight);
		 return "Flight details are added";
		
	}

	public List<Flight> viewFlight(){
		return flightDao.findAll();
		}
	
	public String updateFlight(Flight flight) {
		boolean result=flightDao.existsById(flight.getFlightNumber());
			
			if(result){
				flightDao.save(flight);
				return "updated flight";
			}else{
				
				return "Id not exits";
			}
		
		}
		

	public void deleteFlight(int flightNumber) {
		flightDao.deleteById(flightNumber);
	
	}
	

	public Flight viewFlight(int flightnumber) {
		
		return flightDao.findById(flightnumber).get();
	}

}
