package com.cg.onlineeyeclinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineeyeclinic.entities.AppointmentRequest;

public interface AppointmentRequestRepository extends JpaRepository<AppointmentRequest, Long>
{
	
}
