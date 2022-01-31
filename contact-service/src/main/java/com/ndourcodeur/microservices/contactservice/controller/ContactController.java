package com.ndourcodeur.microservices.contactservice.controller;

import com.ndourcodeur.microservices.contactservice.message.Message;
import com.ndourcodeur.microservices.contactservice.model.ContactForm;
import com.ndourcodeur.microservices.contactservice.service.EmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * @author NdourCodeur
 **/

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class ContactController {

	private final EmailService emailService;

	public ContactController(EmailService emailService) {
		this.emailService = emailService;
	}


	/**
	 *    URL ===>   http://localhost:8000/api/contact/sendEmail
	 */
	@PostMapping("/sendEmail")
	public ResponseEntity<?> sendEmail(@Valid @RequestBody ContactForm contactFormDto) {
		
		emailService.send(contactFormDto);
		
		return new ResponseEntity<>(new Message("Email sent with success."), HttpStatus.CREATED);
	}

	/**
	 *    URL ===>   http://localhost:8000/api/contact/hello
	 */
	@GetMapping("/hello")
	public String helloWorld(){

		return "Hello World !";
	}
}
