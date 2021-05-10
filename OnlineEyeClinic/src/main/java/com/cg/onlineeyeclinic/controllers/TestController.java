package com.cg.onlineeyeclinic.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyeclinic.dto.TestDTO;
import com.cg.onlineeyeclinic.entities.Tests;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.NameNotFoundException;
import com.cg.onlineeyeclinic.exceptions.TestNotFoundException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.TestService;

//***********************************Test Controller Class****************************************//

@RestController
@RequestMapping("/test")
public class TestController 
{
	@Autowired
	private TestService testService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Tests> getTest(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(testService.getTest(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Tests>> getAllTest() throws TestNotFoundException
	{
		return new ResponseEntity<>(testService.showAllTest(),HttpStatus.OK);
	}
	

	@GetMapping("/getbyname/{name}")
	public ResponseEntity<List<Tests>> getAllTestByName(@PathVariable String name) throws NameNotFoundException
	{
		return new ResponseEntity<>(testService.showAllTestByName(name),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Tests> addTest(@RequestBody TestDTO testDTO)
	{
		Tests test=con.convertToTests(testDTO);
		return new ResponseEntity<>(testService.addTest(test),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tests> updateTest(@PathVariable int id,@RequestBody TestDTO testDTO) throws IdNotFoundException
	{
		Tests test=con.convertToTests(testDTO);
		return new ResponseEntity<>(testService.updateTest(id,test),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeTest(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(testService.removeTest(id),HttpStatus.ACCEPTED);
	}
	
	
}
