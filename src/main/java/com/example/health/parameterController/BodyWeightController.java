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
import com.example.health.parameter.BodyWeight;
import com.example.health.parameterRepository.BodyWeightRepository;
import com.example.health.patientrepository.PatientRepository;

@Controller
public class BodyWeightController {
	
	@Autowired
	public PatientRepository patientRepo;
	
	@Autowired
	public BodyWeightRepository bodyweightRepo;
	
	@GetMapping("/bodyweight/{id}")
	public ModelAndView showBodyWeightForm(ModelAndView modelAndView, @ModelAttribute Patient patient,@PathVariable int id) {
		 patient = patientRepo.getOne(id);
		 modelAndView.addObject("bodyweight", new BodyWeight());		 
		//this object(patientid) is used to link with thymleaf constraint key which is hidden
		modelAndView.addObject("patientid", id);
		modelAndView.setViewName("parameters/BodyWeight");
		return modelAndView;
	}
	
	// save the and body weight form { posted}
	
		  @PostMapping("/bodyweight/save") 
		  public String saveBodyWeight(@ModelAttribute BodyWeight bodyweight ,HttpServletRequest request, Principal principle) { 
			  
			  Patient patient = new Patient();
			  int patientid = Integer.parseInt(request.getParameter("id"));
			  bodyweight.setId(0);
			  
			  Patient patient1 = patientRepo.getOne(patientid);
			  bodyweight.setPatient(patient1);
			  
			  bodyweight.setDate(new Date());	  
			  bodyweightRepo.save(bodyweight);
			  return "redirect:/getAll";
		  
		  }
		 

}
