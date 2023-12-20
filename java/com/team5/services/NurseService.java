package com.team5.services;

import java.util.List;

import com.team5.beans.Nurse;

public interface NurseService {

	Nurse addNurse(Nurse nurse);
	
	List<Nurse> getAllNurses();
	Nurse getNurseById(Integer empid);
	String getPositionByEmpId(Integer empid);
	boolean getRegisteredByEmpId(Integer empid);
	Nurse updateRegisteredByEmpId(Integer empid, Boolean registered);
	 Nurse updateSsnByEmpId(Integer empid, Integer ssn);
	
	


   


	


	

	

	
	
	
	



}
