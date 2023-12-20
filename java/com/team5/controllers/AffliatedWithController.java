package com.team5.controllers;

import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RestController;

import com.team5.beans.AffiliatedWith;
import com.team5.dto.AffiliatedWithDTO;
import com.team5.exceptions.InvalidDataException;
import com.team5.exceptions.NotFoundException;
import com.team5.services.AffiliatedWithService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/affiliated_with")
@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully retrieved"),
		@ApiResponse(responseCode = "404", description = "Not found") })
@SecurityRequirement(name = "bearerAuth")
public class AffliatedWithController {
	@Autowired
	private AffiliatedWithService affiliatedWithService;

	@GetMapping("")
	public ResponseEntity<List<AffiliatedWithDTO>> findAll() {
		List<AffiliatedWithDTO> values = affiliatedWithService.getAll();
		if (values != null) {
			return new ResponseEntity<>(values, HttpStatus.OK);
		} else {
			throw new NotFoundException("No AffiliatedWith data found !");
		}
	}

	@PostMapping(value = "")

	public ResponseEntity<String> addAffiliatedWith(@RequestBody AffiliatedWithDTO affiliatedWithDTO) {
		if (affiliatedWithService.create(affiliatedWithDTO) != null)
		{
			return ResponseEntity.ok("Record created !");
		}
		else throw new InvalidDataException("Invalid Data!");
	}

//	@GetMapping("/physicians/{deptid}")
	
//	public ResponseEntity<List<Physician>> findPhysiciansAffiliatedWithDepartment(@PathVariable Integer deptid) {
//		List<Physician> physicians = affiliatedWithService.findPhysiciansAffiliatedWithDepartment(deptid);
//		if (physicians != null) {
//			return new ResponseEntity<>(physicians, HttpStatus.OK);
//		} else {
//			throw new NotFoundException("No Physicians affiliated with the given department "
//					+ "or Department with the given Department ID does not exist!");
//		}
//	}

//	@GetMapping("/department/{physicianid}")
//	
//	public ResponseEntity<List<Department>> findDepartmentsAffiliatedWithPhysician(@PathVariable Integer physicianid) {
//		List<Department> departments = affiliatedWithService.findDepartmentsAffiliatedWithPhysician(physicianid);
//		if (departments != null) {
//			return new ResponseEntity<>(departments, HttpStatus.OK);
//		} else {
//			throw new NotFoundException("No Deapartments affiliated with the given Physician "
//					+ "or Physician with the given Physician ID does not exist!");
//		}
//	}

	@GetMapping("/countphysician/{deptid}")
	public ResponseEntity<Integer> countPhysicians(@PathVariable Integer deptid) {
		return new ResponseEntity<>(affiliatedWithService.countPhysiciansInDepartment(deptid), HttpStatus.OK);
	}

	@GetMapping("/department/{deptid}/physician/{physicianid}/primary")
	
	public ResponseEntity<Boolean> getPrimaryAffilition(@PathVariable Integer physicianid,
			@PathVariable Integer deptid) {
		Optional<Boolean> optionalAffiliationStatus = affiliatedWithService.getPrimaryAffiliation(physicianid, deptid);
		if (optionalAffiliationStatus.isPresent()) {
			return new ResponseEntity<>(optionalAffiliationStatus.get(), HttpStatus.OK);
		} else {
			throw new NotFoundException("No Affiliation between the given Physician and department could be found !");
		}
	}

	@PutMapping(value = "/department/{deptid}/physician/{physicianid}/update/primary/", consumes = "application/json;charset=UTF-8")
	
	public ResponseEntity<AffiliatedWith> updatePrimaryAffiliation(@PathVariable Integer deptid,
			@PathVariable Integer physicianid, @RequestBody AffiliatedWith af) {
		AffiliatedWith affiliatedWith = affiliatedWithService.updatePrimaryAffiliation(deptid, physicianid, af);
		if (affiliatedWith != null) {
			return new ResponseEntity<>(affiliatedWith, HttpStatus.OK);
		} else {
			throw new NotFoundException("No Affiliation between the given Physician and department could be found !");
		}

	}

}
