package com.fms.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Airport;
import com.fms.dto.Flight;
import com.fms.dto.Scheduledflight;
import com.fms.exception.IdNotFoundException;
import com.fms.repository.AirportRepository;
import com.fms.repository.FlightRepository;
import com.fms.repository.ScheduledFlightRepository;

@Service
public class ScheduledflightService implements ScheduledflightServiceI  {
	
	 @Autowired
	    ScheduledFlightRepository fsdao;
	 
	 @Autowired
	   AirportRepository airportdao;
	 
	 @Autowired
	 FlightRepository fdao;
	 
	 @Transactional
	public Scheduledflight addScheduledflight(Scheduledflight schedule, int flightnumber, String source, String destination) {
		
		Flight f=fdao.findById(flightnumber).get();
    	Airport a=airportdao.findByairportName(source);
    	Airport a1=airportdao.findByairportName(destination);
    	if(f==null||a==null||a1==null)
    		return null;
    	if(schedule.getFlight()==null||schedule.getSourceairport()==null||schedule.getDestinationairport()==null)
    	{
    		Scheduledflight sfg=fsdao.save(schedule);
    		sfg.setFlight(f);
    		sfg.setSourceairport(a);
    		sfg.setDestinationairport(a1);
    		System.out.println(sfg);
    		return sfg;
    	}
    	else throw new IdNotFoundException("Flight cannot be Scheduled");
    }
	
	 @Transactional
	public Scheduledflight updateScheduleFlight(Scheduledflight schedule, int flightnumber, String source,String destination) {
		Scheduledflight fs=fsdao.findById(schedule.getScheduledflightid()).get();
    /*	if(fs!=null)
    	{
    		fs.setScheduledflightid(schedule.getScheduledflightid());
    		fs.setAvailableSeats(schedule.getAvailableSeats());
    		fs.setTicketcost(schedule.getTicketcost());
    		fs.setFlight(schedule.getFlight());
    		fs.setSourceairport(schedule.getSourceairport());
    		fs.setDestinationairport(schedule.getDestinationairport());
    		fs.setArrivaltime(schedule.getArrivaltime());
    		fs.setDeparturetime(schedule.getDeparturetime());
    	}
    	return fsdao.save(schedule);*/
		Flight f=fdao.findById(flightnumber).get();
    	Airport a=airportdao.findByairportName(source);
    	Airport a1=airportdao.findByairportName(destination);
    	if(f==null||a==null||a1==null)
    		return null;
    	if(schedule.getFlight()==null||schedule.getSourceairport()==null||schedule.getDestinationairport()==null)
    	{
    		Scheduledflight sfg=fsdao.save(schedule);
    		sfg.setFlight(f);
    		sfg.setSourceairport(a);
    		sfg.setDestinationairport(a1);
    		System.out.println(sfg);
    		return sfg;
    	}
    	else throw new IdNotFoundException("Flight cannot be Scheduled");
    
    }
	

	 @Transactional
	public void deleteScheduledFlight(int scheduleId)
    {
    	  fsdao.deleteById(scheduleId);
    }

	 @Transactional
	public List<Scheduledflight> viewScheduledFlight() {
		
		return fsdao.findAll();
	}

	 @Transactional
	public Scheduledflight viewScheduledFlight(int scheduledflightid) {
		
		return fsdao.findById(scheduledflightid).get();
	}


	@Transactional
	public Airport addAirport(Airport airport) {
		
		return airportdao.save(airport);
	}


	@Transactional
	public List<Airport> viewAirport() {
		
		return airportdao.findAll();
	}

	@Transactional
	public Airport getAirport(String airportName)
	{
		Airport airport=airportdao.findByairportName(airportName);
		return airport;
	}


	
}
