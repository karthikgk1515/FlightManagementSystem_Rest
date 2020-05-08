package com.fms.repository;
import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fms.dto.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking,Serializable>
{
	
	@Query("select b from Booking b where b.username=?1")
	List<Booking> findBybooking(String username);
	
}
