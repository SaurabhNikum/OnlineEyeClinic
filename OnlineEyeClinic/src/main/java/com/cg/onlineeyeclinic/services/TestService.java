package com.cg.onlineeyeclinic.services;

import java.util.List;

import com.cg.onlineeyeclinic.entities.Tests;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.TestNotFoundException;

//******************************Test Service Interface***************************//

public interface TestService {

	//add test 
	Tests addTest(Tests test);

	//update test details
	Tests updateTest(int testId,Tests test) throws IdNotFoundException;

	//get test details
	Tests getTest(int testId) throws IdNotFoundException;

	//remove test 
	String removeTest(int testId) throws IdNotFoundException;

	//get test list
	List<Tests> showAllTest() throws TestNotFoundException;
	
	//get test list be test name
	List<Tests> showAllTestByName(String name) throws NameNotFoundException;

}