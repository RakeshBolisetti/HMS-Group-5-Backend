package com.team5.services;

import java.util.List;

import com.team5.beans.Physician;
import com.team5.dto.PhysicianDTO;

public interface PhysicianService {
//	
//	String addNewPhysician(PhysicianDto p);
//	
//	List<Physician> getAllPhysiciansByPosService(String position);
//	Physician getPhysicianById(int empId);
//
//	Physician updatePhysicianPosService(String position, int empId);
//	
//	Physician updatePhysicianNameService(String name,int empId);
//	
//	Physician updatePhysicianSsnService(int ssn, int empId);
//	Physician findByPhysicianNameService(String name);
//		
	 PhysicianDTO create(Physician p);
	 PhysicianDTO findByName(String name);
	 List<Physician> getPhysicianProfile(Integer physicianId);
	 Physician getPhysicianProfile(String email);
	 List<PhysicianDTO> findByPosition(String pos);
	 PhysicianDTO findByEmployeeId(Integer empid);
	 List<PhysicianDTO> findAll();
	 PhysicianDTO updatePositionBasedOnEmpId(Integer empId, Physician p);
	 PhysicianDTO updateNameBasedOnEmpId(Integer empId, Physician p) ;
	 PhysicianDTO updateNameBasedOnSsn(Integer empId, Physician p) ;
	 PhysicianDTO updateSsnNameAndPositionBasedOnEmpId(Integer empid, Physician givenP);
	 

}
