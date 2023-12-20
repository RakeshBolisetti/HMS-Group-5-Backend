package com.team5.beans;


import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room implements Serializable {

	@Serial
    private static final long serialVersionUID = 1L;

	
	@Id
	@Column(name = "RoomNumber", nullable = false)
	private Integer roomnumber;

	
	@Column(name = "RoomType", nullable = false, length = 30)
	private String roomtype;

	@Column(name = "BlockFloor", nullable = false)
	private Integer blockfloor;

	@Column(name = "BlockCode", nullable = false)
	private Integer blockcode;

	@Column(name = "Unavailable", nullable = false)
	private Boolean unavailable;

	
	



	
	public Room() {
		super();
	}

	public void setRoomnumber(Integer roomnumber) {
		this.roomnumber = roomnumber;
	}

	public Integer getRoomnumber() {
		return this.roomnumber;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}

	public String getRoomtype() {
		return this.roomtype;
	}

	public void setBlockfloor(Integer blockfloor) {
		this.blockfloor = blockfloor;
	}

	public Integer getBlockfloor() {
		return this.blockfloor;
	}

	public void setBlockcode(Integer blockcode) {
		this.blockcode = blockcode;
	}

	public Integer getBlockcode() {
		return this.blockcode;
	}

	public void setUnavailable(Boolean unavailable) {
		this.unavailable = unavailable;
	}

	public Boolean getUnavailable() {
		return this.unavailable;
	}


	@Override
	public String toString() {
		return "Room [roomnumber=" + roomnumber + ", roomtype=" + roomtype + ", blockfloor=" + blockfloor
				+ ", blockcode=" + blockcode + ", unavailable=" + unavailable + "]";
	}

}