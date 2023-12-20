package com.team5.beans;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class TrainedInId implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	
	private Integer physician;

	private Integer treatment;

	
	public TrainedInId() {
		super();
	}

	public TrainedInId(Integer physician, Integer treatment) {
		super();
		this.physician = physician;
		this.treatment = treatment;
	}


	public void setPhysician(Integer value) {
		this.physician = value;
	}

	public Integer getPhysician() {
		return this.physician;
	}

	public void setTreatment(Integer value) {
		this.treatment = value;
	}

	public Integer getTreatment() {
		return this.treatment;
	}

	 


	@Override
	public String toString() {
		return "TrainedInId [physician=" + physician + ", treatment=" + treatment + "]";
	}

}
