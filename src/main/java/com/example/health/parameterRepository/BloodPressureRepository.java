package com.example.health.parameterRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;
import com.example.health.parameter.BloodPressure;


@Repository
public interface BloodPressureRepository extends JpaRepository<BloodPressure, Integer> {
	
	List<BloodPressure> findAllByPatient(Patient patient);
}
