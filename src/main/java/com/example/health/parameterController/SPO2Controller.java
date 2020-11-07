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
import com.example.health.parameter.SPO2;
import com.example.health.parameterRepository.SPO2Repository;
import com.example.health.patientrepository.PatientRepository;

@Controller
public class SPO2Controller {
	
	@Autowired
	private SPO2Repository spo2Repo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@GetMapping("/spo2/{id}")
	public ModelAndView showSPO2Form(ModelAndView modelAndView, @ModelAttribute Patient patient,@PathVariable int id) {
		 patient = patientRepo.getOne(id);
		 modelAndView.addObject("spo2", new SPO2());		 
		//this object(patientid) is used to link with thymleaf constraint key which is hidden
		modelAndView.addObject("patientid", id);
		modelAndView.setViewName("parameters/spo2");
		return modelAndView;
	}
	
	// save the and SPO2 form { posted}
	
		  @PostMapping("/spo2/save") 
		  public String saveSPO2Value(@ModelAttribute SPO2 spo2 ,HttpServletRequest request, Principal principle) { 
			  
			  Patient patient = new Patient();
			  int patientid = Integer.parseInt(request.getParameter("id"));
			  spo2.setId(0);
			  
			  Patient patient1 = patientRepo.getOne(patientid);
			  spo2.setPatient(patient1);
			  
			  spo2.setDate(new Date());	  
			  spo2Repo.save(spo2);
			  return "redirect:/getAll";
		  
		  }
		 



}
