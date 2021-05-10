package com.cg.onlineeyeclinic.controllers;


import java.util.List;

import javax.validation.Valid;

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

import com.cg.onlineeyeclinic.dto.ReportDTO;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.ReportNotFoundException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.ReportService;

//***********************************Report Controller Class****************************************//

@RestController
@RequestMapping("/report")
public class ReportController 
{
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Report> getReport(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(reportService.getReport(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Report>> getAllReport() throws ReportNotFoundException
	{
		return new ResponseEntity<>(reportService.getAllReport(),HttpStatus.OK);
	}
	
	
	@PostMapping("/create/{patientId}/{testId}")
	public ResponseEntity<Report> createReport(@PathVariable int patientId,@PathVariable int testId,@Valid @RequestBody ReportDTO reportDTO) throws IdNotFoundException
	{
		Report report=con.convertToReport(reportDTO);
		return new ResponseEntity<>(reportService.createReport(patientId, testId, report),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteReport(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(reportService.deleteReport(id),HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/update/{patientId}/{testId}")
	public ResponseEntity<Report> updateReport(@PathVariable int patientId,@PathVariable int testId,@Valid @RequestBody ReportDTO reportDTO) throws IdNotFoundException
	{
		Report report=con.convertToReport(reportDTO);
		return new ResponseEntity<>(reportService.updateReport(patientId, testId, report),HttpStatus.ACCEPTED);
	}
}
