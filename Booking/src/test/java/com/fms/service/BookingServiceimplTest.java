package com.fms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.dto.Booking;
import com.fms.repository.BookingRepository;
import com.fms.repository.ScheduledflightRepository;
import com.fms.service.BookingServiceimpl;
import com.fms.service.Bookingservice;
import com.fms.dto.Passenger;
import com.fms.repository.PassengerRepository;

@SpringBootTest
class BookingApplicationTests {

	@Mock
	private BookingRepository bookingDao;
	
	@InjectMocks
	private BookingServiceimpl bookingService;
	
	@Test
	public void testfindAllBooking() {
		List<Booking> bookingList=new ArrayList<>();
		bookingList.add(new Booking("12","5/5/2020",800,12,null,null,"sony"));
		bookingList.add(new Booking("16","5/7/2020",900,99,null,null,"preethi"));
		Mockito.when(bookingDao.findAll()).thenReturn(bookingList);
		List<Booking> result=bookingDao.findAll();
		assertEquals(2,result.size());
	}
	
	
	@Test
	public void testaddBooking() {
		Booking booking=new Booking();
		booking.setBookingId("12");
		booking.setBookingDate("23/01/2020");
		booking.setNoOfPassengers(80);
		booking.setPassenger(null);
		booking.setScheduledflight(null);
		booking.setUsername("sony");
		booking.setTicketCost(800);
		bookingDao.save(booking);
		
	}
	
	@Test
	public void updateBooking() {
		Booking booking=new Booking("3","5/5/2020",800,12,null,null,"sony");
		bookingDao.findById("3");
		bookingDao.save(booking);
		verify(bookingDao,Mockito.times(1)).save(booking);
	}
	
	@Test
	public void deleteBooking() {
		Booking booking=new Booking("3","5/5/2020",800,12,null,null,"sony");
		bookingDao.deleteById(3);
		verify(bookingDao,times(1)).deleteById(3);
	}
	
	
	@Mock
	private PassengerRepository pdao;
	
	
	@Test
	public void testfindAllpassengers() {
		List<Passenger> passengerList=new ArrayList<>();
		passengerList.add(new Passenger("1","sony",21,"55","Female"));
		passengerList.add(new Passenger("2","preethi",21,"45","Female"));
		Mockito.when(pdao.findAll()).thenReturn(passengerList);
		List<Passenger> result=pdao.findAll();
		assertEquals(2,result.size());
	}
	
	@Test
	public void testaddPassenger() {
		Passenger passenger=new Passenger();
		passenger.setPassengerage(21);
		passenger.setPassengername("sai");
		passenger.setPassengerUIN("23");
		passenger.setPnrnumber("123");
		passenger.setPassengergender("Male");
		pdao.save(passenger);
		
	}
	
	@Test
	public void updatePassenger() {
		Passenger passenger=new Passenger("3","Anu",27,"234","Male");
		pdao.findById(3);
		pdao.save(passenger);
		verify(pdao,Mockito.times(1)).save(passenger);
	}
	
	@Test
	public void deletePassenger() {
		Passenger passenger=new Passenger("3","kavitha",30,"67","Female");
		pdao.deleteById(3);
		verify(pdao,times(1)).deleteById(3);
	}



}

