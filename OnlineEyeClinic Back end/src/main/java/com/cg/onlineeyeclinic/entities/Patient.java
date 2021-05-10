package com.cg.onlineeyeclinic.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;

//************************************Patient Entity Class**************************************//

@Entity
public class Patient 
{
	//patient attributes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Patient_Id")
	private int patientId;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Age")
	private int age;
	
	@Column(name="Mobile_Number")
	private String mobile;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Username")
	private String userName;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Address")
	private String address;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="patient")
	private List<Report> reports;
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="patient")
	private List<Appointment> appointments;
	
	
	//getters and setters 
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	
	public List<Report> getReports() {
		return reports;
	}
	
	public void setReports(List<Report> reports) {
		this.reports = reports;
	}
	public String getName() {
		return name;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//constuctors
	public Patient(int patientId, String name, int age, String mobile, String email, String userName, String password,
			String address) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.address = address;
	}

	public Patient() {
		super();
	}
	
	
	
}
