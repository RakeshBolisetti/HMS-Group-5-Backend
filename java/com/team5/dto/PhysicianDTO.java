package com.team5.dto;

import com.team5.beans.Physician;

public class PhysicianDTO {

    private Integer employeeid;
    private String name;

    private String position;

    private Integer ssn;
    private Integer userid;

    public PhysicianDTO() {
    }
    public PhysicianDTO(Physician physician) {
    	
        this.employeeid = physician.getEmployeeid();
        this.name = physician.getName();
        this.position = physician.getPosition();
        this.ssn = physician.getSsn();
        this.userid = physician.getUserid();
    }

//     public PhysicianDTO physicianDto(Physician physician) {
//     	PhysicianDTO dto = new PhysicianDTO();
//         dto.setEmployeeid(physician.getEmployeeid());
//         dto.setName(physician.getName());
//         dto.setPosition(physician.getPosition());
//         dto.setSsn(physician.getSsn());
//         dto.setUserid(physician.getUserid());
//         return dto;
        
//     }


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
}
