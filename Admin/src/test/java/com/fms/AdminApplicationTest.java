package com.fms;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.fms.dto.Userdata;
import com.fms.repository.AirportRepository;
import com.fms.repository.FlightRepository;
import com.fms.repository.ScheduledFlightRepository;
import com.fms.repository.UserRepository;
import com.fms.dto.Airport;
import com.fms.service.FlightService;
import com.fms.service.ScheduledflightService;
import com.fms.service.UserService;
import com.fms.dto.Flight;
import com.fms.dto.Scheduledflight;

@SpringBootTest
class AdminApplicationTest {

	@Mock
	private UserRepository udao;
	@InjectMocks
	private UserService userService;
	

	@Mock
	private ScheduledFlightRepository sfdao;
	
	@InjectMocks
	private ScheduledflightService sfService;
	

	@Mock
	private FlightRepository fdao;
	
	@InjectMocks
	private FlightService flightService;
	
	@Mock
	private AirportRepository adao;
	
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
  public void testLoginUser(){
   Userdata user = new Userdata("karthik1","karthik@12");
  when(udao.findById(user.getUsername())).thenReturn(Optional.of(user));  		
   String result = userService.loginUser(user);
		assertEquals(true,result);      		
}

	
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
	
    @Test
    public void testgetflightbyid(){
    	Flight flight=new Flight(5,"XYZ","Emirates",200);
    	  when(fdao.findById(flight.getFlightNumber())).thenReturn(Optional.of(flight)); 
		
     Flight result = flightService.viewFlight(5);
		assertEquals(5, result.getFlightNumber());
		assertEquals("XYZ", result.getFlightModel());
		assertEquals("Emirates", result.getCarrierName());
		assertEquals(200, result.getSeatCapacity());           
	}



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
	public void testaddScheduledFlight() {
		Scheduledflight flight=new Scheduledflight();
		Flight f=new Flight(1,"Aero","Air India",400);
		Airport a1=new Airport("Hyd123","Hyderabad","Rajeev gandhi");
		Airport a2=new Airport("Ban123","Bangaloore","Vor Bangaloore");
		flight.setScheduledflightid(901);
		flight.setAvailableSeats(300);
		flight.setTicketcost(1200);
		flight.setFlight(f);
		flight.setSourceairport(a1);
		flight.setDestinationairport(a2);
		flight.setDate1("2020-05-11");
		flight.setArrivaltime(null);
		flight.setDeparturetime(null);
		sfdao.save(flight);
		
	}
	
	
	
	@Test
	public void testfindAllScheduledflight() {
		List<Scheduledflight> flightList=new ArrayList<>();
		Flight f=new Flight(1,"Aero","Air India",400);
		Airport a1=new Airport("Hyd123","Hyderabad","Rajeev gandhi");
		Airport a2=new Airport("Ban123","Bangaloore","Vor Bangaloore");
		flightList.add(new Scheduledflight(1,300,1200,f,a1,a2,"2020-05-14",null,null));
		Mockito.when(sfdao.findAll()).thenReturn(flightList);
		List<Scheduledflight> result=sfdao.findAll();
		assertEquals(1,result.size());
	}
	
	@Test
	public void deleteScheduledflight() {
		Flight f=new Flight(1,"Aero","Air India",400);
		Airport a1=new Airport("Hyd123","Hyderabad","Rajeev gandhi");
		Airport a2=new Airport("Ban123","Bangaloore","Vor Bangaloore");
		Scheduledflight sfg= new Scheduledflight(1,300,1200,f,a1,a2,"2020-05-14",null,null);
		sfdao.deleteById("1");
		verify(sfdao,times(1)).deleteById("1");
	}
	
	   @Test
	    public void testgetscheduleflightbyid(){
			Flight f=new Flight(1,"Aero","Air India",400);
			Airport a1=new Airport("Hyd123","Hyderabad","Rajeev gandhi");
			Airport a2=new Airport("Ban123","Bangaloore","Vor Bangaloore");
			Scheduledflight sfg= new Scheduledflight(1,300,1200,f,a1,a2,"2020-05-14",null,null);
	    	  when(sfdao.findById(sfg.getScheduledflightid())).thenReturn(Optional.of(sfg)); 
	     Scheduledflight result = sfService.viewScheduledFlight(1);
			assertEquals(1,result.getScheduledflightid());
			assertEquals(300,result.getAvailableSeats());
			assertEquals(1200,result.getTicketcost());
			assertEquals(f.getFlightNumber(),result.getFlight().getFlightNumber());
			assertEquals(a1.getAirportName(),result.getSourceairport().getAirportName());
			assertEquals(a2.getAirportName(),result.getDestinationairport().getAirportName());
			assertEquals("2020-05-14",result.getDate1());
		}
	
}