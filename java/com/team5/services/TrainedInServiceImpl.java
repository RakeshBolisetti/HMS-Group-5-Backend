package com.team5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.Procedures;
import com.team5.beans.TrainedIn;
import com.team5.repository.TrainedInDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TrainedInServiceImpl implements TrainedInService {

	@Autowired
	private TrainedInDao repo;

	public List<TrainedIn> findAll() {
		return repo.findAll();
	}

	public List<Procedures> findAllProcedures() {
		return repo.findAllProcedures();
	}

	public TrainedIn create(TrainedIn ti) {
		return repo.save(ti);
	}
	public List<TrainedIn> getTrainedInByPhysician(Integer physicianId) {
        return repo.findByPhysicianId(physicianId);
    }

}
