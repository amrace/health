package com.example.health.parameterController;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.health.model.Patient;
import com.example.health.parameter.Temperature;
import com.example.health.parameterRepository.TemperatureRepository;
import com.example.health.patientrepository.PatientRepository;

@Controller
public class TemperatureController {
	
	@Autowired
	private TemperatureRepository temperatureRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@GetMapping("/temperature/{id}")
	public ModelAndView showSPO2Form(ModelAndView modelAndView, @ModelAttribute Patient patient,@PathVariable int id) {
		 patient = patientRepo.getOne(id);
		 modelAndView.addObject("temperature", new Temperature());		 
		//this object(patientid) is used to link with thymleaf constraint key which is hidden
		modelAndView.addObject("patientid", id);
		modelAndView.setViewName("parameters/temperature");
		return modelAndView;
	}
	
	// save the and Temperature form { posted}
	
		  @PostMapping("/temperature/save") 
		  public String saveTemperature(@ModelAttribute Temperature temperature ,HttpServletRequest request, Principal principle) { 
			  
			  Patient patient = new Patient();
			  int patientid = Integer.parseInt(request.getParameter("id"));
			  temperature.setId(0);
			  
			  Patient patient1 = patientRepo.getOne(patientid);
			  temperature.setPatient(patient1);
			  
			  temperature.setDate(new Date());	  
			  temperatureRepo.save(temperature);
			  return "redirect:/getAll";
		  
		  }
		 



}
