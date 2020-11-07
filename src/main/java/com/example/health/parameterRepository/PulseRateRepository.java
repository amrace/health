package com.example.health.parameterRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;
import com.example.health.parameter.PulseRate;

@Repository
public interface PulseRateRepository extends JpaRepository<PulseRate, Integer>{
	
	List<PulseRate> findAllByPatient(Patient patient);

}
