package com.cg.onlineeyeclinic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;

//******************************Registration Service Implementation Class***************************//

@Service
public class RegistrationServiceImpl implements RegistrationService 
{
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private AdminService adminService;
	
	//register patient method
	@Override
	public Patient registerPatient(Patient patient) throws UserNameAlreadyExistException
	{
		return patientService.addPatinet(patient);
	}
	
	//register doctor method
	@Override
	public Doctor registerDoctor(Doctor doctor) throws UserNameAlreadyExistException
	{
		return doctorService.addDoctor(doctor);
	}
	
	//regster admin method
	@Override
	public Admin registerAdmin(Admin admin) throws UserNameAlreadyExistException
	{
		return adminService.addAdmin(admin);
	}
	
}
