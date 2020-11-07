package com.example.health.parameterRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;
import com.example.health.parameter.BodyWeight;

@Repository
public interface BodyWeightRepository extends JpaRepository<BodyWeight, Integer> {
	
	List<BodyWeight> findAllByPatient(Patient patient);

}
