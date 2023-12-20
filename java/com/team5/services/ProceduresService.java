package com.team5.services;

import java.util.List;

import com.team5.beans.Procedures;
import com.team5.dto.ProceduresDTO;

public interface ProceduresService {
	List<ProceduresDTO> findAll();
	ProceduresDTO create(ProceduresDTO proceduresDTO);
	Double getCostByCode(Integer code);
	Double getCostByName(String name);
	ProceduresDTO updateCostByCode(Integer code, ProceduresDTO proceduresDTO);
	ProceduresDTO updateCostByName(String name, ProceduresDTO proceduresDTO);
	
	
	

	

	

	

	

	
/*
	Procedures updateProceduresnameService(int id);

	*/

	

	

	

}
