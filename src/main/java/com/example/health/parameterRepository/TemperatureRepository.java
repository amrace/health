package com.example.health.parameterRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;
import com.example.health.parameter.SPO2;
import com.example.health.parameter.Temperature;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Integer>{
	
	List<Temperature> findAllByPatient(Patient patient);

}
