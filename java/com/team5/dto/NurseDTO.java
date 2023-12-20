package com.team5.dto;

import com.team5.beans.Nurse;

public class NurseDTO {
	private Integer employeeid;
	private String name;
	private String position;
	private Boolean registered;
	private Integer ssn;

	public NurseDTO(Nurse nurse) {
		this.employeeid = nurse.getEmployeeid();
		this.name = nurse.getName();
		this.position = nurse.getPosition();
		this.registered = nurse.getRegistered();
		this.ssn = nurse.getSsn();
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public String getName() {
		return name;
	}

	public String getPosition() {
		return position;
	}

	public Boolean getRegistered() {
		return registered;
	}

	public Integer getSsn() {
		return ssn;
	}

	public NurseDTO() {
		super();
	}
}