package com.fms.controller;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fms.dto.Booking;
import com.fms.dto.Scheduledflight;
import com.fms.dto.Airport;
import com.fms.dto.Passenger;
import com.fms.service.BookingServiceimpl;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:4200")

public class BookingController {

		@Autowired
		BookingServiceimpl bookingservice;
	
		
		// get all available flights
		@GetMapping("/booking/{source}/{destination}/{date}")
		public Set<Scheduledflight> bookFlight(@PathVariable String source, @PathVariable String destination,@PathVariable String date) {
			return bookingservice.availableflights(source, destination,date);
			
		}
		
		// add booking
		   @PostMapping(value="/addBooking/{username}/{scheduledflightid}")
		     public String addBookingDetails(@RequestBody Booking booking,@PathVariable String username, @PathVariable int scheduledflightid)
		     {
		 		bookingservice.addBooking(booking,username,scheduledflightid);
		 		return "Booking done successfully";
		    	 
		     }
	

		//delete booking
		@DeleteMapping("/deleteBooking/{bookingId}")
		  public String deleteBookingDetails(@PathVariable String bookingId)
		  {
		 	bookingservice.deleteBooking(bookingId);
		 	 return "cancelled tickets";
		  }
		
		//get booking id
		@GetMapping(value="/getBookingid",produces="application/json")
		  public String getbookingid()
		    {
		   	 return bookingservice.getbookingid();
		    }
		
		//get booking for particular username
		   @GetMapping(value="/getbooking/{username}",produces="application/json")
		     public List<Booking> getbooking(@PathVariable String username)
		     {
		    	 return bookingservice.getbooking(username);
		    	
		     }
		
		   //add passengers
	     @PostMapping(value="/addPassenger/{bookingid}")
	     public List<Passenger> addPassenger(@RequestBody List<Passenger> p, @PathVariable String bookingid)
	     {
	    	return  bookingservice.addPassenger(p,bookingid);
	    	
	    	 
	     }
	     
	  
	     //view all airports 
	     @GetMapping(value="/getAllAirports",produces="application/json")
	     public List<Airport> viewAirport()
	     {
	    	 return bookingservice.viewAirport();
	     }
	     
	     // check availability of seats
	     @GetMapping(value = "/checkavailability/{noofpassengers}/{availableseats}/{scheduledflightid}")
			public String checkavailability(@PathVariable int noofpassengers, @PathVariable int availableseats, @PathVariable int scheduledflightid) {
				return bookingservice.checkAvailability(noofpassengers,availableseats,scheduledflightid);
			}
	 	
	     // update seats after cancellation of tickets
	 	@PutMapping(value = "/updateseats/{noofpassengers}")
		public void updateseats(@RequestBody Booking deletebooking ,@PathVariable int noofpassengers) {
			 bookingservice.updateSeats(deletebooking,noofpassengers);
		}

}
