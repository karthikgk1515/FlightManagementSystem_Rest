package com.fms.dto;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger{
	@Id
	private int passengerUIN;
	private String passengername;
	private int passengerage;
	private int pnrnumber;
	private String passengergender;
	
	public Passenger() {
		
	}

	public Passenger(int pnrnumber, String passengername, int passengerage, int passengerUIN,  String passengergender) {
		
		this.pnrnumber = pnrnumber;
		this.passengername = passengername;
		this.passengerage = passengerage;
		this.passengerUIN = passengerUIN;
		this.passengergender=passengergender;
	}

	public int getPnrnumber() {
		return pnrnumber;
	}

	public void setPnrnumber(int pnrnumber) {
		this.pnrnumber = pnrnumber;
	}

	public String getPassengername() {
		return passengername;
	}

	public void setPassengername(String passengername) {
		this.passengername = passengername;
	}

	public int getPassengerage() {
		return passengerage;
	}

	public void setPassengerage(int passengerage) {
		this.passengerage = passengerage;
	}

	public int getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(int passengerUIN) {
		this.passengerUIN = passengerUIN;
	}


	public String getPassengergender() {
		return passengergender;
	}

	public void setPassengergender(String passengergender) {
		this.passengergender = passengergender;
	}

	@Override
	public String toString() {
		return "Passenger [passengerUIN=" + passengerUIN + ", passengername=" + passengername + ", passengerage="
				+ passengerage + ", pnrnumber=" + pnrnumber + ", passengergender=" + passengergender + "]";
	}
	
	
	
}
