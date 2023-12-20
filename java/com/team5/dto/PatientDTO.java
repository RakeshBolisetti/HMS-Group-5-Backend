package com.team5.dto;

import com.team5.beans.Patient;
import com.team5.beans.Users;

public class PatientDTO {
	
	private Integer ssn;
	private String name;
	private String address;
	private String phone;
	private Integer insuranceid;
	private Integer pcp;
	private Users users;
	
	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public PatientDTO() {
		super();
	}

	public PatientDTO(Patient patient){
		this.ssn = patient.getSsn();
		this.name = patient.getName();
		this.address = patient.getAddress();
		this.pcp = patient.getPcp();
		this.insuranceid = patient.getInsuranceid();
		this.phone = patient.getPhone();
	}
	/**
	 * @return the ssn
	 */
	public Integer getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the insuranceid
	 */
	public Integer getInsuranceid() {
		return insuranceid;
	}
	/**
	 * @param insuranceid the insuranceid to set
	 */
	public void setInsuranceid(Integer insuranceid) {
		this.insuranceid = insuranceid;
	}
	/**
	 * @return the pcp
	 */
	public Integer getPcp() {
		return pcp;
	}
	/**
	 * @param pcp the pcp to set
	 */
	public void setPcp(Integer pcp) {
		this.pcp = pcp;
	}
	
}
