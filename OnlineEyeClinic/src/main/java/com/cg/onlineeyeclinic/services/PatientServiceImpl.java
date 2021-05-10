package com.cg.onlineeyeclinic.services;


import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.entities.Tests;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.PatientNotFoundException;
import com.cg.onlineeyeclinic.exceptions.ReportNotFoundException;
import com.cg.onlineeyeclinic.exceptions.SpectacleNotFoundException;
import com.cg.onlineeyeclinic.exceptions.TestNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.repositories.PatientRepository;

//******************************Patient Service Implementation Class***************************//

@Service
public class PatientServiceImpl implements PatientService 
{
	@Autowired
	private PatientRepository patientRepository;
	
	@Autowired
	private AppointmentService appointmentService;
	
	@Autowired 
	private ReportService reportService;
	
	@Autowired
	private TestService testService; 
	
	@Autowired
	private SpectacleService spectacleService;
	
	String detail="Patient with given id is not available";
	
	//get patient method
	@Override
	public Patient getPatient(int patientId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier = ()->new IdNotFoundException(detail);
		return patientRepository.findById(patientId).orElseThrow(supplier);
	}
	
	//get patient list
	@Override
	public List<Patient> getAllPatient() throws PatientNotFoundException
	{
		if( patientRepository.findAll().isEmpty())
		{
			throw new PatientNotFoundException("currently no patient is availabe");
		}
		return patientRepository.findAll();
	}
	
	//add patient
	@Override
	public Patient addPatinet(Patient patient) throws UserNameAlreadyExistException
	{
		List<Patient> patients=patientRepository.findAll();
		for(Patient pt:patients)
		{
			if(pt.getUserName().equals(patient.getUserName()))
			{
				throw new UserNameAlreadyExistException("provided username is already taken....Please modify your username !");
			}
		}
		return patientRepository.save(patient);
	}
	
	//update details for patient
	@Override
	public Patient updatePatient(int patientId,Patient patient) throws IdNotFoundException, UserNameAlreadyExistException
	{
			Supplier<IdNotFoundException> supplier = ()->new IdNotFoundException(detail);
			Patient updatedPatient = patientRepository.findById(patientId).orElseThrow(supplier);
			updatedPatient.setName(patient.getName());
			List<Patient> patients = patientRepository.findAll();
			for (Patient pt : patients) {
				if (pt != patient) {
					if (pt.getUserName().equals(patient.getUserName())) {
						throw new UserNameAlreadyExistException("username already exist.....Please modify your username !");
					}
				} else {
					updatedPatient.setUserName(patient.getUserName());
				}
			}
			updatedPatient.setUserName(patient.getUserName());
			updatedPatient.setPassword(patient.getPassword());
			updatedPatient.setAge(patient.getAge());
			updatedPatient.setEmail(patient.getEmail());
			updatedPatient.setAddress(patient.getAddress());
			updatedPatient.setMobile(patient.getMobile());
			return patientRepository.save(updatedPatient);
	}
	
	//remove patient
	@Override
	public String deletePatient(int patientId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier = ()->new IdNotFoundException(detail);
		Patient patient=patientRepository.findById(patientId).orElseThrow(supplier);
		List<Appointment> appointments=patient.getAppointments();
		for(Appointment appointment: appointments)
		{
			appointment.setPatient(null);
			appointment.setDoctor(null);
		}
		List<Report> reports=patient.getReports();
		for(Report report:reports)
		{
			report.setPatient(null);
			report.setTest(null);
		}
		patientRepository.delete(patient); 
		return "patient deleted successfully"; 
	}
	
	
	
					
	//get all report
		@Override
		public List<Report> getAllReportByPatientId(int patientId) throws IdNotFoundException, ReportNotFoundException
		{
			return reportService.getAllReportByPatientId(patientId);
		}

		//get patient by name method
		@Override
		public List<Patient> getAllPatientsByName(String name)throws NameNotFoundException 
		{
			List<Patient> patients=patientRepository.findAllByName(name);
			if(patients.isEmpty())
			{
				throw new NameNotFoundException("no patient is available with this name");
			}
			return patients;
		}

		//get appointment list for patient
		@Override
		public List<Appointment> getAllAppointmentByPatientId(int patientId) throws IdNotFoundException, AppointmentNotFoundException 
		{
			return appointmentService.getAllAppointmentByPatientId(patientId);
		}

		//get all test method
		@Override
		public List<Tests> getAllTest() throws TestNotFoundException 
		{
			
			return testService.showAllTest();
		}

		//get all spectacle method
		@Override
		public List<Spectacle> getAllSpectacles() throws SpectacleNotFoundException {
			
			return spectacleService.getAllSpectacle();
		}
		
}
