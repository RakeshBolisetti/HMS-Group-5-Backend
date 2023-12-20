package com.team5.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team5.beans.Procedures;
import com.team5.dto.ProceduresDTO;
import com.team5.repository.ProceduresDao;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProceduresServiceImpl implements ProceduresService {

	@Autowired
	private ProceduresDao proceduresRepository;

	public List<ProceduresDTO> findAll() {
		List<Procedures> procedures = proceduresRepository.findAll();
		List<ProceduresDTO> proceduresDTO = new ArrayList<>();
		for (Procedures procedure : procedures) {
			proceduresDTO.add(convertToDTO(procedure));
		}
		return proceduresDTO;
	}

	public ProceduresDTO create(ProceduresDTO proceduresDTO) {
		Procedures procedure = convertToEntity(proceduresDTO);
		Procedures savedProcedure = proceduresRepository.save(procedure);
		return convertToDTO(savedProcedure);
	}

	public Double getCostByCode(Integer code) {
		Procedures newp = proceduresRepository.findByCode(code).orElse(null);
		if(newp!=null) {
			return newp.getCost();}
		return null;
	}

	public Double getCostByName(String name) {
		Procedures newp = proceduresRepository.findByName(name).orElse(null);
		if(newp!=null) {
			return newp.getCost();}
		return null;
	}

	public ProceduresDTO updateCostByCode(Integer code, ProceduresDTO proceduresDTO) {
		Procedures existingProcedure = proceduresRepository.findById(code)
				.orElseThrow(() -> new RuntimeException("Procedure not found"));
		existingProcedure.setCost(proceduresDTO.getCost());
		Procedures updatedProcedure = proceduresRepository.save(existingProcedure);
		return convertToDTO(updatedProcedure);
	}

	public ProceduresDTO updateCostByName(String name, ProceduresDTO proceduresDTO) {
		Procedures existingProcedure = proceduresRepository.findByName(name)
				.orElseThrow(() -> new RuntimeException("Procedure not found"));
		existingProcedure.setCost(proceduresDTO.getCost());
		Procedures updatedProcedure = proceduresRepository.save(existingProcedure);
		return convertToDTO(updatedProcedure);
	}

	private ProceduresDTO convertToDTO(Procedures procedure) {
		ProceduresDTO dto = new ProceduresDTO();
		dto.setCode(procedure.getCode());
		dto.setName(procedure.getName());
		dto.setCost(procedure.getCost());
		return dto;
	}

	private Procedures convertToEntity(ProceduresDTO dto) {
		Procedures procedure = new Procedures();
		procedure.setCode(dto.getCode());
		procedure.setName(dto.getName());
		procedure.setCost(dto.getCost());
		return procedure;
	}

}
