package com.cg.onlineeyeclinic.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineeyeclinic.entities.Doctor;

//******************************Doctor Repository Interface***************************//

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

	List<Doctor> findAllByName(String name);
}
