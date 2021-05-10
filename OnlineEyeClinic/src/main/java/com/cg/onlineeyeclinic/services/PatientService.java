package com.cg.onlineeyeclinic.services;

import java.util.List;
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

//******************************Patient Service Interface***************************//

public interface PatientService {

	//get a patient
	Patient getPatient(int patientId) throws IdNotFoundException;

	//get patient list
	List<Patient> getAllPatient() throws PatientNotFoundException;

	//add patient
	Patient addPatinet(Patient patient) throws UserNameAlreadyExistException;

	//update details for patient
	Patient updatePatient(int patientId,Patient patient) throws IdNotFoundException, UserNameAlreadyExistException;

	//remove patient
	String deletePatient(int patientId) throws IdNotFoundException;

	//get patient by name
	List<Patient> getAllPatientsByName(String name) throws NameNotFoundException;
	
	//retrieve appointment detail for a patient
	List<Appointment> getAllAppointmentByPatientId(int patientId) throws IdNotFoundException, AppointmentNotFoundException;

	//view all tests available
	List<Tests> getAllTest() throws TestNotFoundException;
	
	//view all spectacles available
	List<Spectacle> getAllSpectacles() throws SpectacleNotFoundException;
	
	//view all report
	List<Report> getAllReportByPatientId(int patientId) throws IdNotFoundException, ReportNotFoundException;

}