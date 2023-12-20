package com.team5.beans;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department implements Serializable {

	public void setPhysician(Physician physician) {
		this.physician = physician;
	}

	@Serial
    private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "DepartmentID", nullable = false)
	private Integer departmentid;


	@Column(name = "Name", nullable = false, length = 30)
	private String name;

	@Column(name = "Head", nullable = false)
	private Integer head;


	@ManyToOne
	@JoinColumn(name = "Head", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
	private Physician physician;

//	@OneToMany(mappedBy = "department2")
//	@JsonBackReference
//	private List<AffiliatedWith> listOfAffiliatedWith;

	
	public Department() {
		super();
	}


	public void setDepartmentid(Integer departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getDepartmentid() {
		return this.departmentid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setHead(Integer head) {
		this.head = head;
	}

	public Integer getHead() {
		return this.head;
	}

	// --- GETTERS FOR LINKS
	public Physician getPhysician() {
		return this.physician;
	}


	@Override
	public String toString() {
		return "Department [departmentid=" + departmentid + ", name=" + name + ", head=" + head + ", physician="
				+ physician + "]";
	}

//	public List<AffiliatedWith> getListOfAffiliatedWith() {
//		return this.listOfAffiliatedWith;
//	}



}