package com.cg.onlineeyeclinic.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



//************************************Appointment Entity Class**************************************//

@Entity
public class Appointment 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Appointment_Id")
	private int id;
	
	
	@Column(name="Appointment_Date")
	private LocalDate appointmentDate;
	
	@Column(name="Appointment_Time")
	private LocalTime appointmentTime;
	

	@Column(name="Fee")
	private double consultationFee;
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Patient patient;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Doctor doctor;

	
	
	//getters and setters
	public int getPatientId()
	{
		return patient.getPatientId();
	}
	
	public int getDoctorId()
	{
		return doctor.getDoctorId();
	}
	 
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getConsultationFee() {
		return consultationFee;
	}

	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}
	
	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(LocalTime appointmentTime) {
		this.appointmentTime = appointmentTime;
	}


	public Patient getPatient() {
		return patient;
	}
	

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	//constructors
	public Appointment() {
		super();
	}

	public Appointment(int id, LocalDate appointmentDate, LocalTime appointmentTime, double consultationFee,
			Patient patient, Doctor doctor) {
		super();
		this.id = id;
		this.appointmentDate = appointmentDate;
		this.appointmentTime = appointmentTime;
		this.consultationFee = consultationFee;
		this.patient = patient;
		this.doctor = doctor;
	}
	
	
	
	
	
}
