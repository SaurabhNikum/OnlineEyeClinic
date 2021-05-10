package com.cg.onlineeyeclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineeyeclinic.entities.AppointmentRequest;
import com.cg.onlineeyeclinic.repositories.AppointmentRequestRepository;

@Service 
public class AppointmentRequestServiceImpl 
{
	@Autowired
	private AppointmentRequestRepository appointmentRequestRepository;
	
	public List<AppointmentRequest> getAllAppointmentRequest()
	{
		return appointmentRequestRepository.findAll();
	}
	
	public String addAppointmentRequest(AppointmentRequest appointmentRequest)
	{
		appointmentRequestRepository.save(appointmentRequest);
		return "Request Successful";
	}
	
	public String cancelAppointmentRequest(long id)
	{
		appointmentRequestRepository.deleteById(id);
		return "Cancel Successful";
	}
}
