package com.fms.dto;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Booking")
public class Booking {
	@Id
	@Column(name="booking_id")
	private String bookingId;

	@Column(name="booking_date")
	private String bookingDate;
	@Column(name="ticket_cost")
	private double ticketCost;
	@Column(name="no_of_passengers")
	private int noOfPassengers;
	@Column(name="username")
	private String username;
	
	@OneToMany
	@JoinColumn(name="booking_details")
	private List<Passenger> passenger= new ArrayList<>();

	@OneToOne
    @JoinColumn(name="scheduledflight_id")
    private Scheduledflight scheduledflight;

	public Booking() {
		
	}

	public Booking(String bookingId, String bookingDate, double ticketCost, int noOfPassengers, 
			List<Passenger> passenger, Scheduledflight scheduledflight, String username) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.ticketCost = ticketCost;
		this.noOfPassengers = noOfPassengers;
		this.passenger = passenger;
		this.scheduledflight = scheduledflight;
		this.username=username;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public double getTicketCost() {
		return ticketCost;
	}

	public void setTicketCost(double ticketCost) {
		this.ticketCost = ticketCost;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public Scheduledflight getScheduledflight() {
		return scheduledflight;
	}

	public void setScheduledflight(Scheduledflight scheduledflight) {
		this.scheduledflight = scheduledflight;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", ticketCost=" + ticketCost
				+ ", noOfPassengers=" + noOfPassengers + ", username=" + username + ", passenger=" + passenger
				+ ", scheduledflight=" + scheduledflight + "]";
	}


	
	
}
