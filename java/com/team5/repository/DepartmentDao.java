package com.team5.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.team5.beans.Department;
import com.team5.beans.Physician;


public interface DepartmentDao extends JpaRepository<Department, Integer> {

	@Query("SELECT d FROM Department d WHERE d.physician.employeeid= :head")
	List<Department> findByHead(Integer head);

	@Query("SELECT d.physician FROM Department d WHERE d.physician.employeeid= :deptid")
	Optional<Physician> findPhysicianDetails(Integer deptid);

	@Query("SELECT certification FROM Department d "
			+ "INNER JOIN TrainedIn certification ON d.physician.employeeid=certification.physician2.employeeid "
			+ "WHERE d.departmentid= :deptid")
	List<Object> findCertificationDetailsByHead(Integer deptid);

//	@Query("SELECT d.name, COUNT(aw) FROM Department d "
//			+ "JOIN d.listOfAffiliatedWith aw WHERE d.physician IS NOT NULL GROUP BY d.name")
//	List<Object[]> getDepartmentPhysicianAffiliationCounts();

}
