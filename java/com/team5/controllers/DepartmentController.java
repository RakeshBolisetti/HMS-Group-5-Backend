package com.team5.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team5.beans.Department;
import com.team5.beans.Physician;
import com.team5.exceptions.InvalidDataException;
import com.team5.exceptions.NotFoundException;
import com.team5.services.DepartmentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin //(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/department")

@SecurityRequirement(name = "bearerAuth")
public class DepartmentController {
	@Autowired
	private DepartmentService service;

	final static String NO_DEPARTMENT_STRING = "No Department with given ID found !";

	@PostMapping("")
	
	public ResponseEntity<Department> addDepartment(@RequestBody Department dept) {
		Department createdDepartment = service.create(dept);
		if (createdDepartment != null) {
			return new ResponseEntity<>(createdDepartment, HttpStatus.OK);
		} else {
			throw new InvalidDataException("Invalid \"Department\" data, failed to add !");
		}
	}

	@GetMapping("")
	
	public ResponseEntity<List<Department>> findAll(@RequestParam(required = false) Integer deptid,
			@RequestParam(required = false) Integer head) {
		if (deptid != null) {
			Department foundDepartment = service.findById(deptid);
			if (foundDepartment != null) {
				List<Department> ps = new ArrayList<>();
				ps.add(foundDepartment);
				return new ResponseEntity<>(ps, HttpStatus.OK);
			} else {
				throw new NotFoundException(NO_DEPARTMENT_STRING);
			}
		} else if (head != null) {
			List<Department> foundDepartments = service.findByHead(head);
			if (!foundDepartments.isEmpty()) {
				return new ResponseEntity<>(foundDepartments, HttpStatus.OK);
			} else {
				throw new NotFoundException("No Department(s) associated with given Employee ID !");
			}
		} else {
			return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
		}
	}

	@GetMapping("head/{deptid}")

	public ResponseEntity<Physician> findPhysicianDetails(@PathVariable Integer deptid) {
		Physician foundPhysician = service.findPhysicianDetails(deptid);
		if (foundPhysician != null) {
			return new ResponseEntity<>(foundPhysician, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_DEPARTMENT_STRING);
		}
	}

	/* CHECK */
	@GetMapping("/headcertification/{deptid}")
	
	public ResponseEntity<List<Object>> findHeadCertificationDetails(@PathVariable Integer deptid) {
		List<Object> foundDetails = service.findHeadCertificationDetails(deptid);
		if (!foundDetails.isEmpty()) {
			return new ResponseEntity<>(foundDetails, HttpStatus.OK);
		} else {
			throw new NotFoundException("No certification details found on the Head of the given department !");
		}
	}

	@GetMapping("check/{physicianid}")
	
	public ResponseEntity<Boolean> checkPhysicianHeadOfAnyDepartment(@PathVariable Integer physicianid) {
		List<Department> foundDepartments = service.findByHead(physicianid);
		if (foundDepartments != null) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(false, HttpStatus.OK);
		}
	}

	@PutMapping("/update/head/{deptid}")
	
	public ResponseEntity<Department> updateHeadInDepartment(@PathVariable Integer deptid, @RequestBody Department d) {
		Department updatedDepartment = service.updateHeadInDepartment(deptid, d);
		if (updatedDepartment != null) {
			return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_DEPARTMENT_STRING);
		}
	}

	@PutMapping("/update/deptname/{deptid}")
	
	public ResponseEntity<Department> updateDepartmentName(@PathVariable Integer deptid, @RequestBody Department d) {
		Department updatedDepartment = service.updateDepartmentName(deptid, d);
		if (updatedDepartment != null) {
			return new ResponseEntity<>(updatedDepartment, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_DEPARTMENT_STRING);
		}
	}

}
