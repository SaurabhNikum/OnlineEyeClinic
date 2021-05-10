package com.cg.onlineeyeclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineeyeclinic.services.LoginService;

//***********************************Login Controller Class****************************************//

@CrossOrigin
@RestController
@RequestMapping("/onlineeyeclinic")
public class LoginController
{
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/login/admin/{username}/{password}")
	public ResponseEntity<Boolean> adminLogin(@PathVariable String username,@PathVariable String password)
	{
		return ResponseEntity.ok(loginService.adminLogin(username, password));
	}
	
	@GetMapping("/login/doctor/{username}/{password}")
	public ResponseEntity<Boolean> doctorLogin(@PathVariable String username,@PathVariable String password)
	{
		return ResponseEntity.ok(loginService.doctorLogin(username, password));
	}
	
	@GetMapping("/login/patient/{username}/{password}")
	public ResponseEntity<Boolean> patientLogin(@PathVariable String username,@PathVariable String password)
	{
		return ResponseEntity.ok(loginService.patientLogin(username, password));
	}
}
