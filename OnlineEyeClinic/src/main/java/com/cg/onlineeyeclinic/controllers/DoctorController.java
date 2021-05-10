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

@RestController
@RequestMapping("/doctor")
public class DoctorController 
{
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(doctorService.getDoctor(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/getbyname/{name}")
	public ResponseEntity<List<Doctor>> getAllDoctorByName(@PathVariable String name)throws NameNotFoundException
	{
		return new ResponseEntity<>(doctorService.getAllDoctorsByName(name),HttpStatus.FOUND);
	}
	
	@GetMapping("/getallappointmentbydoctor/{id}")
	public ResponseEntity<List<Appointment>> getAllAppointmentByDoctor(@PathVariable int id) throws IdNotFoundException, AppointmentNotFoundException
	{
		return new ResponseEntity<>(doctorService.getAllAppointmentByDoctorId(id),HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Doctor>> getAllDoctor() throws DoctorNotFoundException
	{
		return new ResponseEntity<>(doctorService.getAllDoctor(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Doctor> addDoctor(@Valid @RequestBody DoctorDTO doctorDTO) throws UserNameAlreadyExistException
	{
		Doctor doctor=con.convertToDoctor(doctorDTO);
		return new ResponseEntity<>(doctorService.addDoctor(doctor),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{doctorId}")
	public ResponseEntity<Doctor> updateDoctor(@PathVariable int doctorId,@Valid @RequestBody DoctorDTO doctorDTO) throws IdNotFoundException, UserNameAlreadyExistException
	{
		Doctor doctor=con.convertToDoctor(doctorDTO);
		return new ResponseEntity<>(doctorService.updateDoctor(doctorId,doctor),HttpStatus.ACCEPTED);
	} 
	
	@DeleteMapping("/remove/{doctorId}")
	public ResponseEntity<String> removeDoctor(@PathVariable int doctorId) throws IdNotFoundException
	{
		return new ResponseEntity<>(doctorService.removeDoctor(doctorId),HttpStatus.ACCEPTED);
	}
}
