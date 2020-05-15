package com.fms.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Airport;
import com.fms.dto.Flight;
import com.fms.dto.Scheduledflight;
import com.fms.exception.FlightNotFoundException;
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
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
		try {
		 sdf.parse(schedule.getDate1());
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
    		return sfg;
    	}
    	else throw new FlightNotFoundException("Flight cannot be Scheduled");
    }
	
	 @Transactional
	public Scheduledflight updateScheduleFlight(Scheduledflight schedule, int flightnumber, String source,String destination) {
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-dd-MM");
			try {
			 sdf.parse(schedule.getDate1());
			} catch (ParseException e) {
				e.printStackTrace();
			}
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
	    		return sfg;
	    	}
	    	else throw new FlightNotFoundException("Flight cannot be Scheduled");
    
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
		return airportdao.findByairportName(airportName);
	}


	
}
