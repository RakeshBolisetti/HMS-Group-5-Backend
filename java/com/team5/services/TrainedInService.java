package com.team5.services;

import java.time.LocalDateTime;
import java.util.List;

import com.team5.beans.Physician;
import com.team5.beans.Procedures;
import com.team5.beans.TrainedIn;

public interface TrainedInService {

	List<TrainedIn> findAll();
	List<Procedures> findAllProcedures();
	 TrainedIn create(TrainedIn ti);
	 List<TrainedIn> getTrainedInByPhysician(Integer physicianId);
}
