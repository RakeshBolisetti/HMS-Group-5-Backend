package com.team5.beans;


import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "appointment")

public class Appointment implements Serializable {

	@Serial
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "AppointmentID", nullable = false)
	private Integer appointmentid;


	@Column(name = "Patient", nullable = false)
	private Integer patient;

	@Column(name = "PrepNurse")
	private Integer prepnurse;

	@Column(name = "Physician", nullable = false)
	private Integer physician;

	@Column(name = "AppointmentDateTime", nullable = false)
	private Timestamp appointmentDateTime;

	@Column(name = "ExaminationRoom", nullable = false)
	private String examinationroom;

	

	@ManyToOne
	@JoinColumn(name = "Patient", referencedColumnName = "SSN", insertable = false, updatable = false)
//	@JsonBackReference
	private Patient patient2;

	@ManyToOne
	@JoinColumn(name = "Physician", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
//	@JsonBackReference
	private Physician physician2;

	@ManyToOne
	@JoinColumn(name = "PrepNurse", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
//	@JsonBackReference
	private Nurse nurse;

	
	public Appointment() {
		super();
	}


	public void setAppointmentid(Integer appointmentid) {
		this.appointmentid = appointmentid;
	}

	public Integer getAppointmentid() {
		return this.appointmentid;
	}

	public void setPatient(Integer patient) {
		this.patient = patient;
	}

	public Integer getPatient() {
		return this.patient;
	}

	public void setPrepnurse(Integer prepnurse) {
		this.prepnurse = prepnurse;
	}

	public Integer getPrepnurse() {
		return this.prepnurse;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getPhysician() {
		return this.physician;
	}

	public void setAppointmentDateTime(Timestamp appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public Timestamp getAppointmentDateTime() {
		return this.appointmentDateTime;
	}

	public void setExaminationroom(String examinationroom) {
		this.examinationroom = examinationroom;
	}

	public String getExaminationroom() {
		return this.examinationroom;
	}

	

	public Patient getPatient2() {
		return this.patient2;
	}

	public Physician getPhysician2() {
		return this.physician2;
	}

	public Nurse getNurse() {
		return this.nurse;
	}


	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", patient=" + patient + ", prepnurse=" + prepnurse
				+ ", physician=" + physician + ", appointmentDateTime=" + appointmentDateTime + ", examinationroom="
				+ examinationroom + ", patient2=" + patient2 + ", physician2=" + physician2 + ", nurse=" + nurse + "]";
	}



}
