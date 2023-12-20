package com.team5.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AppointmentDTO {

    private Integer patient;
    private Integer physician;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSSSSS")
    private Timestamp appointmentDateTime;
    private String examinationroom;
	/**
	 * @return the patient
	 */
	public Integer getPatient() {
		return patient;
	}
	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Integer patient) {
		this.patient = patient;
	}
	/**
	 * @return the physician
	 */
	public Integer getPhysician() {
		return physician;
	}
	/**
	 * @param physician the physician to set
	 */
	public void setPhysician(Integer physician) {
		this.physician = physician;
	}
	/**
	 * @return the appointmentDateTime
	 */
	public Timestamp getAppointmentDateTime() {
		return appointmentDateTime;
	}
	/**
	 * @param appointmentDateTime the appointmentDateTime to set
	 */
	public void setAppointmentDateTime(Timestamp appointmentDateTime) {
		
		this.appointmentDateTime = appointmentDateTime;
	}
	/**
	 * @return the examinationroom
	 */
	public String getExaminationroom() {
		return examinationroom;
	}
	/**
	 * @param examinationroom the examinationroom to set
	 */
	public void setExaminationroom(String examinationroom) {
		this.examinationroom = examinationroom;
	}
	public AppointmentDTO() {
		super();
	}
    
    
}
