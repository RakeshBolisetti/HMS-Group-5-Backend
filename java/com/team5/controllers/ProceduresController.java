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

import com.team5.dto.ProceduresDTO;
import com.team5.exceptions.InvalidDataException;
import com.team5.exceptions.NotFoundException;
import com.team5.services.ProceduresService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@CrossOrigin //(origins = "http://localhost:4200/*", allowCredentials="true")
@RestController
@RequestMapping("/api/v1/procedures")
@SecurityRequirement(name = "bearerAuth")
public class ProceduresController {
	
	@Autowired
    private ProceduresService proceduresService;

    @GetMapping("")
    public ResponseEntity<List<ProceduresDTO>> findAll(){
    	
        List<ProceduresDTO> proceduresDTO = proceduresService.findAll();
        if(!proceduresDTO.isEmpty()) {
            return new ResponseEntity<>(proceduresDTO, HttpStatus.OK);
        }else {
            throw new NotFoundException("No Procedures found !");
        }
    }

    @PostMapping("")
    public ResponseEntity<ProceduresDTO> addData(@RequestBody ProceduresDTO obj) {
        ProceduresDTO created = proceduresService.create(obj);
        if (created != null) {
            return new ResponseEntity<>(created, HttpStatus.OK);
        } else {
            throw new InvalidDataException("Invalid \"Procedures\" data, failed to add !");
        }
    }

    @GetMapping("/name/{name}")
   
    public ResponseEntity<Double> getCostByName(@PathVariable String name){
        Double foundCost = proceduresService.getCostByName(name);
        if(foundCost!=null) {
            return new ResponseEntity<>(foundCost, HttpStatus.OK);
        }else {
            throw new NotFoundException("No Procedure with the given Name found !");
        }
    }

    @PutMapping("/update/cost/{id}")
  
    public ResponseEntity<ProceduresDTO> updateCostById(@PathVariable Integer id, @RequestBody ProceduresDTO p){
        ProceduresDTO returnedProcedures = proceduresService.updateCostByCode(id, p);
        if(returnedProcedures!=null) {
            return new ResponseEntity<>(returnedProcedures, HttpStatus.OK);
        }else {
            throw new NotFoundException("No Procedure with the given Code found !");
        }
    }

    @PutMapping("/update/name/{name}")
    
    public ResponseEntity<ProceduresDTO> updateCostByName(@PathVariable String name, @RequestBody ProceduresDTO p){
        ProceduresDTO returnedProcedures = proceduresService.updateCostByName(name, p);
        if(returnedProcedures!=null) {
            return new ResponseEntity<>(returnedProcedures, HttpStatus.OK);
        }else {
            throw new NotFoundException("No Procedure with the given Name found !");
        }
    }


}