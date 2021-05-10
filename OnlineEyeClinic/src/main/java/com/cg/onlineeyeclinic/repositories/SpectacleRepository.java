package com.cg.onlineeyeclinic.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineeyeclinic.entities.Spectacle;

//******************************Spectacle Repository Interface***************************//

public interface SpectacleRepository extends JpaRepository<Spectacle, Integer>{

	List<Spectacle> findAllByModel(String model);
}
