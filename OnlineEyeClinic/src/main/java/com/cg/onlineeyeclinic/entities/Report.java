package com.cg.onlineeyeclinic.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

//************************************Report Entity Class**************************************//

@Entity
public class Report 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Report_Id")
	private int id;
	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class) 
	@Column(name="Report_Date")
	private LocalDate reportDate;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Visual_Acuity")
	private String visualAcuity;
	
	@Column(name="Visual_Acuity_For_Near")
	private String visualAcuityForNear;
	
	@Column(name="Visual_Acuity_For_Distance")
	private String visualAcuityForDistance;
	

	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Patient patient;
	
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Tests test;
	
	
	//getters and setters
	public int getPatientId()
	{
		return patient.getPatientId();
	}
	
	public int getTestId()
	{
		return test.getTestId();
	}
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public Tests getTest() {
		return test;
	}
	
	public void setTest(Tests test) {
		this.test = test;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}
	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getVisualAcuity() {
		return visualAcuity;
	}
	public void setVisualAcuity(String visualAcuity) {
		this.visualAcuity = visualAcuity;
	}
	public String getVisualAcuityForNear() {
		return visualAcuityForNear;
	}
	public void setVisualAcuityForNear(String visualAcuityForNear) {
		this.visualAcuityForNear = visualAcuityForNear;
	}
	public String getVisualAcuityForDistance() {
		return visualAcuityForDistance;
	}
	public void setVisualAcuityForDistance(String visualAcuityForDistance) {
		this.visualAcuityForDistance = visualAcuityForDistance;
	}

	
	//constructors
	public Report(int id, LocalDate reportDate, String description, String visualAcuity, String visualAcuityForNear,
			String visualAcuityForDistance, Patient patient, Tests test) {
		super();
		this.id = id;
		this.reportDate = reportDate;
		this.description = description;
		this.visualAcuity = visualAcuity;
		this.visualAcuityForNear = visualAcuityForNear;
		this.visualAcuityForDistance = visualAcuityForDistance;
		this.patient = patient;
		this.test = test;
	}

	public Report() {
		super();
	}
	
	
	

}