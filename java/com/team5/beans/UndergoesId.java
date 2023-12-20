package com.team5.beans;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

public class UndergoesId implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;


	private Integer patient;

	private Integer procedures;



	private Timestamp dateundergoes;

	
	public UndergoesId() {
		super();
	}

	public UndergoesId(Integer patient, Integer procedures, Timestamp dateundergoes) {
		super();
		this.patient = patient;
		this.procedures = procedures;
	
		this.dateundergoes = dateundergoes;
	}


	public void setPatient(Integer value) {
		this.patient = value;
	}

	public Integer getPatient() {
		return this.patient;
	}

	public void setProcedures(Integer value) {
		this.procedures = value;
	}

	public Integer getProcedures() {
		return this.procedures;
	}



	public void setDateundergoes(Timestamp value) {
		this.dateundergoes = value;
	}

	public Timestamp getDateundergoes() {
		return this.dateundergoes;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UndergoesId other = (UndergoesId) obj;
		return Objects.equals(dateundergoes, other.dateundergoes) && Objects.equals(patient, other.patient)
				&& Objects.equals(procedures, other.procedures);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(dateundergoes, patient, procedures);
	}

	@Override
	public String toString() {
		return "UndergoesId [patient=" + patient + ", procedures=" + procedures + ", dateundergoes=" + dateundergoes
				+ "]";
	}

}