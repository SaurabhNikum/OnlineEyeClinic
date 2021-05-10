package com.cg.onlineeyeclinic.services;

import java.util.List;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.DoctorNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;

//******************************Doctor Service Interface***************************//

public interface DoctorService{

	//add doctor
	Doctor addDoctor(Doctor doctor) throws UserNameAlreadyExistException;

	//get doctor
	Doctor getDoctor(int doctorId) throws IdNotFoundException;

	//get doctors list
	List<Doctor> getAllDoctor() throws DoctorNotFoundException;
	
	//get all doctors having same name
	List<Doctor> getAllDoctorsByName(String name) throws NameNotFoundException;

	//update doctor details
	Doctor updateDoctor(int doctorId,Doctor doctor) throws IdNotFoundException, UserNameAlreadyExistException;

	//remove doctor
	String removeDoctor(int doctorId) throws IdNotFoundException;

	//get appointment list for doctor
	List<Appointment> getAllAppointmentByDoctorId(int doctorId) throws IdNotFoundException, AppointmentNotFoundException;

}