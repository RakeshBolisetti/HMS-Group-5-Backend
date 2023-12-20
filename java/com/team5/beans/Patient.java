package com.team5.beans;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient implements Serializable {

	public void setUsers(Users users) {
		this.users = users;
	}

	 

	
	@Id
	@Column(name = "SSN", nullable = false)
	private Integer ssn;

	@Column(name = "Name", nullable = false, length = 30)
	private String name;

	@Column(name = "Address", nullable = false, length = 30)
	private String address;

	@Column(name = "Phone", nullable = false, length = 30)
	private String phone;

	@Column(name = "InsuranceID")
	private Integer insuranceid;

	@Column(name = "PCP")
	private Integer pcp;

	@Column(name = "UserId")
	private Integer userid;

	
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
//	@JsonBackReference
	private Users users;

//	@OneToMany(mappedBy = "patient2")
//	@JsonBackReference
//	private List<Undergoes> listOfUndergoes;

//	@OneToMany(mappedBy = "patient2")
//	@JsonManagedReference
//	private List<Appointment> listOfAppointment;
	
	@ManyToOne
	@JoinColumn(name = "PCP", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
//	@JsonManagedReference
	private Physician physician;

	
	public Patient() {
		super();
	}

	// --- GETTERS & SETTERS FOR FIELDS
	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Integer getSsn() {
		return this.ssn;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setInsuranceid(Integer insuranceid) {
		this.insuranceid = insuranceid;
	}

	public Integer getInsuranceid() {
		return this.insuranceid;
	}

	public void setPcp(Integer pcp) {
		this.pcp = pcp;
	}

	public Integer getPcp() {
		return this.pcp;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getUserid() {
		return this.userid;
	}

	// --- GETTERS FOR LINKS
	public Users getUsers() {
		return this.users;
	}

//	public List<Undergoes> getListOfUndergoes() {
//		return this.listOfUndergoes;
//	}
//
//	public List<Appointment> getListOfAppointment() {
//		return this.listOfAppointment;
//	}


	public Physician getPhysician() {
		return this.physician;
	}

	@Override
	public String toString() {
		return "Patient [ssn=" + ssn + ", name=" + name + ", address=" + address + ", phone=" + phone + ", insuranceid="
				+ insuranceid + ", pcp=" + pcp + ", userid=" + userid + ", users=" + users + ", physician=" + physician
				+ "]";
	}



}