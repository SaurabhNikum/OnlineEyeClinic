package com.cg.onlineeyeclinic.services;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.repositories.AppointmentRepository;
import com.cg.onlineeyeclinic.repositories.DoctorRepository;
import com.cg.onlineeyeclinic.repositories.PatientRepository;

//******************************Appointment Service Implementation Class***************************//

@Service
public class AppointmentServiceImpl implements AppointmentService 
{
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	//book appointment
	@Override
	public Appointment bookAppointment(Appointment  appointment) throws IdNotFoundException
	{
		Patient patient;
		Doctor doctor;
		List<Appointment> appointments=new ArrayList<>();
		Supplier<IdNotFoundException> supplier1 = ()->new IdNotFoundException("Patient with id is not available");
		patient=patientRepository.findById(appointment.getPatientId()).orElseThrow(supplier1);
		Supplier<IdNotFoundException> supplier2 = ()->new IdNotFoundException("Doctor with id is not available");
		doctor=doctorRepository.findById(appointment.getDoctorId()).orElseThrow(supplier2);
		appointment.setDoctor(doctor);
		appointment.setPatient(patient);
		appointmentRepository.save(appointment);
		appointments.add(appointment);
		patient.setAppointments(appointments);
		doctor.setAppointments(appointments);
		return appointment;
	}
	
	//get appointment
	@Override
	public Appointment getAppointment(int appointmentId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()-> new IdNotFoundException("No appointment is available with the given id : "+appointmentId);
		return appointmentRepository.findById(appointmentId).orElseThrow(supplier);
	}

	

	//get appointment list for doctor
	@Override
	public List<Appointment> getAllAppointmentByDoctorId(int doctorId) throws IdNotFoundException, AppointmentNotFoundException
	{
		doctorService.getDoctor(doctorId);
		if(appointmentRepository.findAllAppointmentByDoctorId(doctorId).isEmpty())
		{
			throw new AppointmentNotFoundException("No appointement is available for entered doctor id : "+doctorId);
		}
		return appointmentRepository.findAllAppointmentByDoctorId(doctorId);
	}
	
	//cancel appointment
	@Override
	public String cancelAppointment(int appointmentId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()-> new IdNotFoundException("No appointment is available with the given appointment id : "+appointmentId);
		Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow(supplier);
		appointment.setDoctor(null);
		appointment.setPatient(null);
		appointmentRepository.delete(appointment);
		return("appointment canceled successfully");
	}
	
	//get appointment list for patient
	@Override
	public List<Appointment> getAllAppointmentByPatientId(int patientId) throws IdNotFoundException, AppointmentNotFoundException 
	{
		patientService.getPatient(patientId);
		if(appointmentRepository.findAllAppointmentByPatientId(patientId).isEmpty())
		{
			throw new AppointmentNotFoundException("No Appointment is available for entered patient id : "+patientId);
		}
		return appointmentRepository.findAllAppointmentByPatientId(patientId);
	}

	//get appointment list
	@Override
	public List<Appointment> getAllAppointment() throws AppointmentNotFoundException
	{
		if(appointmentRepository.findAll().isEmpty())
		{
			throw new AppointmentNotFoundException("currently no appointments are fixed");
		}
		return appointmentRepository.findAll();
	}
	
}
