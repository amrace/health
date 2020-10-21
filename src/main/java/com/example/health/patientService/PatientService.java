package com.example.health.patientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.health.model.Patient;
import com.example.health.patientrepository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientrepository;
	
	
	public List<Patient> listAll( String keyword ){
		if(keyword != null) {
			return patientrepository.findAll(keyword);
		}
		
		return patientrepository.findAll();
		
	}


	
	  public List<Patient> getPatientByLastName(String lastName) {
	  return patientrepository.findPatientByLastName(lastName); 
	   }
	 
}
