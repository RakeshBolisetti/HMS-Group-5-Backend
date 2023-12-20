package com.team5.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.AffiliatedWith;
import com.team5.beans.Department;
import com.team5.beans.Physician;
import com.team5.dto.AffiliatedWithDTO;
import com.team5.exceptions.NotFoundException;
import com.team5.repository.AffiliatedWithDao;
import com.team5.repository.DepartmentDao;
import com.team5.repository.PhysicianDao;


@Service
public class AffiliatedWithServiceImpl implements AffiliatedWithService {

	public AffiliatedWithServiceImpl() {
		super();
	}

	@Autowired
	private AffiliatedWithDao affiliatedWithRepository;
	@Autowired
	private PhysicianDao physicianRepository;
	@Autowired
	private DepartmentDao departmentRepository;

	public List<AffiliatedWithDTO> getAll() {
		List<AffiliatedWith> foundAffiliatedWith = affiliatedWithRepository.findAll();
		if (foundAffiliatedWith.isEmpty()) {
			return null;
		}
		List<AffiliatedWithDTO> foundAffiliatedWithDTO = new ArrayList<>();
		for (AffiliatedWith eachValue : foundAffiliatedWith) {
			AffiliatedWithDTO newAff = new AffiliatedWithDTO();
			newAff.setDepartmentId(eachValue.getDepartment());
			newAff.setPhysicianId(eachValue.getPhysician());
			newAff.setPrimaryAffiliation(eachValue.getPrimaryaffiliation());
			foundAffiliatedWithDTO.add(newAff);
		}
		return foundAffiliatedWithDTO;
	}

	public AffiliatedWith create(AffiliatedWithDTO affiliatedWithDTO) {
		Physician foundPhysician = physicianRepository.findById(affiliatedWithDTO.getPhysicianId()).orElse(null);
		if (foundPhysician == null) {
		}
		Department foundDepartment = departmentRepository.findById(affiliatedWithDTO.getDepartmentId()).orElse(null);
		if (foundDepartment == null) {
			throw new NotFoundException("Department not found");
		}
		AffiliatedWith newAffiliation = new AffiliatedWith();
		newAffiliation.setPhysician(foundPhysician.getEmployeeid());
		newAffiliation.setDepartment(foundDepartment.getDepartmentid());
		newAffiliation.setPrimaryaffiliation(affiliatedWithDTO.getPrimaryAffiliation());
		return affiliatedWithRepository.save(newAffiliation);
	}

//	public List<Physician> findPhysiciansAffiliatedWithDepartment(Integer deptId) {
//		Object[] physiciansObjs = affiliatedWithRepository.findPhysician2ByDepartment2_departmentid(deptId);
//		if (physiciansObjs.length == 0) {
//			return null;
//		} else {
//			List<Physician> physicians = new ArrayList<>();
//			for (Object eachObj : physiciansObjs) {
//				Physician physician = ((AffiliatedWith) eachObj).getPhysician2();
//				physicians.add(physician);
//			}
//			return physicians;
//		}
//	}

//	public List<Department> findDepartmentsAffiliatedWithPhysician(Integer physicianid) {
//		Object[] departmentObjs = affiliatedWithRepository.findDistinctDepartment2ByPhysician2_Employeeid(physicianid);
//		if (departmentObjs.length == 0) {
//			return null;
//		} else {
//			List<Department> departments = new ArrayList<>();
//			for (Object eachObj : departmentObjs) {
//				Department department = ((AffiliatedWith) eachObj).getDepartment2();
//				departments.add(department);
//			}
//			return departments;
//		}
//	}

	public Integer countPhysiciansInDepartment(Integer deptid) {
		return affiliatedWithRepository.countPhysiciansAffiliatedWithDepartment(deptid);
	}

	public Optional<Boolean> getPrimaryAffiliation(Integer physicianid, Integer deptid) {
		AffiliatedWith aff =affiliatedWithRepository.findByPhysicianAndDepartment(physicianid, deptid);
		return Optional.of( aff.getPrimaryaffiliation());
	}

	public AffiliatedWith updatePrimaryAffiliation(Integer deptid, Integer physicianid, AffiliatedWith af) {
		AffiliatedWith aff = affiliatedWithRepository
				.findByPhysicianAndDepartment(physicianid,deptid);
		if (aff!=null) {
//			AffiliatedWith aff = optionalAff.get();
			aff.setPrimaryaffiliation(af.getPrimaryaffiliation());
			return affiliatedWithRepository.save(aff);
		} else {
			return null;
		}
	}

}
