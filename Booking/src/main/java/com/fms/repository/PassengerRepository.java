package com.fms.repository;
import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fms.dto.Passenger;


@Repository
public interface PassengerRepository extends JpaRepository<Passenger,Serializable>
{

}
