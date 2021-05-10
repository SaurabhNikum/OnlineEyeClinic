package com.cg.onlineeyeclinic.services;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Appointment;
import com.cg.onlineeyeclinic.entities.Doctor;
import com.cg.onlineeyeclinic.exceptions.AppointmentNotFoundException;
import com.cg.onlineeyeclinic.exceptions.DoctorNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.repositories.DoctorRepository;

//******************************Doctor Service Implementation Class***************************//

@Service
public class DoctorServiceImpl implements DoctorService 
{
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AppointmentService appointmentService;
	
	String detail="No doctor is available with the given id";
	
	//add doctor
	@Override
	public Doctor addDoctor(Doctor doctor) throws UserNameAlreadyExistException
	{
		List<Doctor> doctors=doctorRepository.findAll();
		for(Doctor dc:doctors)
		{
			if(dc.getUserName().equals(doctor.getUserName()))
			{
				throw new UserNameAlreadyExistException("provided username is already taken...Please modify your username !");
			}
		}
		return doctorRepository.save(doctor);
	}
	
	//get doctor
	@Override
	public Doctor getDoctor(int doctorId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()-> new IdNotFoundException(detail);
		return doctorRepository.findById(doctorId).orElseThrow(supplier);
	}
	
	
	//get doctors list
	@Override
	public List<Doctor> getAllDoctor() throws DoctorNotFoundException
	{
		if(doctorRepository.findAll().isEmpty())
		{
			throw new DoctorNotFoundException("currently no doctor is available");
		}
		return doctorRepository.findAll();
	}
	
	//update doctor details
	@Override
	public Doctor updateDoctor(int doctorId, Doctor doctor) throws IdNotFoundException, UserNameAlreadyExistException {
		Supplier<IdNotFoundException> supplier = () -> new IdNotFoundException(detail);
		Doctor updatedDoctor = doctorRepository.findById(doctorId).orElseThrow(supplier);
		updatedDoctor.setName(doctor.getName());
		List<Doctor> doctors = doctorRepository.findAll();
		for (Doctor dc : doctors) {
			if (dc != doctor) {
				if (dc.getUserName().equals(doctor.getUserName())) {
					throw new UserNameAlreadyExistException("username already exist.....Please modify your username !");
				}
			} else {
				updatedDoctor.setUserName(doctor.getUserName());
			}
		}
		updatedDoctor.setPassword(doctor.getPassword());
		updatedDoctor.setEmail(doctor.getEmail());
		updatedDoctor.setAddress(doctor.getAddress());
		updatedDoctor.setMobile(doctor.getMobile());
		updatedDoctor.setConsultationTime(doctor.getConsultationTime());
		return doctorRepository.save(updatedDoctor);
	}

	//remove doctor
	@Override
	public String removeDoctor(int doctorId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()-> new IdNotFoundException(detail);
		Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(supplier);
		List<Appointment> appointments=doctor.getAppointments();
		for(Appointment appointment:appointments )
		{
			appointment.setDoctor(null);
			appointment.setPatient(null);
		}
		doctorRepository.delete(doctor);
		return "doctor has been removed successfully";
	}
	
	//get appointment list for doctor
	@Override
	public List<Appointment> getAllAppointmentByDoctorId(int doctorId) throws IdNotFoundException, AppointmentNotFoundException
	{
		return appointmentService.getAllAppointmentByDoctorId(doctorId);
	}

	//get all doctors by same name
	@Override
	public List<Doctor> getAllDoctorsByName(String name) throws NameNotFoundException
	{
		List<Doctor> doctors=doctorRepository.findAllByName(name);
		if(doctors.isEmpty())
		{
			throw new NameNotFoundException("no doctor is available with name : "+name);
		}
		return doctors;
	}
	
}
