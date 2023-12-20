package com.team5.controllers;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.team5.beans.Appointment;
import com.team5.beans.Nurse;
import com.team5.beans.Patient;
import com.team5.beans.Physician;
import com.team5.dto.AppointmentDTO;
import com.team5.exceptions.InvalidDataException;
import com.team5.exceptions.NotFoundException;
import com.team5.services.AppointmentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin //(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/appointment")

@SecurityRequirement(name = "bearerAuth")
public class AppointmentController {
	@Autowired
	private AppointmentService appointmentService;

	final static String NO_APPOINTMENTS_STRING = "No Appointment(s) found !";
	final static String NO_PATIENTS_STRING = "No Patient(s) found !";

	@GetMapping("/patient/patientId/{patientId}")
	public List<Appointment> findAppointmentByPatientId(@PathVariable("patientId") Integer patientId){
		return appointmentService.findAllAppointmentsByPatientId(patientId);
	}
	
	@GetMapping("")
	public ResponseEntity<List<Appointment>> findAll() {
		List<Appointment> appointments = appointmentService.getAll();
		if (!appointments.isEmpty()) {
			return new ResponseEntity<>(appointments, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_APPOINTMENTS_STRING);
		}
	}

	@PostMapping("")
	
	public ResponseEntity<Appointment> addAppointment(@RequestBody AppointmentDTO given) {
		System.out.println(given);
		Appointment addedAppointment = appointmentService.create(given);
		if (addedAppointment != null) {
			return new ResponseEntity<>(addedAppointment, HttpStatus.OK);
		} else {
			throw new InvalidDataException("Invalid data provided for Appointment !");
		}
	}

//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss") 
	@GetMapping("/{startdate}")
	public ResponseEntity<List<Appointment>> findAllByStarto(
			@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startdate) {
		List<Appointment> found = appointmentService.findAllByStarto(java.sql.Date.valueOf(startdate.toLocalDate()));
		if (!found.isEmpty()) {
			return new ResponseEntity<>(found, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_APPOINTMENTS_STRING);
		}
	}

	@GetMapping("/patient/{appointmentid}")

	public ResponseEntity<Patient> findPatient(@PathVariable Integer appointmentid) {
		Patient found = appointmentService.findPatient(appointmentid);
		if (found != null) {
			return new ResponseEntity<>(found, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_APPOINTMENTS_STRING);
		}
	}

	@GetMapping("/physician")
	
	public ResponseEntity<List<Physician>> findPhysician(@RequestParam(required = false) Integer appointmentid,
			@RequestParam(required = false) Integer patientid, @RequestParam(required = false) LocalDate startdate) {
		if (appointmentid != null) {
			Physician found = appointmentService.findPhysician(appointmentid);
			if (found != null) {
				return new ResponseEntity<>(List.of(found), HttpStatus.OK);
			} else {
				throw new NotFoundException(NO_APPOINTMENTS_STRING);
			}
		} else if (patientid != null) {
			List<Physician> found = appointmentService.findPhysicianByPatientId(patientid);
			if (found != null) {
				return new ResponseEntity<>(found, HttpStatus.OK);
			} else {
				throw new NotFoundException(NO_APPOINTMENTS_STRING);
			}
		} else {
			List<Physician> found = appointmentService.findPhysicians();
			if (found != null) {
				return new ResponseEntity<>(found, HttpStatus.OK);
			} else {
				throw new NotFoundException("No Physician(s) found !");
			}
		}
	}

	@GetMapping("/nurse")
	public ResponseEntity<List<Nurse>> findNurse(@RequestParam(required = false) Integer appointmentid,
			@RequestParam(required = false) Integer patientid, @RequestParam(required = false) LocalDate startdate) {
		if (appointmentid != null) {
			Nurse found = appointmentService.findNurse(appointmentid);
			if (found != null) {
				return new ResponseEntity<>(List.of(found), HttpStatus.OK);
			} else {
				throw new NotFoundException(NO_APPOINTMENTS_STRING);
			}
		} else if (patientid != null) {
			List<Nurse> found = appointmentService.findNurseByPatientId(patientid);
			if (found != null) {
				return new ResponseEntity<>(found, HttpStatus.OK);
			} else {
				throw new NotFoundException(NO_PATIENTS_STRING);
			}
		} else {
			List<Nurse> found = appointmentService.findNurses();
			if (found != null) {
				return new ResponseEntity<>(found, HttpStatus.OK);
			} else {
				throw new NotFoundException("No Nurse(s) found !");
			}
		}
	}

	@GetMapping("/patient")
	public ResponseEntity<List<Patient>> getPatientsCheckedByPhysician(
			@RequestParam(required = false) Integer physicianid,
			@RequestParam(required = false) Integer nurseid,
			@RequestParam(required = false) Integer patientid,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime date) {

		List<Patient> patients;

		if (physicianid != null) {
			if (patientid != null) {
				patients = List.of(appointmentService.findPatientCheckedByPhysicianById(physicianid, patientid));
			} else if (date != null) {
				patients = appointmentService.findPatientsCheckedByPhysicianOnDate(physicianid, java.sql.Date.valueOf(date.toLocalDate()));
			} else {
				patients = appointmentService.findPatientsCheckedByPhysician(physicianid);
			}
		} else if (nurseid != null) {
			if (patientid != null) {
				patients = List.of(appointmentService.findPatientCheckedByNurseById(nurseid, patientid));
			} else if (date != null) {
				patients = appointmentService.findPatientsCheckedByNurseOnDate(nurseid, java.sql.Date.valueOf(date.toLocalDate()));
			} else {
				patients = appointmentService.findPatientsCheckedByNurse(nurseid);
			}
		} else {
			patients = appointmentService.findAllPatients();
		}

		if (!patients.isEmpty()) {
			return ResponseEntity.ok(patients);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@GetMapping("/date/{patientid}")
	public ResponseEntity<List<Object[]>> findAppointmentDatesOfPatient(@PathVariable Integer patientid) {
		List<Object[]> found = appointmentService.findAppointmentDatesOfPatient(patientid);
		if (found != null) {
			
			return new ResponseEntity<>(found, HttpStatus.OK);
		} else {
			throw new NotFoundException(NO_PATIENTS_STRING);
		}
	}
	@GetMapping("/physician/{physicianId}")
    public List<Appointment> getAppointmentsByPhysician(@PathVariable("physicianId") int physicianId) {
        return appointmentService.getAppointmentsByPhysician(physicianId);
    }
}
