package com.cg.onlineeyeclinic.services;

import java.util.List;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.onlineeyeclinic.entities.Tests;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.TestNotFoundException;
import com.cg.onlineeyeclinic.repositories.TestRepository;

//******************************Test Service Implementation Class***************************//

@Service
public class TestServiceImpl implements TestService 
{
	@Autowired
	private TestRepository testRepository;
	
	String detail="test with given id is not available";
	
	//add test 
	@Override
	public Tests addTest(Tests test)
	{
		return testRepository.save(test);
	}
	
	//update test details
	@Override
	public Tests updateTest(int testId,Tests test) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException(detail);
		Tests updatedTest=testRepository.findById(testId).orElseThrow(supplier);
		updatedTest.setName(test.getName());
		updatedTest.setDescription(test.getDescription());
		updatedTest.setType(test.getType());
		updatedTest.setCost(test.getCost());
		return testRepository.save(updatedTest);
	}
	
	//get test detail
	@Override
	public Tests getTest(int testId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException(detail);
		return testRepository.findById(testId).orElseThrow(supplier);
	}
	
	//remove test 
	@Override
	public String removeTest(int testId) throws IdNotFoundException
	{
		Supplier<IdNotFoundException> supplier=()->new IdNotFoundException(detail);
		Tests test=testRepository.findById(testId).orElseThrow(supplier);
		testRepository.delete(test);
		return "test deleted successfully";
	}
	
	//get test list
	@Override
	public List<Tests> showAllTest() throws TestNotFoundException
	{
		if(testRepository.findAll().isEmpty())
		{
			throw new TestNotFoundException("no test is available currently");
		}
		return testRepository.findAll();
	}

	//get all test by name
	@Override
	public List<Tests> showAllTestByName(String name) throws NameNotFoundException 
	{
		if(testRepository.findAllByName(name).isEmpty())
		{
			throw new NameNotFoundException("test with : "+name+" is not available");
		}
		return testRepository.findAllByName(name);
	}
}
