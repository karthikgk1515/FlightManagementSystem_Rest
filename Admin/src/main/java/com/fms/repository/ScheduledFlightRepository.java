package com.fms.repository;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dto.Scheduledflight;


@Repository
public interface ScheduledFlightRepository  extends JpaRepository<Scheduledflight,Serializable>
{
	
}
