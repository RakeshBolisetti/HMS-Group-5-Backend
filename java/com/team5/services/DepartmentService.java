package com.team5.services;

import java.util.List;

import com.team5.beans.Department;
import com.team5.beans.Physician;
import com.team5.beans.TrainedIn;

public interface DepartmentService {
	
	List<Department> findAll();
	Department create(Department dept);
	Department findById(Integer deptid);
	List<Department> findByHead(Integer head);
	Physician findPhysicianDetails(Integer deptid);
	List<Object> findHeadCertificationDetails(Integer deptid);
	Department updateHeadInDepartment(Integer deptid, Department d);
	Department updateDepartmentName(Integer deptid, Department d);
	

}
