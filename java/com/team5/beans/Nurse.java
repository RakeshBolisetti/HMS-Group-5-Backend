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
@Table(name = "nurse")
public class Nurse implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "EmployeeID", nullable = false)
    private Integer employeeid;

    
    @Column(name = "Name", nullable = false, length = 30)
    private String name;

    @Column(name = "Position", nullable = false, length = 30)
    private String position;

    @Column(name = "Registered", nullable = false)
    private Boolean registered;

    @Column(name = "SSN", nullable = false)
    private Integer ssn;

    @Column(name = "UserId")
    private Integer userid;

   
    @ManyToOne
    @JoinColumn(name = "UserId", referencedColumnName = "UserId", insertable = false, updatable = false)
//    @JsonBackReference
    private Users users;

 
//
//    @OneToMany(mappedBy = "nurse")
//    @JsonBackReference
//    private List<Appointment> listOfAppointment;

//    @OneToMany(mappedBy = "nurse")
//    @JsonBackReference
//    private List<Undergoes> listOfUndergoes;

    public Nurse() {
        super();
    }

    // --- GETTERS & SETTERS FOR FIELDS
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getEmployeeid() {
        return this.employeeid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return this.position;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Boolean getRegistered() {
        return this.registered;
    }

    public void setSsn(Integer ssn) {
        this.ssn = ssn;
    }

    public Integer getSsn() {
        return this.ssn;
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

  

//    public List<Appointment> getListOfAppointment() {
//        return this.listOfAppointment;
//    }
//
//    public List<Undergoes> getListOfUndergoes() {
//        return this.listOfUndergoes;
//    }

  
  

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Nurse [employeeid=" + employeeid + ", name=" + name + ", position=" + position + ", registered="
				+ registered + ", ssn=" + ssn + ", userid=" + userid + ", users=" + users + "]";
	}

}