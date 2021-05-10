package com.cg.onlineeyeclinic.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.onlineeyeclinic.entities.Tests;

//******************************Test Repository Interface***************************//

public interface TestRepository extends JpaRepository<Tests, Integer>{

	List<Tests> findAllByName(String name);
	
}
