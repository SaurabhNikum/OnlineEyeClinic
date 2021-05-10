package com.cg.onlineeyeclinic.services;

import java.util.List;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;

//******************************Appointment Service Interface***************************//

public interface AppointmentService {

	//book appointment
	Appointment bookAppointment(Appointment appointment) throws IdNotFoundException;

	//get appointment
	Appointment getAppointment(int appointmentId) throws IdNotFoundException;

	//get appointment list
	List<Appointment> getAllAppointment() throws AppointmentNotFoundException;

	//get appointment list for doctor
	List<Appointment> getAllAppointmentByDoctorId(int doctorId) throws IdNotFoundException, AppointmentNotFoundException;
	
	//get appointment list for patient
	List<Appointment> getAllAppointmentByPatientId(int patientId) throws IdNotFoundException, AppointmentNotFoundException;
		
	//cancel appointment
	String cancelAppointment(int appointmentId) throws IdNotFoundException;

}