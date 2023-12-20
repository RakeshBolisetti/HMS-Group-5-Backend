package com.team5.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team5.beans.Procedures;
import com.team5.beans.TrainedIn;
import com.team5.beans.TrainedInId;



public interface TrainedInDao extends JpaRepository< TrainedIn, TrainedInId>{
	
	@Query("SELECT pro FROM TrainedIn trainTable "
			+ "INNER JOIN Procedures pro ON trainTable.id.treatment=pro.code")
	List<Procedures> findAllProcedures();
	@Query("select a from TrainedIn a join a.physician2 p where p.employeeid=:employeeid")
	List<TrainedIn> findByPhysicianId(@Param("employeeid") int employeeid);

}
