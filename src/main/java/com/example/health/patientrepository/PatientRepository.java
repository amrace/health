package com.example.health.patientrepository;

import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.health.model.Patient;
import com.example.health.parameter.BloodPressure;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	List<Patient> findAll();
	Patient getPatientById(Integer id);
	
	
	@Query("SELECT p FROM patient p WHERE p.firstName LIKE %?1%"
	+"OR p.id LIKE %?1%" )
	public List<Patient> findAll(String keyword);
	
	
	public List <Patient> findPatientByLastName(String lastName);
	
	
	
}
