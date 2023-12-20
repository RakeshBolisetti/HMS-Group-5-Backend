package com.team5.services;

import java.util.List;

import com.team5.beans.Patient;
import com.team5.dto.PatientDTO;

public interface PatientService {
	

	List<Patient> findAll();
	List<Patient> findAllPatientsWithPhysician(Integer physicianid);
	Patient findAllPatientsWithPhysicianWithPatient(Integer physicianid, Integer patientid);
	Integer findInsuranceIdBySsn(Integer ssn) ;
	Patient updateAddress(Integer ssn, PatientDTO p);
	Patient updatePhone(Integer ssn, PatientDTO p);
	Patient updatePatientDTO(Integer ssn, PatientDTO p);
	List<PatientDTO> getMinimalAllPatientDetails();
	PatientDTO getMinimalAllPatientDetailsBySsn(Integer ssn);
	Patient getPatientById(Integer ssn);
	Patient savePatient(PatientDTO patientdto);
	Patient getPatientByUserId(Integer userid);
	Patient create(PatientDTO patientdto);
	Patient findById(int ssn);
	Patient getPatientByUserId(String email);
	
	

	
}

 