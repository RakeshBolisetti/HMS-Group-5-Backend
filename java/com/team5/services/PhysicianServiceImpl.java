package com.team5.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.Physician;
import com.team5.dto.PhysicianDTO;
import com.team5.repository.PhysicianDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PhysicianServiceImpl implements PhysicianService{
	@Autowired
	private PhysicianDao repo;

	public PhysicianServiceImpl() {
		super();
	}

	public PhysicianDTO create(Physician p) {
		Physician createdPhysician = repo.save(p);
		return new PhysicianDTO(createdPhysician);
	}

	public PhysicianDTO findByName(String name) {
		Physician foundPhysician = repo.findByName(name);
		return new PhysicianDTO(foundPhysician);
	}
	public List<Physician> getPhysicianProfile(Integer physicianId) {
	    return repo.findByEmployeeid(physicianId.longValue());
	}
	public Physician getPhysicianProfile(String email) {
	    return repo.findByUsersEmail(email);
	}

	public List<PhysicianDTO> findByPosition(String pos) {
		List<Physician> foundPhysician = repo.findByPosition(pos);
		List<PhysicianDTO> physicianDTOS = new ArrayList<>();
		for(Physician eachPhysician: foundPhysician){
			physicianDTOS.add(new PhysicianDTO(eachPhysician));
		}
		return physicianDTOS;
	}

	public PhysicianDTO findByEmployeeId(Integer empid) {
		Optional<Physician> foundPhysician = repo.findById(empid);
		return foundPhysician.map(PhysicianDTO::new).orElse(null);
	}

	public List<PhysicianDTO> findAll() {
		List<Physician> foundPhysician = repo.findAll();
		List<PhysicianDTO> physicianDTOS = new ArrayList<>();
		for(Physician eachPhysician: foundPhysician){
			physicianDTOS.add(new PhysicianDTO(eachPhysician));
		}
		return physicianDTOS;
	}

	public PhysicianDTO updatePositionBasedOnEmpId(Integer empId, Physician p) {
		Optional<Physician> optionalPhysician = repo.findById(empId);
		if (optionalPhysician.isPresent()) {
			Physician foundPhysician = optionalPhysician.get();
			foundPhysician.setPosition(p.getPosition());
			return new PhysicianDTO(repo.save(foundPhysician));
		} else {
			return null;
		}
	}
		public PhysicianDTO updateNameBasedOnEmpId(Integer empId, Physician p) {
			Optional<Physician> optionalPhysician = repo.findById(empId);
			
			if (optionalPhysician.isPresent()) {
				Physician foundPhysician = optionalPhysician.get();
				foundPhysician.setName(p.getName());
				return new PhysicianDTO(repo.save(foundPhysician));
			} else {
				return null;
			}

	}
		public PhysicianDTO updateNameBasedOnSsn(Integer empId, Physician p) {
			Optional<Physician> optionalPhysician = repo.findById(empId);
			
			if (optionalPhysician.isPresent()) {
				Physician foundPhysician = optionalPhysician.get();
				foundPhysician.setSsn(p.getSsn());
				return new PhysicianDTO(repo.save(foundPhysician));
			} else {
				return null;
			}
			
		}
		public PhysicianDTO updateSsnNameAndPositionBasedOnEmpId(Integer empid, Physician givenP) {
	        Optional<Physician> optionalPhysician = repo.findById(empid);
	        if (optionalPhysician.isPresent()) {
	            Physician existingPhysician = optionalPhysician.get();
	            existingPhysician.setSsn(givenP.getSsn());
	            existingPhysician.setName(givenP.getName());
	            existingPhysician.setPosition(givenP.getPosition());
	            Physician updatedPhysician = repo.save(existingPhysician);
	            return new PhysicianDTO(updatedPhysician);
	        } else {
	            return null;
	        }
	    }

}
