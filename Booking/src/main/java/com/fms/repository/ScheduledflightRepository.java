package com.fms.repository;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.fms.dto.Scheduledflight;

@Repository
public interface ScheduledflightRepository  extends JpaRepository<Scheduledflight,Serializable>
{
	@Query("select sf,f from Scheduledflight sf, Flight f where  sf.sourceairport.airportName=?1 and sf.destinationairport.airportName=?2 and sf.date1=?3")
	Set<Scheduledflight> availableflights(String source, String destination, String date1);
	
	@Modifying
	@Query("update Scheduledflight sf set sf.availableSeats=?2 where sf.scheduledflightid=?1")
	void updateseats(int scheduledflightid,int availableseats);
	
}
