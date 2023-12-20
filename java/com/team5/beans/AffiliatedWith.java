package com.team5.beans;


import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "affiliated_with")
@IdClass(AffiliatedWithId.class)
public class AffiliatedWith implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "Physician", nullable = false)
	private Integer physician;

	@Id
	@Column(name = "Department", nullable = false)
	private Integer department;

	@Column(name = "PrimaryAffiliation", nullable = false)
	private Boolean primaryaffiliation;

	// --- ENTITY LINKS ( RELATIONSHIP )
//	@ManyToOne
//	@JoinColumn(name = "Department", referencedColumnName = "DepartmentID", insertable = false, updatable = false)
//	@JsonBackReference
//	private Department department2;

//	@ManyToOne
//	@JoinColumn(name = "Physician", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
//	@JsonBackReference
//	private Physician physician2;

	
	public AffiliatedWith() {
		super();
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getPhysician() {
		return this.physician;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Integer getDepartment() {
		return this.department;
	}

	public void setPrimaryaffiliation(Boolean primaryaffiliation) {
		this.primaryaffiliation = primaryaffiliation;
	}

	public Boolean getPrimaryaffiliation() {
		return this.primaryaffiliation;
	}

	@Override
	public String toString() {
		return "AffiliatedWith [physician=" + physician + ", department=" + department + ", primaryaffiliation="
				+ primaryaffiliation + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, physician, primaryaffiliation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AffiliatedWith other = (AffiliatedWith) obj;
		return Objects.equals(department, other.department) && Objects.equals(physician, other.physician)
				&& Objects.equals(primaryaffiliation, other.primaryaffiliation);
	}
	

//	public Department getDepartment2() {
//		return this.department2;
//	}
//
//	public Physician getPhysician2() {
//		return this.physician2;
//	}

	// --- toString specific method
	

}