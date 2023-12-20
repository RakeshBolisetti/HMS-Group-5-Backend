package com.team5.dto;

import java.io.Serial;

public class AffiliatedWithDTO {
	@Serial
    private static final long serialVersionUID = 1L;
    private Integer physicianId;
    private Integer departmentId;
    private Boolean primaryAffiliation;
    
	public AffiliatedWithDTO() {
		super();
	}

	/**
	 * @return the physicianId
	 */
	public Integer getPhysicianId() {
		return physicianId;
	}

	/**
	 * @param physicianId the physicianId to set
	 */
	public void setPhysicianId(Integer physicianId) {
		this.physicianId = physicianId;
	}

	/**
	 * @return the departmentId
	 */
	public Integer getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return the primaryAffiliation
	 */
	public Boolean getPrimaryAffiliation() {
		return primaryAffiliation;
	}

	/**
	 * @param primaryAffiliation the primaryAffiliation to set
	 */
	public void setPrimaryAffiliation(Boolean primaryAffiliation) {
		this.primaryAffiliation = primaryAffiliation;
	}

}
