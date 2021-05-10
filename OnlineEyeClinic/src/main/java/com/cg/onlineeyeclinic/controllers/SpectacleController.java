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
import com.cg.onlineeyeclinic.dto.SpectacleDTO;
import com.cg.onlineeyeclinic.entities.Spectacle;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.SpectacleNotFoundException;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;
import com.cg.onlineeyeclinic.services.SpectacleService;


//***********************************Spectacle Controller Class****************************************//


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/onlineeyecare")
public class SpectacleController 
{
	@Autowired
	private SpectacleService spectacleService;
	
	@Autowired
	private ConvertDTOToEntity cnv;
	
	@GetMapping(path="/spectacle/{id}")
	public ResponseEntity<Spectacle> getSpectacle(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(spectacleService.getSpectacle(id));
	}
	
	@GetMapping("/spectacle")
	public ResponseEntity<List<Spectacle>> getAllSpectacle() throws SpectacleNotFoundException
	{
		return ResponseEntity.ok(spectacleService.getAllSpectacle());
	}
	
	@GetMapping("/spectaclebymodel/{model}")
	public ResponseEntity<List<Spectacle>> getAllSpectacle(@PathVariable String model)
	{
		return ResponseEntity.ok(spectacleService.getAllSpectacleByModel(model));
	}
	
	@PostMapping("/spectacle")
	public ResponseEntity<Spectacle> addSpectacle(@RequestBody SpectacleDTO spectacleDTO)
	{
		Spectacle spectacle=cnv.convertToSpectacle(spectacleDTO);
		return ResponseEntity.ok(spectacleService.addSpectacle(spectacle));
	}
	
	@PutMapping("/spectacle/{id}")
	public ResponseEntity<Spectacle> updateSpectacle(@PathVariable int id,@RequestBody SpectacleDTO spectacleDTO) throws IdNotFoundException
	{
		Spectacle spectacle=cnv.convertToSpectacle(spectacleDTO);
		return ResponseEntity.ok(spectacleService.updateSpectacle(id,spectacle));
	}
	
	@DeleteMapping("/spectacle/{id}")
	public ResponseEntity<String> removeSpectacle(@PathVariable int id) throws IdNotFoundException
	{
		return ResponseEntity.ok(spectacleService.removeSpectacle(id));
	}
	
	
}
