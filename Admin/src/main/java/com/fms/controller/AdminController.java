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
@CrossOrigin(origins="http://localhost:4200")
public class AdminController {
	

	 @Autowired
	 private ScheduledflightService scheduleservice;
	 

	@Autowired
	private FlightService flightService;
	
	@Autowired
	private UserService  userservice;
	
	//add user
    @PostMapping(value="/addUser")
    public ResponseEntity<String> addUser(@RequestBody Userdata user)
    {
   	 Userdata  e= userservice.addUser(user);
   		if (e == null) {
   			throw new IdNotFoundException("Enter Valid Username");
   		} else {
   			return new ResponseEntity<>("User created successfully", new HttpHeaders(), HttpStatus.OK);
   		}
    }
    
    //login user
    @PutMapping("/loginUser")
	public String loginUser(@RequestBody Userdata u)
	 {
	 		
 		 return userservice.loginUser(u);
 		 
	 }
    
    //add flight details
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
	
	//get all flights
	@GetMapping(value="/getAllFlight",produces="application/json")
    public List<Flight> viewFlight()
    {
   	 return flightService.viewFlight();
    }
	
	//update flight
	@PutMapping("/updateFlight")
    public String modifyFlight(@RequestBody Flight flight){
		return flightService.updateFlight(flight);
	}
	
	//delete flight
	 @DeleteMapping("/deleteFlight/{flightnumber}")
     public String deleteFlight(@PathVariable int flightnumber)
     {
		 
    	 flightService.deleteFlight(flightnumber);
    	 return "Flight Details Deleted";
     }
	 
	 //get particular flight using flight number
	 @GetMapping(value="/getflight/{flightnumber}",produces="application/json")
     public Flight viewFlight(@PathVariable int flightnumber)
     {
    	 return flightService.viewFlight(flightnumber);
     }
     
	 
	 
	 // add schedule to a flight
     @PostMapping(value="/addScheduledFlight/{flightnumber}/{sourceairport}/{destinationairport}")
     public ResponseEntity<String> addScheduledFlight(@RequestBody Scheduledflight sf, @PathVariable int flightnumber,@PathVariable String sourceairport, @PathVariable String destinationairport)
     {
    	 Scheduledflight sfg1= scheduleservice.addScheduledflight(sf, flightnumber,sourceairport,destinationairport);
    	 
    		if (sfg1 == null) {
    			throw new IdNotFoundException("Enter Valid Id");
    		} else {
    			return new ResponseEntity<>("Flight details added successfully", new HttpHeaders(), HttpStatus.OK);
    		}
     }
	 
     // update scheduled flight
	 @PutMapping("/updatescheduledflight/{flightnumber}/{sourceairport}/{destinationairport}")
		public String updateFlight( @RequestBody Scheduledflight schedule,@PathVariable int flightnumber,@PathVariable String sourceairport, @PathVariable String destinationairport) {
			
				 scheduleservice.updateScheduleFlight(schedule,flightnumber,sourceairport,destinationairport);
				 return "Scheduled flight details are updated";
	    }
	 
	 //delete scheduled flight
	 @DeleteMapping("/deletescheduledflight/{scheduledflightid}")
	 public String deleteScheduledFlight(@PathVariable int scheduledflightid)
     {
		
    	 scheduleservice.deleteScheduledFlight(scheduledflightid);
    	 return "Scheduled flight Details Deleted";
     }
	 
	 //get all scheduled flights
	 @GetMapping("/getAllscheduledflights")
	 public List<Scheduledflight> viewScheduledFlight()
	    {
	   	 return scheduleservice.viewScheduledFlight();
	    }
	 
	 //get particular scheduled flight using scheduled flight id
	 @GetMapping(value="/getScheduledFlight/{scheduledid}",produces="application/json")
     public Scheduledflight viewScheduledFlight(@PathVariable int scheduledid)
     {
    	 return scheduleservice.viewScheduledFlight(scheduledid);
     }
	 
	
	 // add airport
	 @PostMapping("/Addairport")
		public String addAirport(@RequestBody Airport airport) {
		 
			 scheduleservice.addAirport(airport);
			 return "Airport added successfully";
			
		}
	 
     
}		
		
				

			
							
				
							
			

			

			
			
			

			
				
				
			