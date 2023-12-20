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
@Table(name = "trained_in")
@IdClass(TrainedInId.class)
public class TrainedIn implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

   
    @Id
    @Column(name = "Physician", nullable = false)
    private Integer physician;

    @Id
    @Column(name = "Treatment", nullable = false)
    private Integer treatment;

   
    @Column(name = "CertificationDate", nullable = false)
    private Timestamp certificationdate;

    @Column(name = "CertificationExpires", nullable = false)
    private Timestamp certificationexpires;

 
    @ManyToOne
    @JoinColumn(name = "Treatment", referencedColumnName = "Code", insertable = false, updatable = false)
//    @JsonManagedReference
    private Procedures procedures;

    @ManyToOne
    @JoinColumn(name = "Physician", referencedColumnName = "EmployeeID", insertable = false, updatable = false)
//    @JsonBackReference
    private Physician physician2;

   
    public TrainedIn() {
        super();
    }

	public Integer getPhysician() {
		return physician;
	}

	public void setPhysician(Integer physician) {
		this.physician = physician;
	}

	public Integer getTreatment() {
		return treatment;
	}

	public void setTreatment(Integer treatment) {
		this.treatment = treatment;
	}

	public Timestamp getCertificationdate() {
		return certificationdate;
	}

	public void setCertificationdate(Timestamp certificationdate) {
		this.certificationdate = certificationdate;
	}

	public Timestamp getCertificationexpires() {
		return certificationexpires;
	}

	public void setCertificationexpires(Timestamp certificationexpires) {
		this.certificationexpires = certificationexpires;
	}

	public Procedures getProcedures() {
		return procedures;
	}

	public void setProcedures(Procedures procedures) {
		this.procedures = procedures;
	}

	public Physician getPhysician2() {
		return physician2;
	}

	public void setPhysician2(Physician physician2) {
		this.physician2 = physician2;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TrainedIn [physician=" + physician + ", treatment=" + treatment + ", certificationdate="
				+ certificationdate + ", certificationexpires=" + certificationexpires + ", procedures=" + procedures
				+ ", physician2=" + physician2 + "]";
	}

    
}
