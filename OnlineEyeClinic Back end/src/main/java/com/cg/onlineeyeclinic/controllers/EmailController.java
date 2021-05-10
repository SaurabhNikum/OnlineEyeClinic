package com.cg.onlineeyeclinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.onlineeyeclinic.dto.EmailRequest;
import com.cg.onlineeyeclinic.dto.EmailResponse;
import com.cg.onlineeyeclinic.services.EmailService;


@CrossOrigin
@RestController
@RequestMapping("/onlineeyeclinic")
public class EmailController
{
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendemail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest e)
	{
		boolean flag=emailService.sendEmail(e.getMessage(), e.getSubject(), e.getTo());
		if(flag)
		{
			return ResponseEntity.ok(new EmailResponse("Email is sent successfully"));
		}
		return ResponseEntity.ok(new EmailResponse("Email not sent"));
	}
}

