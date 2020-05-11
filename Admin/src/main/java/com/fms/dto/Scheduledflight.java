package com.fms.dto;



import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="Scheduledflight")
public class Scheduledflight implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="scheduledflight_id")
	private int scheduledflightid;
	@Column(name="available_seats")
	private int availableSeats;
	@Column(name="ticket_cost")
	private long ticketcost;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name="flight_number",referencedColumnName="flight_number")
	@NotFound(action = NotFoundAction.IGNORE)
	private Flight flight;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name="sourceairport", referencedColumnName="airport_name")
	@NotFound(action = NotFoundAction.IGNORE)
	private Airport sourceairport;
	
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name="destinationairport", referencedColumnName="airport_name")
	@NotFound(action = NotFoundAction.IGNORE)
	private Airport destinationairport;
	
	public String date1;

	private LocalTime arrivaltime;
	private LocalTime departuretime;

	public Scheduledflight() {
		
	}

	public Scheduledflight(int scheduledflightid, int availableSeats, long ticketcost, Flight flight,
			Airport sourceairport, Airport destinationairport, String date1, LocalTime arrivaltime,
			LocalTime departuretime) {
		super();
		this.scheduledflightid = scheduledflightid;
		this.availableSeats = availableSeats;
		this.ticketcost = ticketcost;
		this.flight = flight;
		this.sourceairport = sourceairport;
		this.destinationairport = destinationairport;
		this.date1 = date1;
		this.arrivaltime = arrivaltime;
		this.departuretime = departuretime;
	}

	public int getScheduledflightid() {
		return scheduledflightid;
	}

	public void setScheduledflightid(int scheduledflightid) {
		this.scheduledflightid = scheduledflightid;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public long getTicketcost() {
		return ticketcost;
	}

	public void setTicketcost(long ticketcost) {
		this.ticketcost = ticketcost;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Airport getSourceairport() {
		return sourceairport;
	}

	public void setSourceairport(Airport sourceairport) {
		this.sourceairport = sourceairport;
	}

	public Airport getDestinationairport() {
		return destinationairport;
	}

	public void setDestinationairport(Airport destinationairport) {
		this.destinationairport = destinationairport;
	}

	public String getDate1() {
		return date1;
	}

	public void setDate1(String date1) {
		this.date1 = date1;
	}

	public LocalTime getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(LocalTime arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public LocalTime getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(LocalTime departuretime) {
		this.departuretime = departuretime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Scheduledflight [scheduledflightid=" + scheduledflightid + ", availableSeats=" + availableSeats
				+ ", ticketcost=" + ticketcost + ", flight=" + flight + ", sourceairport=" + sourceairport
				+ ", destinationairport=" + destinationairport + ", date1=" + date1 + ", arrivaltime=" + arrivaltime
				+ ", departuretime=" + departuretime + "]";
	}

	}
