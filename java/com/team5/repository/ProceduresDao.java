package com.team5.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team5.beans.Procedures;

@Repository
public interface ProceduresDao extends JpaRepository<Procedures, Integer> {
	Optional<Procedures> findByName(String name);
	Optional<Procedures> findByCode(Integer code);

}
