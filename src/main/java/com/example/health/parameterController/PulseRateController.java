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
import com.example.health.parameter.PulseRate;
import com.example.health.parameterRepository.PulseRateRepository;
import com.example.health.patientrepository.PatientRepository;

@Controller
public class PulseRateController {
	
	
	@Autowired
	public PulseRateRepository pulserateRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	
	@GetMapping("/pulserate/{id}")
	public ModelAndView showPulseRateForm(ModelAndView modelAndView, @ModelAttribute Patient patient,@PathVariable int id) {
		 patient = patientRepo.getOne(id);
		 modelAndView.addObject("pulserate", new PulseRate());		 
		//this object(patientid) is used to link with thymleaf constraint key which is hidden
		modelAndView.addObject("patientid", id);
		modelAndView.setViewName("parameters/PulseRate");
		return modelAndView;
	}
	
	// save the pulserate form { posted}
	
		  @PostMapping("/pulserate/save") 
		  public String savePulseRate(@ModelAttribute PulseRate pulserate ,HttpServletRequest request, Principal principle) { 
			  
			  Patient patient = new Patient();
			  int patientid = Integer.parseInt(request.getParameter("id"));
			  pulserate.setId(0);
			  
			  Patient patient1 = patientRepo.getOne(patientid);
			  pulserate.setPatient(patient1);
			  
			  pulserate.setDate(new Date());	  
			  pulserateRepo.save(pulserate);
			  return "redirect:/getAll";
		  
		  }
		 

	
	
	

}
