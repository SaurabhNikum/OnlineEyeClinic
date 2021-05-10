package com.cg.onlineeyeclinic.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/onlineeyecare")
public class TestController 
{
	@Autowired
	private TestService testService;
	
	@Autowired
	private ConvertDTOToEntity cnv;
	
	
	@GetMapping("/tests/{id}")
	public ResponseEntity<Tests> getTest(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(testService.getTest(id));
	}
	
	@GetMapping("/tests")
	public ResponseEntity<List<Tests>> getAllTest() throws TestNotFoundException
	{
		return ResponseEntity.ok(testService.showAllTest());
	}
	

	@GetMapping("/tests/byname/{name}")
	public ResponseEntity<List<Tests>> getAllTestByName(@PathVariable String name) throws NameNotFoundException
	{
		return ResponseEntity.ok(testService.showAllTestByName(name));
	}
	
	@PostMapping("/tests")
	public ResponseEntity<Tests> addTest(@RequestBody TestDTO testDTO)
	{
		Tests tests=cnv.convertToTests(testDTO);
		return ResponseEntity.ok(testService.addTest(tests));
	}
	
	@PutMapping("/tests/{id}")
	public ResponseEntity<Tests> updateTest(@PathVariable int id,@RequestBody TestDTO testDTO) throws IdNotFoundException
	{
		Tests tests=cnv.convertToTests(testDTO);
		return ResponseEntity.ok(testService.updateTest(id,tests));
	}
	
	@DeleteMapping("/tests/{id}")
	public ResponseEntity<String> removeTest(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(testService.removeTest(id));
	}
	
	
}
