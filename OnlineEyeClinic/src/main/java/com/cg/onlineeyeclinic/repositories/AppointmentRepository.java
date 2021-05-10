package com.cg.onlineeyeclinic.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.onlineeyeclinic.entities.Appointment;

//******************************Appointment Repository Interface***************************//

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>
{
	
	@Query("from Appointment where doctor.doctorId=?1")
	List<Appointment> findAllAppointmentByDoctorId(int doctorId);
	
	@Query("from Appointment where patient.patientId=?1")
	List<Appointment> findAllAppointmentByPatientId(int patientId);
}
