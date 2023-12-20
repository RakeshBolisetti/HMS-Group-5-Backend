package com.team5.beans;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "procedures")
public class Procedures implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "Code", nullable = false)
	private Integer code;


	@Column(name = "Name", nullable = false, length = 30)
	private String name;

	@Column(name = "Cost", nullable = false)
	private Double cost;

	// --- ENTITY LINKS ( RELATIONSHIP )
//	@OneToMany(mappedBy = "procedures2")
//	@JsonBackReference
//	private List<Undergoes> listOfUndergoes;

//	@OneToMany(mappedBy = "procedures")
//	@JsonBackReference
//	private List<TrainedIn> listOfTrainedIn;

	public Procedures() {
		super();
	}

	
	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getCost() {
		return this.cost;
	}


	@Override
	public String toString() {
		return "Procedures [code=" + code + ", name=" + name + ", cost=" + cost + "]";
	}

	
//	public List<Undergoes> getListOfUndergoes() {
//		return this.listOfUndergoes;
//	}
//
//	public List<TrainedIn> getListOfTrainedIn() {
//		return this.listOfTrainedIn;
//	}

	// --- toString specific method
	

}