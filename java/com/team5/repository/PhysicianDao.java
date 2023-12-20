package com.team5.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.team5.beans.Physician;



@Repository
public interface PhysicianDao extends JpaRepository<Physician, Integer> {
	
	Physician findByName(String name);
	List<Physician> findByPosition(String postion);
	Optional<Physician> findById(Integer employeeId);
	@Query("SELECT p.position, COUNT(p) FROM Physician p GROUP BY p.position")
	List<Object[]> countPhysiciansByPosition();

	Optional<Physician> findByUserid(Integer userid);
	 List<Physician> findByEmployeeid(Long physicianId);
	 @Query("UPDATE Physician p SET p.ssn = :ssn, p.name = :name, p.position = :position WHERE p.employeeid = :empid")
	 void updateSsnNameAndPositionBasedOnEmpId(@Param("empid") Integer empid, @Param("ssn") Integer ssn, @Param("name") String name, @Param("position") String position);

	 Physician findByUsersEmail(String email);

}

