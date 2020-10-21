package com.example.health.patientcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.health.model.Patient;
import com.example.health.patientrepository.PatientRepository;

@RestController
public class Restcontroller {
	
	@Autowired
	private PatientRepository patientrepo;
	
	
	@RequestMapping(value="/rest", method= RequestMethod.GET, consumes="application/json")
	public List<Patient> getData(@RequestBody Patient patient ){
		return patientrepo.findAll();
	}

}
