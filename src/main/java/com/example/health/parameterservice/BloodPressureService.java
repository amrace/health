package com.example.health.parameterservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.health.parameter.BloodPressure;
import com.example.health.parameterRepository.BloodPressureRepository;

@Service
public class BloodPressureService {
	
	
	@Autowired 
	private BloodPressureRepository bloodpressureRepo;

	public void addbp(BloodPressure bloodpressure) {
		bloodpressureRepo.save(bloodpressure);
		
	}
	
	/*
	 * @Autowired private BloodPressureRepository bloodpressureRepo;
	 * 
	 * public List<BloodPressure> findAll() {
	 * 
	 * return bloodpressureRepo.findAll(); }
	 */
	
	
}
