package com.cg.onlineeyeclinic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.repositories.AdminRepository;
import com.cg.onlineeyeclinic.repositories.DoctorRepository;
import com.cg.onlineeyeclinic.repositories.PatientRepository;

//******************************Login Service Implementation Class***************************//

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private PatientRepository patientRepository;
	
	String detail1="username exist but password didn't match";
	String detail2="you are logged in as ";
	String detail3="username not found,please register first !!!!!!";
	
	//admin login method
	@Override
	public String adminLogin(String username, String password) 
	{
		List<Admin> admins=adminRepository.findAll();
		for(Admin admin:admins)
		{
			if(admin.getUsername().equals(username))
			{
				if(admin.getPassword().equals(password))
				{
					return detail2+username; 
				}
				else 
				{
					return detail1;
				}
			}
			else
			{
				continue;
			}
		}
		return detail3;
	}

	//patient login method
	@Override
	public String patientLogin(String username, String password) 
	{	
		List<Patient> patients=patientRepository.findAll();
		for(Patient patient:patients)
		{
			if(patient.getUserName().equals(username))
			{
				if(patient.getPassword().equals(password))
				{
					return detail2+username; 
				}
				else
				{
					return detail1;
				}
			}
			else
			{
				continue;
			}
		}
		return detail3;
	}

	//doctor login method
	@Override
	public String doctorLogin(String username, String password) 
	{
		List<Doctor> doctors=doctorRepository.findAll();
		for(Doctor doctor:doctors)
		{
			if(doctor.getUserName().equals(username))
			{
				if(doctor.getPassword().equals(password))
				{
					return detail2+username; 
				}
				else 
				{
					return detail1;
				}
			}
			else
			{
				continue;
			}
		}
		return detail3;
	}
}
