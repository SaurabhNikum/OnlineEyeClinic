package com.cg.onlineeyeclinic.controllers;
import java.util.List;
import javax.validation.Valid;
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
import com.cg.onlineeyeclinic.dto.ReportDTO;
import com.cg.onlineeyeclinic.entities.Report;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.ReportNotFoundException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.ReportService;


//***********************************Report Controller Class****************************************//

@CrossOrigin
@RestController
@RequestMapping("/onlineeyeclinic")
public class ReportController 
{
	@Autowired
	private ReportService reportService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/report/{id}")
	public ResponseEntity<Report> getReport(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(reportService.getReport(id));
	}
	
	@GetMapping("/reportbypatientid/{id}")
	public ResponseEntity<List<Report>> getAllReportByPatientId(@PathVariable int id) throws IdNotFoundException, ReportNotFoundException
	{
		return ResponseEntity.ok(reportService.getAllReportByPatientId(id));
	}
	
	@GetMapping("/report")
	public ResponseEntity<List<Report>> getAllReport() throws ReportNotFoundException
	{
		return ResponseEntity.ok(reportService.getAllReport());
	}
	
	
	@PostMapping("/report")
	public ResponseEntity<Report> createReport(@Valid @RequestBody ReportDTO reportDTO) throws IdNotFoundException
	{
		Report report=con.convertToReport(reportDTO);
		return ResponseEntity.ok(reportService.createReport(report));
	}
	
	@DeleteMapping("/report/{id}")
	public ResponseEntity<String> deleteReport(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(reportService.deleteReport(id));
	}
	
	@PutMapping("/report/{id}")
	public ResponseEntity<Report> updateReport(@PathVariable int id,@Valid @RequestBody ReportDTO reportDTO) throws IdNotFoundException
	{
		Report report=con.convertToReport(reportDTO);
		return ResponseEntity.ok(reportService.updateReport(id, report));
	}
}
