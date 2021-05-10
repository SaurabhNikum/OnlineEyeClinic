package com.cg.onlineeyeclinic.services;


import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;

//******************************Registration Service Interface***************************//

public interface RegistrationService {
	
	//register patient
	Patient registerPatient(Patient patient) throws UserNameAlreadyExistException;

	//register doctor
	Doctor registerDoctor(Doctor doctor) throws UserNameAlreadyExistException;

	//register admin
	Admin registerAdmin(Admin admin) throws UserNameAlreadyExistException;

}