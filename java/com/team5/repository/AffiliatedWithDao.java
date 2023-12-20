package com.team5.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team5.beans.AffiliatedWith;
import com.team5.beans.AffiliatedWithId;



public interface AffiliatedWithDao extends JpaRepository<AffiliatedWith, AffiliatedWithId>{

//	@Query("SELECT aff.physician2 FROM AffiliatedWith aff WHERE aff.department2.departmentid = :deptid")
	Object[] findPhysicianByDepartment(Integer deptid);

	Object[] findDistinctDepartmentByPhysician(Integer employeeid);
	
	@Query("SELECT COUNT(aff.physician) FROM AffiliatedWith aff WHERE aff.department= :deptid")
	Integer countPhysiciansAffiliatedWithDepartment(Integer deptid);
	
//	@Query("SELECT aff.primaryaffiliation FROM AffiliatedWith aff "
//			+ "WHERE aff.physician2.employeeid= :physicianid AND "
//			+ "aff.department2.departmentid= :deptid")
//	Optional<Boolean> getPrimaryAffiliation(Integer physicianid, Integer deptid);
//	
//	Optional<AffiliatedWith> findByPhysicianAndDepartment(Integer physicianid, Integer deptid);

	AffiliatedWith findByPhysicianAndDepartment(Integer physicianid, Integer deptid);
}

