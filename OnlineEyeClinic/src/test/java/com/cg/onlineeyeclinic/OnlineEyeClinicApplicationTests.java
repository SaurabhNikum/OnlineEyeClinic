package com.cg.onlineeyeclinic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.entities.Tests;
import com.cg.onlineeyeclinic.exceptions.AdminNotFoundException;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.DoctorNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.PatientNotFoundException;
import com.cg.onlineeyeclinic.exceptions.ReportNotFoundException;
import com.cg.onlineeyeclinic.exceptions.SpectacleNotFoundException;
import com.cg.onlineeyeclinic.exceptions.TestNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.repositories.AdminRepository;
import com.cg.onlineeyeclinic.repositories.AppointmentRepository;
import com.cg.onlineeyeclinic.repositories.DoctorRepository;
import com.cg.onlineeyeclinic.repositories.PatientRepository;
import com.cg.onlineeyeclinic.repositories.ReportRepository;
import com.cg.onlineeyeclinic.repositories.SpectacleRepository;
import com.cg.onlineeyeclinic.repositories.TestRepository;
import com.cg.onlineeyeclinic.services.AdminService;
import com.cg.onlineeyeclinic.services.AppointmentService;
import com.cg.onlineeyeclinic.services.DoctorService;
import com.cg.onlineeyeclinic.services.PatientService;
import com.cg.onlineeyeclinic.services.ReportService;
import com.cg.onlineeyeclinic.services.SpectacleService;
import com.cg.onlineeyeclinic.services.TestService;

