package com.cg.onlineeyeclinic.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

@RestController
@RequestMapping("/appointment")
public class AppointmentController 
{
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Appointment> viewAppointment(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(appointmentService.getAppointment(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Appointment>> getAllAppointment() throws AppointmentNotFoundException 
	{
		return new ResponseEntity<>(appointmentService.getAllAppointment(),HttpStatus.OK);
	}
	
	@GetMapping("/getbydoctor/{id}")
	public ResponseEntity<List<Appointment>> getAllAppointmentByDoctorId(@PathVariable int id) throws IdNotFoundException, AppointmentNotFoundException
	{
		return new ResponseEntity<>(appointmentService.getAllAppointmentByDoctorId(id),HttpStatus.OK);
	}
	
	@GetMapping("/getbypatient/{id}")
	public ResponseEntity<List<Appointment>> getAllAppointmentByPatientId(@PathVariable int id) throws IdNotFoundException, AppointmentNotFoundException
	{
		return new ResponseEntity<>(appointmentService.getAllAppointmentByPatientId(id),HttpStatus.OK);
	}
	
	@PostMapping("/create/{doctorId}/{patientId}")
	public ResponseEntity<Appointment> bookAppointment(@PathVariable int doctorId,@PathVariable int patientId,@Valid @RequestBody AppointmentDTO appointmentDTO) throws IdNotFoundException
	{
		Appointment appointment=con.convertToAppointment(appointmentDTO);
		return new ResponseEntity<>(appointmentService.bookAppointment(doctorId,patientId,appointment),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/cancel/{id}")
	public ResponseEntity<String> cancelAppointment(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(appointmentService.cancelAppointment(id),HttpStatus.ACCEPTED);
	}
}
