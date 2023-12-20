package com.team5.controllers;

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

import com.team5.beans.Patient;
import com.team5.dto.PatientDTO;
import com.team5.exceptions.NotFoundException;
import com.team5.services.PatientService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin//(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/patient")

@SecurityRequirement(name = "bearerAuth")
public class PatientController {
	@Autowired
	private PatientService patientService;

	final static String NO_PATIENTS_STRING = "No Patients found in the database !";
	final static String NO_PATIENTS_SSN_STRING = "Patient with the given SSN does not exist !";

	@GetMapping("")
	
	public ResponseEntity<List<Patient>> findAll() {
		List<Patient> patients = patientService.findAll();
		if (!patients.isEmpty()) {
			return new ResponseEntity<>(patients, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PATIENTS_STRING);
		}
	}
	@GetMapping("/patient/{ssn}")
	public ResponseEntity<Patient> findById(@PathVariable("ssn") Integer ssn) {
		System.out.println(ssn);
		Patient patient = patientService.findById(ssn);
		if(patient == null) {
			throw new NotFoundException(NO_PATIENTS_SSN_STRING);
		}
		
	return new ResponseEntity<>(patient, HttpStatus.OK);
		
	}
	
	@GetMapping("/minimal")
	
	public ResponseEntity<List<PatientDTO>> getMinimalAllPatientDetails() {
		List<PatientDTO> patients = patientService.getMinimalAllPatientDetails();
		if (!patients.isEmpty()) {
			return new ResponseEntity<>(patients, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PATIENTS_STRING);
		}
	}
	
	@GetMapping("/minimal/{ssn}")

	public ResponseEntity<PatientDTO> getMinimalAllPatientDetailsBySsn(@PathVariable Integer ssn) {
		PatientDTO foundPatient = patientService.getMinimalAllPatientDetailsBySsn(ssn);
		if (foundPatient != null) {
			return new ResponseEntity<>(foundPatient, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PATIENTS_STRING);
		}
	}

	@GetMapping("/{physicianid}")

	public ResponseEntity<List<Patient>> findAllPatientsWithPhysician(@PathVariable Integer physicianid,
			@RequestParam(required = false) Integer patientid) {
		if (patientid != null) {
			Patient foundPatient = patientService.findAllPatientsWithPhysicianWithPatient(physicianid, patientid);
			if (foundPatient != null) {
				return new ResponseEntity<>(List.of(foundPatient), HttpStatus.OK);
			} else {
				throw new NotFoundException("No Patient and Physician are found with given IDs !");
			}
		} else {
			List<Patient> patients = patientService.findAllPatientsWithPhysician(physicianid);
			if (!patients.isEmpty()) {
				return new ResponseEntity<>(patients, HttpStatus.OK);
			} else {
				throw new NotFoundException(NO_PATIENTS_STRING);
			}
		}
	}

	@GetMapping("/insurance/{patientid}")

	public ResponseEntity<Integer> findInsuranceIdBySsn(@PathVariable Integer patientid) {
		Integer insurance = patientService.findInsuranceIdBySsn(patientid);
		if (insurance != null) {
			return new ResponseEntity<>(insurance, HttpStatus.OK);
		} else {
			throw new NotFoundException("No Patient and Physician are found with given IDs !");
		}
	}

	@PutMapping("/address/{SSN}")

	public ResponseEntity<Patient> updateAddressOfPatient(@PathVariable Integer ssn, @RequestBody PatientDTO p) {
		Patient updatePatient = patientService.updateAddress(ssn, p);
		if (updatePatient != null) {
			return new ResponseEntity<>(updatePatient, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PATIENTS_SSN_STRING);
		}
	}
	
	@PutMapping("/phone/{SSN}")
	
	public ResponseEntity<Patient> updatePhoneOfPatient(@PathVariable Integer ssn, @RequestBody PatientDTO p) {
		Patient updatePatient = patientService.updatePhone(ssn, p);
		if (updatePatient != null) {
			return new ResponseEntity<>(updatePatient, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PATIENTS_SSN_STRING);
		}
	}
	
	@PutMapping("/{ssn}")
	
	public ResponseEntity<Patient> updatePatientDTO(@PathVariable Integer ssn, @RequestBody PatientDTO p) {
		Patient updatePatient = patientService.updatePatientDTO(ssn, p);
		if (updatePatient != null) {
			return new ResponseEntity<>(updatePatient, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PATIENTS_SSN_STRING);
		}
	}

	@GetMapping("/userid/{userid}")
	
	public ResponseEntity<PatientDTO> getPatientBasedOnUserid(@PathVariable Integer userid){
		Patient foundPatient = patientService.getPatientByUserId(userid);
		if(foundPatient!=null){
			return new ResponseEntity<>(new PatientDTO(foundPatient), HttpStatus.OK);
		}else{
			throw new NotFoundException(NO_PATIENTS_STRING);
		}
	}
@GetMapping("/email/{email}")
	
	public ResponseEntity<PatientDTO> getPatientBasedOnUserid(@PathVariable String email){
		Patient foundPatient = patientService.getPatientByUserId(email);
		if(foundPatient!=null){
			return new ResponseEntity<>(new PatientDTO(foundPatient), HttpStatus.OK);
		}else{
			throw new NotFoundException(NO_PATIENTS_STRING);
		}
	}
	
	@PostMapping("")

	public ResponseEntity<String> addPatient(@RequestBody PatientDTO patientDto){
		Patient addedPatient = patientService.create(patientDto);
		if(addedPatient!=null) {
			return new ResponseEntity<>("Record Created Successfully !", HttpStatus.OK);
		}else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	
}