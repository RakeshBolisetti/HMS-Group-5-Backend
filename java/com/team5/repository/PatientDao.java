package com.team5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team5.beans.Patient;



public interface PatientDao extends JpaRepository<Patient, Integer> {
	List<Patient> findByPhysician_Employeeid(Integer pid);

	@Query("SELECT p FROM Patient p WHERE p.physician.employeeid= :physicianid AND p.ssn= :patientid")
	Optional<Patient> findPatientWithPhysician(Integer physicianid, Integer patientid);

	@Query("SELECT p.insuranceid FROM Patient p WHERE p.ssn= :patientid")
	Optional<Integer> getInsuranceIdBySsn(Integer patientid);

	
	

	Optional<Patient> findPatientByUserid(Integer userid);

	Patient findByUsersEmail(String email);

}
