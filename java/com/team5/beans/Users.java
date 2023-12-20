package com.team5.beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;

@Entity
@Table(name="users")
public class Users implements Serializable {
	

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name="UserId", nullable=false)
	private Integer id;
	
	@Column(name="FirstName", nullable=false)
	private String firstName;
	
	@Column(name="LastName")
	private String lastName;
	
	@Email
	@Column(name="Email", unique = true)
	private String email;
	
	@Column(name="Password", nullable=false)
	private String password;
	
	@Column(name="CreatedOn")
	private Date createdOn;
	
	@Column(name="IsActive")
	private Boolean isActive;
	
	@Column(name="Role")
	private String role="PATIENT";
	
//	@OneToMany(mappedBy="users")
//    private List<Patient> listOfPatient ; 

   

	
	public Integer getUserId() {
		return id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public void setListOfPatient(List<Patient> listOfPatient) {
//		this.listOfPatient = listOfPatient;
//	}

	
	public void setUserId(Integer userId) {
		this.id = userId;
	}

	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	public String getLastName() {
		return lastName;
	}

	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	
	public Boolean getIsActive() {
		return isActive;
	}

	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	public String getRole() {
		return role;
	}

	
	public void setRole(String role) {
		this.role = role;
	}
	
	//--- GETTERS FOR LINKS
//    public List<Patient> getListOfPatient() {
//        return this.listOfPatient;
//    } 

  

    @Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", password=" + password + ", createdOn=" + createdOn + ", isActive=" + isActive + ", role=" + role
				+ "]";
	} 

	public Users() {
		super();
	}

}
