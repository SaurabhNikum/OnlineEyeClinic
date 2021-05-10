package com.cg.onlineeyeclinic.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyeclinic.dto.AdminDTO;
import com.cg.onlineeyeclinic.dto.DoctorDTO;
import com.cg.onlineeyeclinic.dto.PatientDTO;
import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.RegistrationService;

//***********************************Registration Controller Class****************************************//

@RestController
@RequestMapping("/register")
public class RegistrationController 
{
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@PostMapping("/patient")
	public ResponseEntity<Patient> registerPatient(@Valid @RequestBody PatientDTO patientDTO) throws UserNameAlreadyExistException
	{
		Patient patient=con.convertToPatient(patientDTO);
		return new ResponseEntity<>(registrationService.registerPatient(patient),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/doctor")
	public ResponseEntity<Doctor> registerDoctor(@Valid @RequestBody DoctorDTO doctorDTO) throws UserNameAlreadyExistException
	{
		Doctor doctor=con.convertToDoctor(doctorDTO);
		return new ResponseEntity<>(registrationService.registerDoctor(doctor),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> registerAdmin(@Valid @RequestBody AdminDTO adminDTO) throws UserNameAlreadyExistException
	{
		Admin admin=con.convertToAdmin(adminDTO);
		return new ResponseEntity<>(registrationService.registerAdmin(admin),HttpStatus.ACCEPTED);
	}
}
