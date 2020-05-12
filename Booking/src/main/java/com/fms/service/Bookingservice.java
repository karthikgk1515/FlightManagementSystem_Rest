package com.fms.service;


import java.util.List;

import com.fms.dto.Airport;
import com.fms.dto.Booking;
import com.fms.dto.Passenger;
import com.fms.dto.Scheduledflight;
import com.fms.dto.Userdata;

public interface Bookingservice {

	public List<Scheduledflight> viewScheduledflight();
	public  List<Scheduledflight> availableflights(String source,String destination, String date);
	public Booking addBooking(Booking booking, String username, int scheduledflightid);
	public List<Booking> viewBooking();
	public Booking viewBooking(String bookingId);
	public String updateSeats(Scheduledflight flight, Booking book);
	public Booking modifyBooking(Booking booking);
	public void deleteBooking(String bookingid);
	public String getbookingid();
	public List<Passenger> viewPassenger();
    public List<Passenger> addPassenger(List<Passenger> passenger, String bookingid);
    public void deletePassenger(int bookingid);
    public Userdata viewUser(String username);
    public List<Airport> viewAirport();
	public String checkAvailability(int noofpassengers, int availableseats,int scheduledflightid);
    public String updateSeats(Booking deletebooking,int noofpassengers);
}
