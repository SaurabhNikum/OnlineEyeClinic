package com.cg.onlineeyeclinic.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.onlineeyeclinic.entities.Admin;

//******************************Admin Repository Interface***************************//

public interface AdminRepository extends JpaRepository<Admin, Integer>
{
	
}
