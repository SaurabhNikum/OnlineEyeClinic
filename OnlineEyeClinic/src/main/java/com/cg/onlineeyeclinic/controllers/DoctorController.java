package com.cg.onlineeyeclinic.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineeyeclinic.dto.DoctorDTO;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.DoctorNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.DoctorService;

//***********************************Doctor Controller Class****************************************//
@CrossOrigin
@RestController
@RequestMapping("/onlineeyeclinic")
public class DoctorController 
{
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/doctor/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(doctorService.getDoctor(id));
	}
	
	@GetMapping("/doctorbyname/{name}")
	public ResponseEntity<List<Doctor>> getAllDoctorByName(@PathVariable String name)throws NameNotFoundException
	{
		return ResponseEntity.ok(doctorService.getAllDoctorsByName(name));
	}
	
//	@GetMapping("/appointmentbydoctor/{id}")
//	public ResponseEntity<List<Appointment>> getAllAppointmentByDoctor(@PathVariable int id) throws IdNotFoundException, AppointmentNotFoundException
//	{
//		return ResponseEntity.ok(doctorService.getAllAppointmentByDoctorId(id));
//	}
	
	@GetMapping("/doctor")
	public ResponseEntity<List<Doctor>> getAllDoctor() throws DoctorNotFoundException
	{
		return ResponseEntity.ok(doctorService.getAllDoctor());
	}
	
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody DoctorDTO doctorDTO) throws UserNameAlreadyExistException
	{
		Doctor doctor=con.convertToDoctor(doctorDTO);
		return ResponseEntity.ok(doctorService.addDoctor(doctor));
	}
	
	@PutMapping("/doctor/{doctorId}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int doctorId,@Valid @RequestBody DoctorDTO doctorDTO) throws IdNotFoundException, UserNameAlreadyExistException
	{
		Doctor doctor=con.convertToDoctor(doctorDTO);
		return ResponseEntity.ok(doctorService.updateDoctor(doctorId,doctor));
	} 
	
	@DeleteMapping("/doctor/{doctorId}")
	public ResponseEntity<String> removeDoctor(@PathVariable int doctorId) throws IdNotFoundException
	{
		return ResponseEntity.ok(doctorService.removeDoctor(doctorId));
	}
}