@SpringBootTest
class OnlineEyeClinicApplicationTests 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private DoctorService doctorService; 
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private SpectacleService spectacleService;	
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private AppointmentService appointmentService;

	@MockBean	
	private AdminRepository adminRepository;
	
	@MockBean
	private DoctorRepository doctorRepository;
	
	@MockBean	
	private PatientRepository patientRepository;
	
	@MockBean	
	private ReportRepository reportRepository;
	
	@MockBean	
	private SpectacleRepository spectacleRepository;
	
	@MockBean	
	private TestRepository testRepository;
	
	@MockBean	
	private AppointmentRepository appointmentRepository;
	
	
	//************************************Test Methods For DoctorServices************************************//
	
	
		@Test
		void addDoctorTest() throws UserNameAlreadyExistException, DoctorNotFoundException 
		{
			Doctor doctor = new Doctor(1,"Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune");
			when(doctorRepository.save(doctor)).thenReturn(doctor);
			assertEquals(doctor, doctorService.addDoctor(doctor));
		}
		
		@Test
		void getAllDoctorByNameTest() throws NameNotFoundException 
		{
			when(doctorRepository.findAllByName("Pranya")).thenReturn(Stream
			.of(new Doctor(999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune"), 
					new Doctor(9999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune")).collect(Collectors.toList()));
			assertNotEquals(3, doctorService.getAllDoctorsByName("Pranya").size());
		}
		
		@Test
		void getAllDoctorTest() throws DoctorNotFoundException 
		{
			when(doctorRepository.findAll()).thenReturn(Stream
			.of(new Doctor(999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune"), 
					new Doctor(9999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune")).collect(Collectors.toList()));
			assertEquals(2, doctorService.getAllDoctor().size());
		}
		
		@Test
		void getDoctorTest() throws IdNotFoundException 
		{
			Doctor doctor = new Doctor(999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune");
			Optional<Doctor> oDoctor=Optional.ofNullable(doctor);
			when(doctorRepository.findById(999)).thenReturn(oDoctor);		
			assertEquals(doctor, doctorService.getDoctor(999));
		}
	
		
	
		//************************************Test Methods For PatientServices************************************//
		
		@Test
		void getPatientTest() throws IdNotFoundException 
		{
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Optional<Patient> patient1=Optional.ofNullable(patient);
			when(patientRepository.findById(999)).thenReturn(patient1);
			assertEquals(patient, patientService.getPatient(999));
		}
		
		@Test
		void addPatinetTest() throws UserNameAlreadyExistException, PatientNotFoundException
		{
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			when(patientRepository.findAll()).thenReturn(Stream
			.of(new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","patient@123","Doctor@123","Pune")).collect(Collectors.toList()));
			when(patientRepository.save(patient)).thenReturn(patient);
			assertEquals(patient, patientService.addPatinet(patient));
		}
		
		@Test
		void getAllPatientTest() throws PatientNotFoundException
		{
			when(patientRepository.findAll()).thenReturn(Stream
			.of(new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune"), 
				new Patient(9999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune"))
			.collect(Collectors.toList()));
			assertEquals(2, patientService.getAllPatient().size());
		}
		
		
		
		@Test
		void showAllPatientByNameTest() throws NameNotFoundException
		{
			when(patientRepository.findAllByName("Pranya")).thenReturn(Stream
			.of(new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune"),
					new Patient(9999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune")).collect(Collectors.toList()));
			assertEquals(2, patientService.getAllPatientsByName("Pranya").size());
		}
	
	
	
		//************************************Test Methods For AppointmentServices************************************//
		
		@Test
		void getAllAppointmentTest() throws AppointmentNotFoundException
		{
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Doctor doctor = new Doctor(999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune");
			Appointment appointment=new Appointment(1,LocalDate.of(2021, 05, 21),LocalTime.of(10, 30, 0),1000,patient,doctor);
			when(appointmentRepository.findAll()).thenReturn(Stream.of(appointment,appointment).collect(Collectors.toList()));
			assertNotEquals(1,appointmentService.getAllAppointment().size());
		}
		
		@Test
		void getAppointmentTest() throws IdNotFoundException
		{
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Doctor doctor = new Doctor(999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune");
			Appointment appointment=new Appointment(1,LocalDate.of(2021, 05, 21),LocalTime.of(10, 30, 0),1000,patient,doctor);
			Optional<Appointment> oAppointment=Optional.ofNullable(appointment);
			when(appointmentRepository.findById(1)).thenReturn(oAppointment);
			assertEquals(appointment,appointmentService.getAppointment(1));
		}
		
		@Test
		void cancelAppointmentTest() throws IdNotFoundException
		{
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Doctor doctor = new Doctor(999, "Pranya","doctor123","doctor@123","doctor@gmail.com","11:30 to 6:00","9039341634l","Pune");
			Appointment appointment=new Appointment(1,LocalDate.of(2021, 05, 21),LocalTime.of(10, 30, 0),1000,patient,doctor);
			Optional<Appointment> oAppointment=Optional.ofNullable(appointment);
			when(appointmentRepository.findById(1)).thenReturn(oAppointment);
			assertEquals("appointment canceled successfully",appointmentService.cancelAppointment(1));
		}
		
	
		
	
		
		
	//************************************Test Methods For AdminServices************************************//

		@Test
		void addAdminTest() throws UserNameAlreadyExistException 
		{
			Admin admin = new Admin(1,"Pranya234","Pune@123");
			when(adminRepository.save(admin)).thenReturn(admin);
			assertEquals(admin, adminService.addAdmin(admin));
		}
		
		@Test
		void getAllAdminsUsernameTest() throws AdminNotFoundException 
		{
			when(adminRepository.findAll()).thenReturn(Stream
			.of(new Admin(2,"Danile123","USa@123"), new Admin(1,"Huy1234","UKk@1234")).collect(Collectors.toList()));
			assertNotEquals(1, adminService.getAdminsUsername().size());
		}
		
		@Test
		void getAllAdminsTest() throws AdminNotFoundException 
		{
			when(adminRepository.findAll()).thenReturn(Stream
			.of(new Admin(2,"Danile123","USa@123"), new Admin(1,"Huy1234","UKk@1234")).collect(Collectors.toList()));
			assertEquals(2, adminService.getAllAdmins().size());
		}
		
		@Test
		void getAdminTest() throws IdNotFoundException
		{
			Admin admin=new Admin(1,"daniel","ADsgt#12");
			Optional<Admin> oAdmin=Optional.ofNullable(admin);
			when(adminRepository.findById(admin.getId())).thenReturn(oAdmin);
			assertEquals(admin,adminService.getAdmin(1));
		}
		
		@Test
		void removeAdminTest() throws IdNotFoundException
		{
			Admin admin=new Admin(1,"daniel","ADsgt#12");
			Optional<Admin> admin1=Optional.ofNullable(admin);
			when(adminRepository.findById(admin.getId())).thenReturn(admin1);
			assertEquals("admin removed successfully",adminService.removeAdmin(1));	
		}
		
		
		
		//************************************Test Methods For SpectacleServices************************************//
		
		@Test
		void addSpectacleTest()
		{
			Spectacle spectacle= new Spectacle(999, "3d glass","2.0 high",550d);
			when(spectacleRepository.save(spectacle)).thenReturn(spectacle);
			assertEquals(spectacle, spectacleService.addSpectacle(spectacle));
		}
		
		@Test
		void getAllSpectacleTest() throws SpectacleNotFoundException
		{
			when(spectacleRepository.findAll()).thenReturn(Stream.of(new Spectacle(999, "3d glass","2.0 high",550d), 
				new Spectacle(999, "3d glass","2.0 high",550d)).collect(Collectors.toList()));
			assertEquals(2, spectacleService.getAllSpectacle().size());
		}
		

		@Test
		void getSpectacleTest() throws IdNotFoundException
		{
			Spectacle spectacle= new Spectacle(999, "3d glass","2.0 high",550d);
			Optional<Spectacle> oSpectacle=Optional.ofNullable(spectacle);
			when(spectacleRepository.findById(999)).thenReturn(oSpectacle);
			assertEquals(spectacle,spectacleService.getSpectacle(999));
		}
		
		@Test
		void getAllSpectacleByModelTest()
		{
			when(spectacleRepository.findAllByModel("3D model glass")).thenReturn(Stream
			.of(new Spectacle(999, "3d glass","2.0 high",550d), new Spectacle(999, "3d glass","2.0 high",550d)).collect(Collectors.toList()));
			assertEquals(2, spectacleService.getAllSpectacleByModel("3D model glass").size());
		}
		
		@Test
		void removeSpectacleTest() throws IdNotFoundException
		{
			Spectacle spectacle= new Spectacle(999, "3d glass","2.0 high",550d);
			Optional<Spectacle> oSpectacle=Optional.ofNullable(spectacle);
			when(spectacleRepository.findById(999)).thenReturn(oSpectacle);
			assertEquals("spectacle is removed successfully",spectacleService.removeSpectacle(999));
		}
		

		
		
		//************************************Test Methods For TestServices************************************//
		
		@Test
		void addTestTest()
		{
			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			when(testRepository.save(test)).thenReturn(test);
			assertEquals(test, testService.addTest(test));
		}
		
		@Test
		void showAllTestTest() throws TestNotFoundException
		{
			when(testRepository.findAll()).thenReturn(Stream
			.of(new Tests(999, "virus","pnemonia","normal ",550d), 
			new Tests(9999, "virus","pnemonia","normal ",550d)).collect(Collectors.toList()));
			assertEquals(2, testService.showAllTest().size());
		}	
		
		@Test
		void showAllTestByNameTest() throws NameNotFoundException
		{
			when(testRepository.findAllByName("virus")).thenReturn(Stream
			.of(new Tests(999, "virus","pnemonia","normal ",550d),
			new Tests(9999, "virus","pnemonia","normal ",550d)).collect(Collectors.toList()));
			assertEquals(2, testService.showAllTestByName("virus").size());
		}
		
		@Test
		void getTestTest() throws IdNotFoundException
		{
			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			Optional<Tests> oTest=Optional.ofNullable(test);
			when(testRepository.findById(999)).thenReturn(oTest);
			assertEquals(test, testService.getTest(999));
		}
		
		@Test
		void removeTestTest() throws IdNotFoundException
		{
			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			Optional<Tests> oTest=Optional.ofNullable(test);
			when(testRepository.findById(999)).thenReturn(oTest);
			assertEquals("test deleted successfully", testService.removeTest(999));
		}
		
		
		//************************************Test Methods For ReportServices************************************//
		
		
		@Test
		void createReportTest() throws IdNotFoundException
		{
			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Report report=new Report(1,LocalDate.of(2017, 1, 13),"ss","yy","aa","zz",patient,test);
			Optional<Tests> oTest=Optional.ofNullable(test);
			Optional<Patient> oPatient=Optional.ofNullable(patient);
			when(patientRepository.findById(999)).thenReturn(oPatient);
			when(testRepository.findById(999)).thenReturn(oTest);
			report.setTest(test);
			report.setPatient(patient);
			when(reportRepository.save(report)).thenReturn(report);
			assertEquals(report,reportService.createReport(999, 999, report));
		}
		
		@Test
		void getAllReportTest() throws ReportNotFoundException
		{
			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Report report=new Report(1,LocalDate.of(2017, 1, 13),"ss","yy","aa","zz",patient,test);
			when(reportRepository.findAll()).thenReturn(Stream.of(report,report).collect(Collectors.toList()));
			assertNotEquals(1, reportService.getAllReport().size());
		}
		
		@Test
		void deleteReportTest() throws IdNotFoundException
		{
			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Report report=new Report(1,LocalDate.of(2017, 1, 13),"ss","yy","aa","zz",patient,test);
			Optional<Report> oReport=Optional.ofNullable(report);
			when(reportRepository.findById(1)).thenReturn(oReport);
			assertEquals("report deleted successfully",reportService.deleteReport(1));
		}
		
		@Test
		void getReportTest() throws IdNotFoundException
		{

			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			Patient patient= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Report report1=new Report(1,LocalDate.of(2017, 1, 13),"ss","yy","aa","zz",patient,test);
			Report report2=new Report(2,LocalDate.of(2017, 1, 13),"ss","yy","aa","zz",patient,test);
			Optional<Report> oReport=Optional.ofNullable(report1);
			when(reportRepository.findById(1)).thenReturn(oReport);
			assertNotEquals(report2,reportService.getReport(1));
		}
		
		@Test
		void updateReportTest() throws IdNotFoundException
		{
			Tests test= new Tests(999, "virus","pnemonia","normal ",550d);
			Patient patient1= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Patient patient2= new Patient(999, "Pranya",22,"9039341634l","doctor@gmail.com","doctor@123","Doctor@123","Pune");
			Optional<Patient> oPatient=Optional.ofNullable(patient1);
			Optional<Tests> oTest=Optional.ofNullable(test);
			when(patientRepository.findById(999)).thenReturn(oPatient);
			when(testRepository.findById(999)).thenReturn(oTest);
			Report report=new Report(1,LocalDate.of(2017, 1, 13),"ss","yy","aa","zz",patient1,test);
			Optional<Report> oReport=Optional.ofNullable(report);
			when(reportRepository.findById(1)).thenReturn(oReport);
			report.setPatient(patient2);
			when(reportRepository.save(report)).thenReturn(report);
			assertEquals(report,reportService.updateReport(999, 999, report));
		}
		
		

}