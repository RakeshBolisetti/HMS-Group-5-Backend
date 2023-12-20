package com.team5.controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team5.beans.Physician;
import com.team5.dto.PhysicianDTO;
import com.team5.exceptions.InvalidDataException;
import com.team5.exceptions.NotFoundException;
import com.team5.repository.PhysicianDao;
import com.team5.services.PhysicianService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin//(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/physician")

@SecurityRequirement(name = "bearerAuth")
public class PhisicianController {
	@Autowired
	private PhysicianService service;
	@Autowired
	PhysicianDao physicianRepository;

	final static String NO_PHYSICIAN_STRING = "Physician with the given ID does not exist!";

	@PostMapping("")
	
	public ResponseEntity<PhysicianDTO> addPhysician(@RequestBody Physician p) {
		PhysicianDTO addedPhysician = service.create(p);
		if (addedPhysician == null) {
			return new ResponseEntity<>(addedPhysician, HttpStatus.CREATED);
		} else {
			throw new InvalidDataException("Invalid \"Physician\" data, failed to add !");
		}
	}

	@GetMapping("")
	
	public ResponseEntity<List<PhysicianDTO>> findByField(@RequestParam(required = false) String name,
			@RequestParam(required = false) String pos, @RequestParam(required = false) Integer empid) {
		if (!StringUtils.isEmpty(name)) {
			PhysicianDTO foundPhysician = service.findByName(name);
			if (foundPhysician != null) {
				List<PhysicianDTO> ps = new ArrayList<>();
				ps.add(foundPhysician);
				return new ResponseEntity<>(ps, HttpStatus.OK);
			} else {
				throw new NotFoundException("No Physician with given name !");
			}
		} else if (!StringUtils.isEmpty(pos)) {
			List<PhysicianDTO> foundPhysicians = service.findByPosition(pos);
			if (foundPhysicians != null) {
				return new ResponseEntity<>(foundPhysicians, HttpStatus.OK);
			} else {
				throw new NotFoundException("No Physician(s) with given position !");
			}
		} else if (empid != null) {
			PhysicianDTO foundPhysician = service.findByEmployeeId(empid);
			if (foundPhysician != null) {
				List<PhysicianDTO> ps = List.of(foundPhysician);
				return new ResponseEntity<>(ps, HttpStatus.OK);
			} else {
				throw new NotFoundException(NO_PHYSICIAN_STRING);
			}
		} else {
			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		}
	}
	@GetMapping("/physician/{physicianId}")
    public List<Physician> getPhysicianProfile(@PathVariable("physicianId") Integer physicianId) {
        return service.getPhysicianProfile(physicianId);
    }
	@GetMapping("/physician/PhysicianEmail/{email}")
    public Physician getPhysicianProfileByEmail(@PathVariable("email") String email) {
        return service.getPhysicianProfile(email);
    }
	

	@PutMapping("/update/position/{empid}")
	
	public ResponseEntity<PhysicianDTO> updatePostion(@PathVariable Integer empid, @RequestBody Physician givenP) {
		PhysicianDTO returnedPhysician = service.updatePositionBasedOnEmpId(empid, givenP);
		if (returnedPhysician != null) {
			return new ResponseEntity<>(returnedPhysician, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PHYSICIAN_STRING);
		}
	}

	@PutMapping("/update/name/{empid}")
	
	public ResponseEntity<PhysicianDTO> updateName(@PathVariable Integer empid, @RequestBody Physician givenP) {
		PhysicianDTO returnedPhysician = service.updateNameBasedOnEmpId(empid, givenP);
		if (returnedPhysician != null) {
			return new ResponseEntity<>(returnedPhysician, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PHYSICIAN_STRING);
		}
	}
	
	@PutMapping("/update/ssn/{empid}")
	
	public ResponseEntity<PhysicianDTO> updateSsn(@PathVariable Integer empid, @RequestBody Physician givenP ) {
		PhysicianDTO returnedPhysician = service.updateNameBasedOnSsn(empid, givenP);
		if (returnedPhysician != null) {
			return new ResponseEntity<>(returnedPhysician, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PHYSICIAN_STRING);
		}
	}
	@RequestMapping(value ="/update/ssn/name/position/{empid}",method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PhysicianDTO> updateSsnNameAndPosition(
	        @PathVariable Integer empid,
	        @RequestBody Physician givenP
	) {
		System.out.println(givenP);
	    PhysicianDTO returnedPhysician = service.updateSsnNameAndPositionBasedOnEmpId(empid, givenP);
	    if (returnedPhysician != null) {
	        return new ResponseEntity<>(returnedPhysician, HttpStatus.OK);
	    } else {
	        throw new NotFoundException("Physician with the given ID does not exist!");
	    }
	}
	@GetMapping("/byuserId/{userid}")

	public ResponseEntity<Physician> getPhysician(@PathVariable Integer userid){
		return new ResponseEntity<Physician>(physicianRepository.findByUserid(userid).orElse(null), HttpStatus.OK);
	}
}
