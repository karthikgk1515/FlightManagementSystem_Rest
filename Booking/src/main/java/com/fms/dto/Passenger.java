package com.fms.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Passenger")
public class Passenger{
	@Id
	@Column(name="passengeruin",length=12)
	private String passengerUIN;
	@Column(name="passengername")
	private String passengername;
	@Column(name="passengerage",length=2)
	private int passengerage;
	@Column(name="pnrnumber",length=10)
	private String pnrnumber;
	@Column(name="passengergender")
	private String passengergender;
	
	public Passenger() {
		
	}

	public Passenger(String pnrnumber, String passengername, int passengerage, String passengerUIN,  String passengergender) {
		
		this.pnrnumber = pnrnumber;
		this.passengername = passengername;
		this.passengerage = passengerage;
		this.passengerUIN = passengerUIN;
		this.passengergender=passengergender;
	}

	public String getPnrnumber() {
		return pnrnumber;
	}

	public void setPnrnumber(String pnrnumber) {
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

	public String getPassengerUIN() {
		return passengerUIN;
	}

	public void setPassengerUIN(String passengerUIN) {
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
