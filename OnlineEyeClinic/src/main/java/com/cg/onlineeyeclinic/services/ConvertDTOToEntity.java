package com.cg.onlineeyeclinic.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.onlineeyeclinic.dto.AdminDTO;
import com.cg.onlineeyeclinic.dto.AppointmentDTO;
import com.cg.onlineeyeclinic.dto.DoctorDTO;
import com.cg.onlineeyeclinic.dto.PatientDTO;
import com.cg.onlineeyeclinic.dto.ReportDTO;
import com.cg.onlineeyeclinic.dto.SpectacleDTO;
import com.cg.onlineeyeclinic.dto.TestDTO;
import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.entities.Patient;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.entities.Tests;

//******************************Class for converting DTO to Entity***************************//

@Service
public class ConvertDTOToEntity 
{
	@Autowired
	ModelMapper modelMapper;
	
	//convert patientDTO to patient
	public Patient convertToPatient(PatientDTO patientDTO)
	{
		return modelMapper.map(patientDTO, Patient.class);
	}

	//convert TestDTO to Tests
	public Tests convertToTests(TestDTO testDTO)
	{
		return modelMapper.map(testDTO, Tests.class);
	}
	
	//convert AdminDTO to Admin
	public Admin convertToAdmin(AdminDTO adminDTO)
	{
		return modelMapper.map(adminDTO, Admin.class);
	}
	
	//convert AppointmentDTO to Appointment
	public Appointment convertToAppointment(AppointmentDTO appointmentDTO)
	{
		return modelMapper.map(appointmentDTO, Appointment.class);
	}
	
	//convert SoectacleDTO to Spectacle
	public Spectacle convertToSpectacle(SpectacleDTO spectacleDTO)
	{
		return modelMapper.map(spectacleDTO, Spectacle.class);
	}
	
	//convert DoctorDTO to Doctor
	public Doctor convertToDoctor(DoctorDTO doctorDTO)
	{
		return modelMapper.map(doctorDTO, Doctor.class);
	}
	
	//convert ReportDTO to Report
	public Report convertToReport(ReportDTO reportDTO)
	{
		return modelMapper.map(reportDTO, Report.class);
	}
}
