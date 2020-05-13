package com.fms.controller;


import java.util.List;

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
import com.fms.dto.Userdata;
import com.fms.dto.Airport;
import com.fms.dto.Passenger;
import com.fms.service.BookingServiceimpl;

@RestController
@RequestMapping("/customer")
@CrossOrigin("http://localhost:4200")

public class BookingController {

		@Autowired
		BookingServiceimpl bookingservice;
		

		
		 @GetMapping(value="/getUser/{username}",produces="application/json")
	     public Userdata viewUser(@PathVariable String username)
	     {
	    	 return bookingservice.viewUser(username);
	     }

		

		@GetMapping("/booking/{source}/{destination}/{date}")
		public List<Scheduledflight> bookFlight(@PathVariable String source, @PathVariable String destination,@PathVariable String date) {
			return bookingservice.availableflights(source, destination,date);
			
		}

		   @PostMapping(value="/addBooking/{username}/{scheduledflightid}")
		     public String addBookingDetails(@RequestBody Booking booking,@PathVariable String username, @PathVariable int scheduledflightid)
		     {
		 		bookingservice.addBooking(booking,username,scheduledflightid);
		 		return "Booking done successfully";
		    	 
		     }
		@GetMapping("/getAllBookings")
		public List<Booking> displayList() {
			return bookingservice.viewBooking();
		}

	@GetMapping("/get/{bookingId}")
		public Booking displayOneList(@PathVariable String bookingId) {
			return bookingservice.viewBooking(bookingId);
		}

		@PutMapping(value = "/update/{bookingId}")
		public String updateBookingDetails(@RequestBody() Booking booking) {
			bookingservice.modifyBooking(booking);
			return "Booking Details updated ";
		}
		
		@DeleteMapping("/deleteBooking/{bookingId}")
		  public String deleteBookingDetails(@PathVariable String bookingId)
		  {
		 	bookingservice.deleteBooking(bookingId);
		 	 return "cancelled tickets";
		  }
		
		@GetMapping(value="/getBookingid",produces="application/json")
		  public String getbookingid()
		    {
		   	 return bookingservice.getbookingid();
		    }
		
		   @GetMapping(value="/getbooking/{username}",produces="application/json")
		     public List<Booking> getbooking(@PathVariable String username)
		     {
		    	 return bookingservice.getbooking(username);
		    	
		     }
		
	     @PostMapping(value="/addPassenger/{bookingid}")
	     public List<Passenger> addPassenger(@RequestBody List<Passenger> p, @PathVariable String bookingid)
	     {
	    	return  bookingservice.addPassenger(p,bookingid);
	    	
	    	 
	     }
	     
	  
	     
	     @GetMapping(value="/getAllAirports",produces="application/json")
	     public List<Airport> viewAirport()
	     {
	    	 return bookingservice.viewAirport();
	     }
	     
	     @GetMapping(value = "/checkavailability/{noofpassengers}/{availableseats}/{scheduledflightid}")
			public String checkavailability(@PathVariable int noofpassengers, @PathVariable int availableseats, @PathVariable int scheduledflightid) {
				return bookingservice.checkAvailability(noofpassengers,availableseats,scheduledflightid);
			}
	 	
	 	@PutMapping(value = "/updateseats/{noofpassengers}")
		public void updateseats(@RequestBody Booking deletebooking ,@PathVariable int noofpassengers) {
			 bookingservice.updateSeats(deletebooking,noofpassengers);
		}

}
