package com.cg.onlineeyeclinic.services;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.entities.Tests;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.ReportNotFoundException;
import com.cg.onlineeyeclinic.repositories.PatientRepository;
import com.cg.onlineeyeclinic.repositories.ReportRepository;
import com.cg.onlineeyeclinic.repositories.TestRepository;

//******************************Report Service Implementation Class***************************//

@Service
public class ReportServiceImpl implements ReportService 
{
	@Autowired
	private ReportRepository reportRepository;
	
	@Autowired 
	private PatientRepository patientRepository;
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private PatientService patientService;
	
	String detail="Report with given id is not available";
	
	//add report
	@Override
	public Report createReport(int patientId,int testId,Report report) throws IdNotFoundException
	{
		Patient patient;
		Tests test;
		List<Report> reportList=new ArrayList<>();
		Supplier<IdNotFoundException> supplier1 = ()->new IdNotFoundException("Patient with given id : "+patientId+" is not available");
		patient=patientRepository.findById(patientId).orElseThrow(supplier1);
		Supplier<IdNotFoundException> supplier2=()->new IdNotFoundException("test with given id : "+testId+" is not available");
		test=testRepository.findById(testId).orElseThrow(supplier2);
		report.setPatient(patient);
		report.setTest(test);
		report=reportRepository.save(report);
		reportList.add(report);
		patient.setReports(reportList);
		return report;
	}
	
	//get report
	@Override
	public Report getReport(int reportId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier = ()->new IdNotFoundException(detail);
		return reportRepository.findById(reportId).orElseThrow(supplier);
	}
	
	//get report list
	@Override
	public List<Report> getAllReport() throws ReportNotFoundException
	{
		if(reportRepository.findAll().isEmpty())
		{
			throw new ReportNotFoundException("currently no report is available");
		}
		return reportRepository.findAll();
	}
	
	//update report 
	  @Override
	public Report updateReport(int patientId,int testId,Report report) throws IdNotFoundException 
	{
	  Patient patient;
	  Tests test;
	  List<Report> reportList=new ArrayList<>();
	  Supplier<IdNotFoundException> supplier1 = ()->new IdNotFoundException("Patient with given id is not available");
	  patient=patientRepository.findById(patientId).orElseThrow(supplier1);
	  Supplier<IdNotFoundException> supplier2=()->new IdNotFoundException("test with given id is not available");
	  test=testRepository.findById(testId).orElseThrow(supplier2);
	  Supplier<IdNotFoundException> supplier = ()->new IdNotFoundException(detail); 
	  Report updatedReport=reportRepository.findById(report.getId()).orElseThrow(supplier);
	  updatedReport.setReportDate(report.getReportDate());
	  updatedReport.setDescription(report.getDescription());
	  updatedReport.setPatient(patient);
	  updatedReport.setTest(test);
	  updatedReport.setVisualAcuity(report.getVisualAcuity());
	  updatedReport.setVisualAcuityForNear(report.getVisualAcuityForNear());
	  updatedReport.setVisualAcuityForDistance(report.getVisualAcuityForDistance()); 
	  reportList.add(reportRepository.save(updatedReport));
	  patient.setReports(reportList);
	  return reportRepository.save(updatedReport); 
  }
	 
	
	//remove report
	@Override
	public String deleteReport(int reportId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier = ()->new IdNotFoundException(detail);
		Report report=reportRepository.findById(reportId).orElseThrow(supplier);
		report.setPatient(null);
		report.setTest(null);
		reportRepository.delete(report);
		return "report deleted successfully";
	}
	
	//get all report by patient id
	@Override
	public List<Report> getAllReportByPatientId(int patientId) throws IdNotFoundException, ReportNotFoundException
	{
		patientService.getPatient(patientId);
		if(reportRepository.findAllByPatientId(patientId).isEmpty())
		{
			throw new ReportNotFoundException("no report is available with the entered id");
		}
		return reportRepository.findAllByPatientId(patientId);
	}
}
