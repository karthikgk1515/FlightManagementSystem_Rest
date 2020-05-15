package com.fms.service;


import java.util.List;
import java.util.Set;

import com.fms.dto.Airport;
import com.fms.dto.Booking;
import com.fms.dto.Passenger;
import com.fms.dto.Scheduledflight;


public interface Bookingservice {
	public  Set<Scheduledflight> availableflights(String source,String destination, String date);
	public Booking addBooking(Booking booking, String username, int scheduledflightid);
	public String updateSeats(Scheduledflight flight, Booking book);
	public void deleteBooking(String bookingid);
	public String getbookingid();
    public List<Passenger> addPassenger(List<Passenger> passenger, String bookingid);
    public List<Airport> viewAirport();
	public String checkAvailability(int noofpassengers, int availableseats,int scheduledflightid);
    public String updateSeats(Booking deletebooking,int noofpassengers);
    public List<Booking> getbooking(String username);
}
