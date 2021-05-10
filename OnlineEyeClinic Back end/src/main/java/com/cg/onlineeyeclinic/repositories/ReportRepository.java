package com.cg.onlineeyeclinic.repositories;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.cg.onlineeyeclinic.entities.Report;

//******************************Report Repository Interface***************************//

public interface ReportRepository extends JpaRepository<Report, Integer>
{
	@Query("from Report where date=?1")
	List<Report> findAllByDate(String date);
	
	@Query("from Report where patient.patientId=?1")
	List<Report> findAllByPatientId(int patientId);
}
