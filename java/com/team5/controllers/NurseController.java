package com.team5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.beans.Nurse;
import com.team5.dto.NurseDTO;
import com.team5.services.NurseService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin//(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/nurse")

@SecurityRequirement(name = "bearerAuth")
public class NurseController {
    @Autowired
    private NurseService nurseService;

    @PostMapping
  
    public ResponseEntity<String> addNurse(@RequestBody NurseDTO nurseDTO) {
        Nurse nurse = new Nurse();
        nurse.setEmployeeid(nurseDTO.getEmployeeid());
        nurse.setName(nurseDTO.getName());
        nurse.setPosition(nurseDTO.getPosition());
        nurse.setRegistered(nurseDTO.getRegistered());
        nurse.setSsn(nurseDTO.getSsn());
        nurseService.addNurse(nurse);
        return new ResponseEntity<>("Record Created Successfully", HttpStatus.CREATED);
    }

    @GetMapping
  
    public ResponseEntity<List<NurseDTO>> getAllNurses() {
        List<Nurse> nurses = nurseService.getAllNurses();
        List<NurseDTO> nurseDTOs = nurses.stream().map(NurseDTO::new).toList();
        return new ResponseEntity<>(nurseDTOs, HttpStatus.OK);
    }

    @GetMapping("/{empid}")

    public ResponseEntity<NurseDTO> getNurseById(@PathVariable Integer empid) {
        Nurse nurse = nurseService.getNurseById(empid);
        if (nurse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            NurseDTO nurseDTO = new NurseDTO(nurse);
            return new ResponseEntity<>(nurseDTO, HttpStatus.OK);
        }
    }

    @GetMapping("/position/{empid}")
  
    public ResponseEntity<String> getPositionByEmpId(@PathVariable Integer empid) {
        String position = nurseService.getPositionByEmpId(empid);
        if (position == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(position, HttpStatus.OK);
        }
    }

    @GetMapping("/registered/{empid}")
 
    public ResponseEntity<Boolean> getRegisteredByEmpId(@PathVariable Integer empid) {
        Boolean registered = nurseService.getRegisteredByEmpId(empid);
        return new ResponseEntity<>(registered, HttpStatus.OK);
    }

    @PutMapping("/registered/{empid}")
  
    public ResponseEntity<NurseDTO> updateRegisteredByEmpId(@PathVariable Integer empid, @RequestBody Boolean registered) {
        Nurse nurse = nurseService.updateRegisteredByEmpId(empid, registered);
        if (nurse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            NurseDTO nurseDTO = new NurseDTO(nurse);
            return new ResponseEntity<>(nurseDTO, HttpStatus.OK);
        }
    }

    @PutMapping("/ssn/{empid}")
   
    public ResponseEntity<NurseDTO> updateSsnByEmpId(@PathVariable Integer empid, @RequestBody Integer ssn) {
        Nurse nurse = nurseService.updateSsnByEmpId(empid, ssn);
        if (nurse == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            NurseDTO nurseDTO = new NurseDTO(nurse);
            return new ResponseEntity<>(nurseDTO, HttpStatus.OK);
        }
    }
}