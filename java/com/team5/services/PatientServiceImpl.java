package com.team5.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.Patient;
import com.team5.beans.Physician;
import com.team5.dto.PatientDTO;
import com.team5.repository.PatientDao;
import com.team5.repository.PhysicianDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PatientServiceImpl implements PatientService{
	@Autowired
	private PatientDao patientRepository;
	@Autowired
	private PhysicianDao physicianRepository;

	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	public List<Patient> findAllPatientsWithPhysician(Integer physicianid) {
		return patientRepository.findByPhysician_Employeeid(physicianid);
	}

	public Patient findAllPatientsWithPhysicianWithPatient(Integer physicianid, Integer patientid) {
		Optional<Patient> opPatient = patientRepository.findPatientWithPhysician(physicianid, patientid);
		return opPatient.orElse(null);
	}

	public Integer findInsuranceIdBySsn(Integer ssn) {
		Optional<Integer> opPatient = patientRepository.getInsuranceIdBySsn(ssn);
		return opPatient.orElse(null);
	}
	
	public Patient updateAddress(Integer ssn, PatientDTO p) {
		Optional<Patient> opPatient = patientRepository.findById(ssn);
		if(opPatient.isPresent()) {
			Patient foundPatient = opPatient.get();
			foundPatient.setAddress(p.getAddress());
			return patientRepository.save(foundPatient);
		}else {
			return null;
		}
	}
	
	public Patient updatePhone(Integer ssn, PatientDTO p) {
		Optional<Patient> opPatient = patientRepository.findById(ssn);
		if(opPatient.isPresent()) {
			Patient foundPatient = opPatient.get();
			foundPatient.setPhone(p.getPhone());
			return patientRepository.save(foundPatient);
		}else {
			return null;
		}
	}
	
	public Patient updatePatientDTO(Integer ssn, PatientDTO p) {
		Optional<Patient> opPatient = patientRepository.findById(ssn);
		if(opPatient.isPresent()) {
			Patient foundPatient = opPatient.get();
			foundPatient.setName(p.getName());
			foundPatient.setPhone(p.getPhone());
			foundPatient.setAddress(p.getAddress());
			foundPatient.setInsuranceid(ssn);
			return patientRepository.save(foundPatient);
		}else {
			return null;
		}
	}
	
	public List<PatientDTO> getMinimalAllPatientDetails(){
		List<Patient> patients = patientRepository.findAll();
		List<PatientDTO> patientDtos = new ArrayList<>();
		if(patients.isEmpty()) {
			return null;
		}
		for(Patient eachPatient: patients) {
			PatientDTO newPatientDTO = new PatientDTO();
			newPatientDTO.setSsn(eachPatient.getSsn());
			newPatientDTO.setName(eachPatient.getName());
			newPatientDTO.setAddress(eachPatient.getAddress());
			newPatientDTO.setInsuranceid(eachPatient.getInsuranceid());
			newPatientDTO.setPcp(eachPatient.getPcp());
			newPatientDTO.setPhone(eachPatient.getPhone());
			patientDtos.add(newPatientDTO);
		}
		return patientDtos;
	}
	
	public PatientDTO getMinimalAllPatientDetailsBySsn(Integer ssn){
		Patient foundPatient = patientRepository.findById(ssn).orElse(null);
		if(foundPatient==null) {
			return null;
		}
		PatientDTO newPatientDTO = new PatientDTO();
		newPatientDTO.setSsn(foundPatient.getSsn());
			newPatientDTO.setName(foundPatient.getName());
			newPatientDTO.setAddress(foundPatient.getAddress());
			newPatientDTO.setInsuranceid(foundPatient.getInsuranceid());
			newPatientDTO.setPcp(foundPatient.getPcp());
			newPatientDTO.setPhone(foundPatient.getPhone());
		return newPatientDTO;
	}
	
	public Patient getPatientById(Integer ssn) {
		return patientRepository.findById(ssn).orElse(null);
	}
	
	public Patient savePatient(PatientDTO patientdto) {
		Physician foundPhysician = physicianRepository.findById(patientdto.getPcp()).orElse(null);
		if(foundPhysician==null) {
			return null;
		}
		Patient newPatient = new Patient();
		newPatient.setAddress(patientdto.getAddress());
		newPatient.setName(patientdto.getName());
		newPatient.setSsn(patientdto.getSsn());
		newPatient.setPhone(patientdto.getPhone());
		newPatient.setInsuranceid(patientdto.getInsuranceid());
		return patientRepository.save(newPatient);
	}

	public Patient getPatientByUserId(Integer userid){
		return patientRepository.findPatientByUserid(userid).orElse(null);
	}
	
	public Patient create(PatientDTO patientdto) {
		Patient newPatient = new Patient();
		newPatient.setAddress(patientdto.getAddress());
		newPatient.setName(patientdto.getName());
		newPatient.setSsn(patientdto.getSsn());
		newPatient.setPhone(patientdto.getPhone());
		newPatient.setInsuranceid(patientdto.getInsuranceid());
		newPatient.setPcp(patientdto.getPcp());
		try{
			return patientRepository.save(newPatient);
		}catch (IllegalArgumentException ex) {
			return null;
		}
	}

	public Patient findById(int ssn) {
		Patient p = patientRepository.findById(ssn).orElse(null);
		return p;
	}

	public Patient getPatientByUserId(String email) {
		Patient p =patientRepository.findByUsersEmail(email);
		return p;
	}
}
