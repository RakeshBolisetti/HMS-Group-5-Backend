package com.team5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.beans.Procedures;
import com.team5.beans.TrainedIn;
import com.team5.exceptions.InvalidDataException;
import com.team5.exceptions.NotFoundException;
import com.team5.services.TrainedInService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin//(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/trainedIn")

@SecurityRequirement(name = "bearerAuth")
public class TrainedInController {
	@Autowired
	private TrainedInService service;
	
	@GetMapping("")
	
	public ResponseEntity<List<Procedures>> findAll(){
		List<Procedures> allProcedures = service.findAllProcedures();	
		if(!allProcedures.isEmpty()) {
			return new ResponseEntity<>(allProcedures, HttpStatus.OK);
		}else {
			throw new NotFoundException("No TrainedIn data found !");
		}
	}
	@GetMapping("/physician/{physicianId}")
    public List<TrainedIn> getTrainedInByPhysician(@PathVariable("physicianId") Integer physicianId) {
        return service.getTrainedInByPhysician(physicianId);
    }
	
	@PostMapping("")
	public ResponseEntity<TrainedIn> create(@RequestBody TrainedIn ti) {
		System.out.println(ti);
		TrainedIn created = service.create(ti);
		if (created != null) {
			return new ResponseEntity<>(created, HttpStatus.OK);
		} else {
			throw new InvalidDataException("Invalid \"TrainedIn\" data, failed to add !");
		}
	}

}