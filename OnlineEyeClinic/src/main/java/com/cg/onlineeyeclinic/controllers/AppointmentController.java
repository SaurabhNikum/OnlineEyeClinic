package com.cg.onlineeyeclinic.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyeclinic.dto.AppointmentDTO;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.services.AppointmentService;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;

//***********************************Appointment Controller Class****************************************//
@CrossOrigin
@RestController
@RequestMapping("/onlineeyeclinic")
public class AppointmentController 
{
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/appointment/{id}")
	public ResponseEntity<Appointment> viewAppointment(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(appointmentService.getAppointment(id));
	}
	
	@GetMapping("/appointment")
	public ResponseEntity<List<Appointment>> getAllAppointment() throws AppointmentNotFoundException 
	{
		return ResponseEntity.ok(appointmentService.getAllAppointment());
	}
	
	@GetMapping("/appointmentbydoctor/{id}")
	public ResponseEntity<List<Appointment>> getAllAppointmentByDoctorId(@PathVariable int id) throws IdNotFoundException, AppointmentNotFoundException
	{
		return ResponseEntity.ok(appointmentService.getAllAppointmentByDoctorId(id));
	}
	
	@GetMapping("/appointmentbypatient/{id}")
	public ResponseEntity<List<Appointment>> getAllAppointmentByPatientId(@PathVariable int id) throws IdNotFoundException, AppointmentNotFoundException
	{
		return ResponseEntity.ok(appointmentService.getAllAppointmentByPatientId(id));
	}
	
	@PostMapping("/appointment")
	public ResponseEntity<Appointment> bookAppointment(@Valid @RequestBody AppointmentDTO appointmentDTO) throws IdNotFoundException
	{
		Appointment appointment=con.convertToAppointment(appointmentDTO);
		return new ResponseEntity<>(appointmentService.bookAppointment(appointment),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/appointment/{id}")
	public ResponseEntity<String> cancelAppointment(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(appointmentService.cancelAppointment(id),HttpStatus.ACCEPTED);
	}
}
