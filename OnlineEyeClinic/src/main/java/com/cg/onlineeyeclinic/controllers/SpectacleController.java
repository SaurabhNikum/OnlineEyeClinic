package com.cg.onlineeyeclinic.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.cg.onlineeyeclinic.dto.SpectacleDTO;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.SpectacleNotFoundException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.SpectacleService;

//***********************************Spectacle Controller Class****************************************//

@CrossOrigin
@RestController
@RequestMapping("/spectacle")
public class SpectacleController 
{
	@Autowired
	private SpectacleService spectacleService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Spectacle> getSpectacle(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(spectacleService.getSpectacle(id),HttpStatus.FOUND);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Spectacle>> getAllSpectacle() throws SpectacleNotFoundException
	{
		return new ResponseEntity<>(spectacleService.getAllSpectacle(),HttpStatus.OK);
	}
	
	@GetMapping("/getbymodel/{model}")
	public ResponseEntity<List<Spectacle>> getAllSpectacle(@PathVariable String model)
	{
		return new ResponseEntity<>(spectacleService.getAllSpectacleByModel(model),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Spectacle> addSpectacle(@RequestBody SpectacleDTO spectacleDTO)
	{
		Spectacle spectacle=con.convertToSpectacle(spectacleDTO);
		return new ResponseEntity<>(spectacleService.addSpectacle(spectacle),HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Spectacle> updateSpectacle(@PathVariable int id,@RequestBody SpectacleDTO spectacleDTO) throws IdNotFoundException
	{
		Spectacle spectacle=con.convertToSpectacle(spectacleDTO);
		return new ResponseEntity<>(spectacleService.updateSpectacle(id,spectacle),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeSpectacle(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(spectacleService.removeSpectacle(id),HttpStatus.ACCEPTED);
	}
	
	
}
