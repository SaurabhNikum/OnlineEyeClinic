package com.cg.onlineeyeclinic.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotNull;


//************************************Report DTO Class**************************************//

public class ReportDTO 
{
	private int id;
	
	@NotNull
	private int patientId;
	
	@NotNull
	private int testId;
	
	@NotNull
	private LocalDate reportDate;
	
	@NotNull
	private String description;
	
	@NotNull
	private String visualAcuity;
	
	@NotNull
	private String visualAcuityForNear;
	
	@NotNull
	private String visualAcuityForDistance;
	
	


	//getters and setters.
		
	public LocalDate getReportDate() {
		return reportDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
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
	
	
	
}