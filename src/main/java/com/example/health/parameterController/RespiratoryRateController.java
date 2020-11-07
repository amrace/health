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
import com.example.health.parameter.RespiratoryRate;
import com.example.health.parameterRepository.RespiratoryRateRepository;
import com.example.health.patientrepository.PatientRepository;

@Controller
public class RespiratoryRateController {
	
	@Autowired
	public RespiratoryRateRepository respiratoryrateRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	
	@GetMapping("/respiratoryrate/{id}")
	public ModelAndView showRespiratoryRateForm(ModelAndView modelAndView, @ModelAttribute Patient patient,@PathVariable int id) {
		 patient = patientRepo.getOne(id);
		 modelAndView.addObject("respiratoryrate", new RespiratoryRate());		 
		//this object(patientid) is used to link with thymleaf constraint key which is hidden
		modelAndView.addObject("patientid", id);
		modelAndView.setViewName("parameters/respiratoryrate");
		return modelAndView;
	}
	
	// save the and respiratoryrate form { posted}
	
		  @PostMapping("/respiratoryrate/save") 
		  public String saveRespiratoryRate(@ModelAttribute RespiratoryRate respiratoryrate ,HttpServletRequest request, Principal principle) { 
			  
			  Patient patient = new Patient();
			  int patientid = Integer.parseInt(request.getParameter("id"));
			  respiratoryrate.setId(0);
			  
			  Patient patient1 = patientRepo.getOne(patientid);
			  respiratoryrate.setPatient(patient1);
			  
			  respiratoryrate.setDate(new Date());	  
			  respiratoryrateRepo.save(respiratoryrate);
			  return "redirect:/getAll";
		  
		  }
		 


}
