package com.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.Airport;
import com.fms.dto.Flight;
import com.fms.dto.Scheduledflight;
import com.fms.dto.Userdata;
import com.fms.exception.FlightNotFoundException;
import com.fms.exception.IdNotFoundException;
import com.fms.service.FlightService;
import com.fms.service.ScheduledflightService;
import com.fms.service.UserService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:4200", maxAge=3600)
public class AdminController {
	

	 @Autowired
	 private ScheduledflightService scheduleservice;
	 

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private UserService  userservice;
	
    @PostMapping(value="/addUser")
    public ResponseEntity<String> addUser(@RequestBody Userdata user)
    {
   	 Userdata  e= userservice.addUser(user);
   		if (e == null) {
   			throw new IdNotFoundException("Enter Valid Username");
   		} else {
   			return new ResponseEntity<String>("User created successfully", new HttpHeaders(), HttpStatus.OK);
   		}
    }
    
    @PutMapping("/loginUser")
	public String LoginUser(@RequestBody Userdata u)
	 {
	 		
 		 String flag=userservice.LoginUser(u);
 		 return flag;
	 }
    
	@PostMapping("/addflight")
	public String addFlight(@RequestBody Flight flight) {
		Flight f=flightService.addFlight(flight);
		if(f!=null)
		{
			return "Flight details are added";
		}
		else
			throw new FlightNotFoundException("Invalid flight details");
	}
	
	@GetMapping(value="/getAllFlight",produces="application/json")
    public List<Flight> viewFlight()
    {
   	 return flightService.viewFlight();
    }
	
	@PutMapping("/updateFlight")
    public String modifyFlight(@RequestBody Flight flight){
		return flightService.updateFlight(flight);
	}
	 @DeleteMapping("/deleteFlight/{flightnumber}")
     public String deleteFlight(@PathVariable int flightnumber)
     {
		 System.out.println(flightnumber);
    	 flightService.deleteFlight(flightnumber);
    	 return "Flight Details Deleted";
     }
	 @GetMapping(value="/getflight/{flightnumber}",produces="application/json")
     public Flight viewFlight(@PathVariable int flightnumber)
     {
    	 return flightService.viewFlight(flightnumber);
     }
     
	 
	 

     @PostMapping(value="/addScheduledFlight/{flightnumber}/{sourceairport}/{destinationairport}")
     public ResponseEntity<String> addScheduledFlight(@RequestBody Scheduledflight sf, @PathVariable int flightnumber,@PathVariable String sourceairport, @PathVariable String destinationairport)
     {
    	 Scheduledflight sfg1= scheduleservice.addScheduledflight(sf, flightnumber,sourceairport,destinationairport);
    	 
    		if (sfg1 == null) {
    			throw new IdNotFoundException("Enter Valid Id");
    		} else {
    			return new ResponseEntity<String>("Flight details added successfully", new HttpHeaders(), HttpStatus.OK);
    		}
     }
	 
	 @PutMapping("/updatescheduledflight/{flightnumber}/{sourceairport}/{destinationairport}")
		public String updateFlight( @RequestBody Scheduledflight schedule,@PathVariable int flightnumber,@PathVariable String sourceairport, @PathVariable String destinationairport) {
			
				 scheduleservice.updateScheduleFlight(schedule,flightnumber,sourceairport,destinationairport);
				 return "Scheduled flight details are updated";
	    }
	 
	 @DeleteMapping("/deletescheduledflight/{scheduledflightid}")
	 public String deleteScheduledFlight(@PathVariable int scheduledflightid)
     {
		 System.out.println(scheduledflightid);
    	 scheduleservice.deleteScheduledFlight(scheduledflightid);
    	 return "Scheduled flight Details Deleted";
     }
	 
	 @GetMapping("/getAllscheduledflights")
	 public List<Scheduledflight> viewScheduledFlight()
	    {
	   	 return scheduleservice.viewScheduledFlight();
	    }
	 
	 @GetMapping(value="/getScheduledFlight/{scheduledid}",produces="application/json")
     public Scheduledflight viewScheduledFlight(@PathVariable int scheduledid)
     {
    	 return scheduleservice.viewScheduledFlight(scheduledid);
     }
	 
	
	 
	 @PostMapping("/Addairport")
		public String addAirport(@RequestBody Airport airport) {
		 
			 scheduleservice.addAirport(airport);
			 return "Airport added successfully";
			
		}
	 
     
}		
		
				

			
							
				
							
			

			

			
			
			

			
				
				
			