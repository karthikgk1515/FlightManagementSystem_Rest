package com.fms.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fms.dto.Scheduledflight;

@Repository
public interface ScheduledflightRepository  extends JpaRepository<Scheduledflight,Serializable>
{
	@Query("select sf,f from Scheduledflight sf, Flight f where  sf.sourceairport.airportName=?1 and sf.destinationairport.airportName=?2 and sf.date1=?3")
	List<Scheduledflight> availableflights(String source, String destination, String date1);
	
}
