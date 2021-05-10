package com.cg.onlineeyeclinic.services;


import java.util.List;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.ReportNotFoundException;

//******************************Report Service Interface***************************//

public interface ReportService {

	//add report
	Report createReport(int patientId, int testId, Report report) throws IdNotFoundException;

	//get report
	Report getReport(int reportId) throws IdNotFoundException;

	//get report list
	List<Report> getAllReport() throws ReportNotFoundException;

	//update report 
	Report updateReport(int patientId, int testId, Report report) throws IdNotFoundException;

	//remove report
	String deleteReport(int reportId) throws IdNotFoundException;
	
	//get all report for a patient
	List<Report> getAllReportByPatientId(int patientId) throws IdNotFoundException, ReportNotFoundException;

}