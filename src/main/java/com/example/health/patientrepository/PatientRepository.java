package com.example.health.patientrepository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	List<Patient> findAll();
	Patient getPatientById(Integer id);

}
