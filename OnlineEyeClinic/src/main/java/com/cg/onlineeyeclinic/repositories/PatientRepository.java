package com.cg.onlineeyeclinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineeyeclinic.entities.Patient;

//******************************Patient Repository Interface***************************//

public interface PatientRepository extends JpaRepository<Patient, Integer>{

	List<Patient> findAllByName(String name);
}
