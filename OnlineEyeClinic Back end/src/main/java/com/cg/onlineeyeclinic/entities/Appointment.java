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
	
	@Column(name="Patient_Id")
	private int patientId;
	
	@Column(name="Patient_Email")
	private String patientEmail;
	
	@Column(name="Doctor_Id")
	private int doctorId;
	
	
	@Column(name="Appointment_Date")
	private LocalDate appointmentDate;
	
	@Column(name="Appointment_Time")
	private LocalTime appointmentTime;
	

	@Column(name="Fee")
	private double consultationFee;
	
	@Column(name="Appointment_Request")
	private boolean appointmentRequest;
	
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Patient patient;
	
	@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Doctor doctor;

	
	
	//getters and setters
	
	
	 
	public int getId() {
		return id;
	}
	
	public String getPatientEmail() {
		return patientEmail;
	}

	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}

	public boolean isAppointmentRequest() {
		return appointmentRequest;
	}

	public void setAppointmentRequest(boolean appointmentRequest) {
		this.appointmentRequest = appointmentRequest;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
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
