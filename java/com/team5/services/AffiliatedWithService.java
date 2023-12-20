package com.team5.services;

import java.util.List;
import java.util.Optional;

import com.team5.beans.AffiliatedWith;
import com.team5.dto.AffiliatedWithDTO;

public interface AffiliatedWithService {
	List<AffiliatedWithDTO> getAll();
	AffiliatedWith create(AffiliatedWithDTO affiliatedWithDTO);
	Integer countPhysiciansInDepartment(Integer deptid);
	Optional<Boolean> getPrimaryAffiliation(Integer physicianid, Integer deptid);
	AffiliatedWith updatePrimaryAffiliation(Integer deptid, Integer physicianid, AffiliatedWith af);
	

	

}
