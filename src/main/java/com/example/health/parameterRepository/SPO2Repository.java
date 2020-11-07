package com.example.health.parameterRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;
import com.example.health.parameter.SPO2;

@Repository
public interface SPO2Repository extends JpaRepository<SPO2, Integer>{
	
	List<SPO2> findAllByPatient(Patient patient);

}
