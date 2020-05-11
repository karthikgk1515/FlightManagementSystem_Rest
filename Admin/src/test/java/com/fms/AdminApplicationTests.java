package com.fms;

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

import com.fms.dto.Userdata;
import com.fms.repository.AirportRepository;
import com.fms.repository.FlightRepository;
import com.fms.repository.UserRepository;
import com.fms.dto.Airport;
import com.fms.service.FlightService;
import com.fms.service.ScheduledflightService;
import com.fms.service.UserService;
import com.fms.dto.Flight;

@SpringBootTest
class AdminApplicationTests {

	@Mock
	private UserRepository udao;
	@InjectMocks
	private UserService userService;
	
	
	@Test
	public void testfindAlluser() {
		List<Userdata> userList=new ArrayList<>();
		userList.add(new Userdata(1,"Admin","sony","sony","809646811","sony@gmail.com"));
		userList.add(new Userdata(2,"customer","preethi","preethi","995938111","preethi@gmail.com"));
		Mockito.when(udao.findAll()).thenReturn(userList);
		List<Userdata> result=udao.findAll();
		assertEquals(2,result.size());
	}
	
	@Test
	public void testaddUser() {
		Userdata user=new Userdata();
		user.setUseremail("sony@gmail.com");
		user.setUserid(12);
		user.setUsername("sony");
		user.setUserphone("809646811");
		user.setUsertype("Admin");
		udao.save(user);
		
	}
	
	@Test
	public void updateUser() {
		Userdata user=new Userdata(5,"Admin","anu","anu","809646811","anu@gmail.com");
		udao.findById(3);
		udao.save(user);
		verify(udao,Mockito.times(1)).save(user);
	}
	
	@Test
	public void deleteUser() {
		Userdata user=new Userdata(3,"Admin","bhuvan","bhuvan","994885411","bhuvan@gmail.com");
		udao.deleteById(3);
		verify(udao,times(1)).deleteById(3);
	}


	@Mock
	private FlightRepository fdao;
	
	@InjectMocks
	private FlightService flightService;
	
	@Test
	public void testfindAllflights() {
		List<Flight> flightList=new ArrayList<>();
		flightList.add(new Flight(1,"ABC","AirIndia",80));
		flightList.add(new Flight(23,"Aero","Emairates",60));
		Mockito.when(fdao.findAll()).thenReturn(flightList);
		List<Flight> result=fdao.findAll();
		assertEquals(2,result.size());
	}
	
	@Test
	public void testaddFlight() {
		Flight flight=new Flight();
		flight.setFlightNumber(1);
		flight.setFlightModel("Aero");
		flight.setCarrierName("AirIndia");
		flight.setSeatCapacity(40);
		fdao.save(flight);
		
	}
	
	@Test
	public void updateFlight() {
		Flight flight=new Flight(3,"XYZ","Emairates",90);
		fdao.findById(3);
		fdao.save(flight);
		verify(fdao,Mockito.times(1)).save(flight);
	}
	
	@Test
	public void deleteFlight() {
		Flight flight=new Flight(5,"AD","Air",80);
		fdao.deleteById(5);
		verify(fdao,times(1)).deleteById(5);
	}
	

	@Mock
	private AirportRepository adao;
	
	@InjectMocks
	private ScheduledflightService airportService;
	
	
	
	
	@Test
	public void testfindAll() {
		List<Airport> airportList=new ArrayList<>();
		airportList.add(new Airport("1","RajivGandhi","Shamshabad"));
		airportList.add(new Airport("2","Bhegumpet","Bhegumpet"));
		Mockito.when(adao.findAll()).thenReturn(airportList);
		List<Airport> result=adao.findAll();
		assertEquals(2,airportList.size());
	}
	
	
	@Test
	public void testaddAirport() {
		Airport airport=new Airport();
		airport.setAirportCode("10");
		airport.setAirportName("Rajiv");
		airport.setAirportLocation("hyd");
		adao.save(airport);
		
	}
	
	@Test
	public void updateAirport() {
		Airport airport=new Airport("5","Bhegumpet","Hyd");
		adao.findByairportName("Hyd");
		adao.save(airport);
		verify(adao,Mockito.times(1)).save(airport);
	}
	
	@Test
	public void deleteAirport() {
		Airport airport=new Airport("6","Ghandi","Shamshabad");
		adao.deleteById("6");
		verify(adao,times(1)).deleteById("6");
	}
	
}
