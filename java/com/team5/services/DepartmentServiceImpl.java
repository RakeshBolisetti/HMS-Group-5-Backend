package com.team5.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.Department;
import com.team5.beans.Physician;
import com.team5.repository.DepartmentDao;

import jakarta.transaction.Transactional;



@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	public DepartmentDao repo;

	public DepartmentServiceImpl() {
		super();
	}

	public List<Department> findAll() {
		return repo.findAll();
	}

	public Department create(Department dept) {
		return repo.save(dept);
	}

	public Department findById(Integer deptid) {
		Optional<Department> optionalDepartment = repo.findById(deptid);
		return optionalDepartment.orElse(null);
	}

	public List<Department> findByHead(Integer head) {
		List<Department> departments = repo.findByHead(head);
		if (!departments.isEmpty()) {
			return departments;
		} else {
			return null;
		}
	}

	public Physician findPhysicianDetails(Integer deptid) {
		Optional<Physician> optionalPhysician = repo.findPhysicianDetails(deptid);
		if (optionalPhysician.isPresent()) {
			return optionalPhysician.orElse(null);
		} else {
			return null;
		}
	}

	public List<Object> findHeadCertificationDetails(Integer deptid) {
		List<Object> optionalTrainedIn = repo.findCertificationDetailsByHead(deptid);
		if (!optionalTrainedIn.isEmpty()) {
			return optionalTrainedIn;
		} else {
			return null;
		}
	}
	
	public Department updateHeadInDepartment(Integer deptid, Department d) {
		Optional<Department> optionalDepartment = repo.findById(deptid);
		if(optionalDepartment.isPresent()){
			Department foundDepartment = optionalDepartment.get();
			foundDepartment.setHead(d.getHead());
			return repo.save(foundDepartment);
		}else {
			return null;
		}
	}
	public Department updateDepartmentName(Integer deptid, Department d) {
		Optional<Department> optionalDepartment = repo.findById(deptid);
		if(optionalDepartment.isPresent()){
			Department foundDepartment = optionalDepartment.get();
			foundDepartment.setName(d.getName());
			return repo.save(foundDepartment);
		}else {
			return null;
		}
	}

}
