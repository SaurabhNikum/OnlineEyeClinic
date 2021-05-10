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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyeclinic.dto.PatientDTO;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.entities.Tests;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.PatientNotFoundException;
import com.cg.onlineeyeclinic.exceptions.ReportNotFoundException;
import com.cg.onlineeyeclinic.exceptions.SpectacleNotFoundException;
import com.cg.onlineeyeclinic.exceptions.TestNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.PatientService;

//***********************************Patient Controller Class****************************************//

@CrossOrigin
@RestController
@RequestMapping("/onlineeyeclinic")
public class PatientController 
{
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ConvertDTOToEntity cnv;
	
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> getPatient(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(patientService.getPatient(id));
	}
	
	@GetMapping("/patient")
	public ResponseEntity<List<Patient>> getAllPatient() throws PatientNotFoundException
	{
		return ResponseEntity.ok(patientService.getAllPatient());
	}
	
	@GetMapping("/patientbyname/{name}")
	public ResponseEntity<List<Patient>> getAllPatientByName(@PathVariable String name) throws NameNotFoundException
	{
		return ResponseEntity.ok(patientService.getAllPatientsByName(name));
	}
	
	@PostMapping("/patient")
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody PatientDTO patientDTO) throws UserNameAlreadyExistException
	{
		Patient patient=cnv.convertToPatient(patientDTO);
		return ResponseEntity.ok(patientService.addPatinet(patient));
	}
	
	@PutMapping("/patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable int id,@Valid @RequestBody PatientDTO patientDTO) throws IdNotFoundException, UserNameAlreadyExistException
	{
		Patient patient=cnv.convertToPatient(patientDTO);
		return ResponseEntity.ok(patientService.updatePatient(id,patient));
	}
	
	@DeleteMapping("/patient/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(patientService.deletePatient(id));
	}
	
	@GetMapping("/testavailable")
	public ResponseEntity<List<Tests>> getAllTests() throws TestNotFoundException
	{
		return new ResponseEntity<>(patientService.getAllTest(),HttpStatus.OK);
	}
	
	@GetMapping("/spectaclesavailable")
	public ResponseEntity<List<Spectacle>> getAllSpectacles() throws SpectacleNotFoundException 
	{
		return new ResponseEntity<>(patientService.getAllSpectacles(),HttpStatus.OK);
	}
	
	@GetMapping("/getreportbypatient/{id}")
	public ResponseEntity<List<Report>> getAllReportByPatientId(@PathVariable int id) throws IdNotFoundException, ReportNotFoundException
	{
		return new ResponseEntity<>(patientService.getAllReportByPatientId(id),HttpStatus.OK);
	}
	
	@GetMapping("/viewappointment/{id}")
	public ResponseEntity<List<Appointment>> getAllAppointmentByPatientId(@PathVariable int id) throws IdNotFoundException, AppointmentNotFoundException
	{
		return new ResponseEntity<>(patientService.getAllAppointmentByPatientId(id),HttpStatus.FOUND);
	}
	
}
