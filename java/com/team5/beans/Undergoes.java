package com.team5.beans;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "undergoes")
@IdClass(UndergoesId.class)
public class Undergoes implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "Patient", nullable = false)
	private Integer patient;

	@Id
	@Column(name = "Procedures", nullable = false)
	private Integer procedures;

	
	@Id
	@Column(name = "DateUndergoes", nullable = false)
	private Timestamp dateundergoes;


	@Column(name = "Physician", nullable = false)
	private Integer physician;

	@Column(name = "AssistingNurse")
	private Integer assistingnurse;

	
	@ManyToOne
	@JoinColumn(name = "AssistingNurse", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
//	@JsonBackReference
	private Nurse nurse;



	@ManyToOne
	@JoinColumn(name = "Physician", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
//	@JsonBackReference
	private Physician physician2;

	@ManyToOne
	@JoinColumn(name = "Procedures", referencedColumnName = "Code", insertable = false, updatable = false)
//	@JsonBackReference
	private Procedures procedures2;

	@ManyToOne
	@JoinColumn(name = "Patient", referencedColumnName = "SSN", insertable = false, updatable = false)
//	@JsonBackReference
	private Patient patient2;

	
	public Undergoes() {
		super();
	}


	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getPatient() {
		return this.patient;
	}

	public void setProcedures(Integer procedures) {
		this.procedures = procedures;
	}

	public Integer getProcedures() {
		return this.procedures;
	}

	
	public void setLocalDateTimeundergoes(Timestamp dateundergoes) {
		this.dateundergoes = dateundergoes;
	}

	public Timestamp getLocalDateTimeundergoes() {
		return this.dateundergoes;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getPhysician() {
		return this.physician;
	}

	public void setAssistingnurse(Integer assistingnurse) {
		this.assistingnurse = assistingnurse;
	}

	public Integer getAssistingnurse() {
		return this.assistingnurse;
	}

	
	public Nurse getNurse() {
		return this.nurse;
	}

	

	public Physician getPhysician2() {
		return this.physician2;
	}

	public Procedures getProcedures2() {
		return this.procedures2;
	}

	public Patient getPatient2() {
		return this.patient2;
	}


	@Override
	public String toString() {
		return "Undergoes [patient=" + patient + ", procedures=" + procedures + ", dateundergoes=" + dateundergoes
				+ ", physician=" + physician + ", assistingnurse=" + assistingnurse + ", nurse=" + nurse
				+ ", physician2=" + physician2 + ", procedures2=" + procedures2 + ", patient2=" + patient2 + "]";
	}

}