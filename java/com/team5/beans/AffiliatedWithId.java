package com.team5.beans;


import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class AffiliatedWithId implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;


	private String physician;

	private Integer department;

	
	public AffiliatedWithId() {
		super();
	}
	public AffiliatedWithId(String physician, Integer department) {
		super();
		this.physician = physician;
		this.department = department;
	}


	public void setPhysician(String value) {
		this.physician = value;
	}

	public String getPhysician() {
		return this.physician;
	}

	public void setDepartment(Integer value) {
		this.department = value;
	}

	public Integer getDepartment() {
		return this.department;
	}

	 
	@Override
	public String toString() {
		return "AffiliatedWithId [physician=" + physician + ", department=" + department + "]";
	}

	
	

}
