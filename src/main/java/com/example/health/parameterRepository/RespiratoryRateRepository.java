package com.example.health.parameterRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;
import com.example.health.parameter.RespiratoryRate;

@Repository
public interface RespiratoryRateRepository extends JpaRepository<RespiratoryRate, Integer>{
	
	List<RespiratoryRate> findAllByPatient(Patient patient);
}
