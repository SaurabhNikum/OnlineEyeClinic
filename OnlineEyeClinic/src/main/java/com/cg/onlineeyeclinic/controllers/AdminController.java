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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlineeyeclinic.dto.AdminDTO;
import com.cg.onlineeyeclinic.entities.Admin;
import com.cg.onlineeyeclinic.exceptions.AdminNotFoundException;
import com.cg.onlineeyeclinic.exceptions.IdNotFoundException;
import com.cg.onlineeyeclinic.exceptions.UserNameAlreadyExistException;
import com.cg.onlineeyeclinic.services.AdminService;
import com.cg.onlineeyeclinic.services.ConvertDTOToEntity;


//***********************************Admin Controller Class****************************************//

@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ConvertDTOToEntity con;
	
	@GetMapping("/getallusernames")
	public ResponseEntity<List<String>> getAllUsernames() throws AdminNotFoundException
	{
		return new ResponseEntity<>(adminService.getAdminsUsername(),HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Admin>> getAllAdmins() throws AdminNotFoundException
	{
		return new ResponseEntity<>(adminService.getAllAdmins(),HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Admin> addAdmin(@Valid @RequestBody AdminDTO adminDTO) throws UserNameAlreadyExistException
	{
		Admin admin=con.convertToAdmin(adminDTO);
		return new ResponseEntity<>(adminService.addAdmin(admin),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> removeAdmin(@PathVariable int id) throws IdNotFoundException
	{
		return new ResponseEntity<>(adminService.removeAdmin(id),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/changepassword/{id}/{password}")
	public ResponseEntity<String> updatePassword(@PathVariable int id,@PathVariable String password) throws IdNotFoundException
	{
		return new ResponseEntity<>(adminService.updatePassword(id, password),HttpStatus.ACCEPTED);
	}
	
}
