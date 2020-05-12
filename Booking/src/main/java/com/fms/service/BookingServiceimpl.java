package com.fms.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fms.dto.Airport;
import com.fms.dto.Booking;
import com.fms.dto.Passenger;
import com.fms.dto.Scheduledflight;
import com.fms.dto.Userdata;
import com.fms.exception.IdNotFoundException;
import com.fms.repository.AirportRepository;
import com.fms.repository.BookingRepository;
import com.fms.repository.PassengerRepository;
import com.fms.repository.ScheduledflightRepository;
import com.fms.repository.UserRepository;

@Service
public class BookingServiceimpl implements Bookingservice {

	@Autowired
	ScheduledflightRepository sfdao;
	
	@Autowired
	BookingRepository bdao;
	
	@Autowired
	PassengerRepository pdao;
	
	@Autowired
	UserRepository udao;
	
	@Autowired
	AirportRepository adao;
	
	@Transactional
	public List<Scheduledflight> viewScheduledflight() {
		List<Scheduledflight> flights= sfdao.findAll();
		return flights;
		
	}
	@Transactional
	public List<Scheduledflight> availableflights(String source,String destination, String date1) {
		List<Scheduledflight> flights1=sfdao.availableflights(source,destination,date1);
		return flights1;
	}
	@Transactional
	public String updateSeats(Scheduledflight flight,Booking book) {
        
			sfdao.save(flight);
			return "seats were updated successfully!!";
	
	}
	@Transactional
	 public Booking addBooking(Booking booking, String username, int scheduledflightid)
	    {
		Scheduledflight sf=sfdao.findById(scheduledflightid).get();
		int cost=(booking.getNoOfPassengers())*(sf.getTicketcost());
		Userdata ud=udao.findById(username).get();
		if(sf==null||ud==null)
			return null;
		if(booking.getScheduledflight()==null || booking.getUsername()==null)
		{
			Booking b=bdao.save(booking);
			b.setTicketCost(cost);
			b.setScheduledflight(sf);
			List<Booking> book=new ArrayList<Booking>();
			book.add(b);
			ud.setBooking(book);
			return b;
			
		}
		else throw new IdNotFoundException("Invalid booking details");
	     
	    }

@Transactional
public Booking modifyBooking(Booking booking)
   {
    return  bdao.save(booking);
	}

@Transactional
public List<Booking> viewBooking() {
	List<Booking> list= bdao.findAll();
	return list;
}
	@Transactional
	public Booking viewBooking(String bookingId) {
		Booking booking= bdao.findById(bookingId).get();
		return booking;
	}
	
	@Transactional
	public void deleteBooking(String bookingid)
	{
		bdao.deleteById(bookingid);
	}
	
	@Transactional
	public String getbookingid()
	{
	long min=100000000;
	long max=999999999;
    long x = (long) ((Math.random()*((max-min)+1))+min);
    String random=Long.toString(x);
    return random;
	}
	
	  @Transactional
	     public List<Passenger> viewPassenger()
	     {
	    	 return pdao.findAll();
	     }
	     
	     @Transactional
	     public List<Passenger> addPassenger(List<Passenger> passenger, String bookingid)
	     {
	    	 Booking b=bdao.findById(bookingid).get();
	    	 System.out.println("hello"+b);
	    	 if(b==null)
	    		 return null;
	    	 if(b.getPassenger().isEmpty())
	    	 {
	    		 List<Passenger> p= pdao.saveAll(passenger);
	    		 b.setPassenger(p);
	    		 System.out.println(b);
	    		 return p;
	    	 }
	    	 else
	    		 throw new IdNotFoundException("passenger not found");
	     }
	     @Transactional
	     public void deletePassenger(int bookingid)
	     {
	    	 pdao.deleteById(bookingid);
	     }
		@Transactional
		public Userdata viewUser(String username) {
			Userdata ud=udao.findById(username).get();
			return ud;
		}
		
		@Transactional
		public List<Airport> viewAirport()
		{
			return adao.findAll();
		}
		
		@Transactional
	    public List<Booking> getbooking(String username)
	    {
			List<Booking> booking=bdao.findBybooking(username);
			return booking;
	    }
	     
		@Transactional
		public String checkavailability(int noofpassengers, int availableseats,int scheduledflightid)
		{
			if(noofpassengers<=availableseats)
			{
				availableseats-=noofpassengers;
				sfdao.updateseats(scheduledflightid,availableseats);
				return "seats";
			}
			else 
				return "no seats";
		}
	
		@Transactional
		public String updateseats(Booking deletebooking,int noofpassengers)
		{
			int availableseats=deletebooking.getScheduledflight().getAvailableSeats();
			int scheduledflightid=deletebooking.getScheduledflight().getScheduledflightid();
				availableseats+=noofpassengers;
				sfdao.updateseats(scheduledflightid,availableseats);
			return "done";
		}
}
