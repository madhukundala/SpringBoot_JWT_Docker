package com.test.jwt.ownApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/app")
@Api
public class AppController {

	@GetMapping("/checkApp")
	public ResponseEntity<String> getAppDetails(){
	return new ResponseEntity<String>("These methods are working", HttpStatus.OK);	
	}
	
	
}
