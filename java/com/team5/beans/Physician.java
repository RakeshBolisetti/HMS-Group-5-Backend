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
@Table(name = "physician")
public class Physician implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

   
    @Id
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeid;

    
    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Column(name = "Position", nullable = false, length = 30)
    private String position;

    @Column(name = "SSN", nullable = false)
    private Integer ssn;

    @Column(name = "UserId")
    private Integer userid;

  
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
    @JsonBackReference
    private Users users;

//    @OneToMany(mappedBy = "physician2")
//    @JsonBackReference
//    private List<TrainedIn> listOfTrainedIn;
//
//    @OneToMany(mappedBy = "physician")
//    @JsonBackReference
//    private List<Patient> listOfPatient;

//    @OneToMany(mappedBy = "physician2")
//    @JsonManagedReference
//    private List<Appointment> listOfAppointment;

//    @OneToMany(mappedBy = "physician2")
//    @JsonBackReference
//    private List<AffiliatedWith> listOfAffiliatedWith;

//    @OneToMany(mappedBy = "physician")
//    @JsonBackReference
//    private List<Department> listOfDepartment;
//
//    @OneToMany(mappedBy = "physician2")
//    @JsonBackReference
//    private List<Undergoes> listOfUndergoes;

    public Physician() {
        super();
    }

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

//	public List<TrainedIn> getListOfTrainedIn() {
//		return listOfTrainedIn;
//	}
//
//	public void setListOfTrainedIn(List<TrainedIn> listOfTrainedIn) {
//		this.listOfTrainedIn = listOfTrainedIn;
//	}
//
//	public List<Patient> getListOfPatient() {
//		return listOfPatient;
//	}
//
//	public void setListOfPatient(List<Patient> listOfPatient) {
//		this.listOfPatient = listOfPatient;
//	}
//
//	public List<Appointment> getListOfAppointment() {
//		return listOfAppointment;
//	}
//
//	public void setListOfAppointment(List<Appointment> listOfAppointment) {
//		this.listOfAppointment = listOfAppointment;
//	}
//
//	public List<AffiliatedWith> getListOfAffiliatedWith() {
//		return listOfAffiliatedWith;
//	}
//
//	public void setListOfAffiliatedWith(List<AffiliatedWith> listOfAffiliatedWith) {
//		this.listOfAffiliatedWith = listOfAffiliatedWith;
//	}
//
//	public List<Department> getListOfDepartment() {
//		return listOfDepartment;
//	}
//
//	public void setListOfDepartment(List<Department> listOfDepartment) {
//		this.listOfDepartment = listOfDepartment;
//	}
//
//	public List<Undergoes> getListOfUndergoes() {
//		return listOfUndergoes;
//	}
//
//	public void setListOfUndergoes(List<Undergoes> listOfUndergoes) {
//		this.listOfUndergoes = listOfUndergoes;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Physician [employeeid=" + employeeid + ", name=" + name + ", position=" + position + ", ssn=" + ssn
				+ ", userid=" + userid + ", users=" + users + ", listOfTrainedIn="  + "]";
	}

    
}
