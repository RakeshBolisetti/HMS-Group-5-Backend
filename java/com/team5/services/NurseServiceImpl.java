package com.team5.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.Nurse;
import com.team5.repository.NurseDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class NurseServiceImpl implements NurseService{

	@Autowired
	private NurseDao nurseRepository;

	public Nurse addNurse(Nurse nurse) {
		return nurseRepository.save(nurse);
	}

	public List<Nurse> getAllNurses() {
		return nurseRepository.findAll();
	}

	public Nurse getNurseById(Integer empid) {
		return nurseRepository.findById(empid).orElse(null);
	}

	public String getPositionByEmpId(Integer empid) {
		Nurse nurse = nurseRepository.findById(empid).orElse(null);
		if (nurse != null) {
			return nurse.getPosition();
		} else {
			return null;
		}
	}

	public boolean getRegisteredByEmpId(Integer empid) {
		Nurse nurse = nurseRepository.findById(empid).orElse(null);
		if (nurse != null) {
			return nurse.getRegistered();
		} else {
			return false;
		}
	}

	public Nurse updateRegisteredByEmpId(Integer empid, Boolean registered) {
		Nurse nurse = nurseRepository.findById(empid).orElse(null);
		if (nurse != null) {
			nurse.setRegistered(registered);
			nurseRepository.save(nurse);
		}
		return nurse;
	}

	public Nurse updateSsnByEmpId(Integer empid, Integer ssn) {
		Nurse nurse = nurseRepository.findById(empid).orElse(null);
		if (nurse != null) {
			nurse.setSsn(ssn);
			nurseRepository.save(nurse);
		}
		return nurse;
	}

}
