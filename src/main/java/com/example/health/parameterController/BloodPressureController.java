package com.example.health.parameterController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.health.model.Patient;
import com.example.health.parameter.BloodPressure;
import com.example.health.parameterRepository.BloodPressureRepository;

@Controller
public class BloodPressureController {
	
	@Autowired
	private BloodPressureRepository bloodpressurerepository;
	
	
	

	
	//BloodPressure bloodpressure = new BloodPressure("30","2020-20-12");
	

	
	
}
