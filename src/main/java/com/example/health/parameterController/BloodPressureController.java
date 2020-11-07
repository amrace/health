package com.example.health.parameterController;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.health.model.Patient;
import com.example.health.parameter.BloodPressure;
import com.example.health.parameterRepository.BloodPressureRepository;
import com.example.health.patientService.PatientService;
import com.example.health.patientrepository.PatientRepository;


@Controller
public class BloodPressureController {


	@Autowired
	private PatientService patientservice;;

	@Autowired
	private BloodPressureRepository bloodpressureRepo;

	@Autowired
	private PatientRepository patientRepo;


	@GetMapping("/get")
	public List<Patient> getallPatient() {
		return patientservice.findAll();
	}

	// To get the BP form {all ok working fine}

	@GetMapping("/bp/{id}")
	public ModelAndView showBPForm(ModelAndView modelAndView, @ModelAttribute Patient patient,@PathVariable int id) {
		 patient = patientRepo.getOne(id);
		modelAndView.addObject("bloodpressure", new BloodPressure());
		//this object(patientid) is used to link with thymleaf constraint key which is hidden
		modelAndView.addObject("patientid", id);
		// modelAndView.addObject("role", "ROLE_ADMIN");
		modelAndView.setViewName("parameters/BP");
		return modelAndView;
	}

	// save the and bloodpressure form { posted}
	
	  @PostMapping("/bp/save") 
	  public String saveBP(@ModelAttribute BloodPressure bloodpressure ,HttpServletRequest request, Principal principle) { 
		  
		  Patient patient = new Patient();
		  int patientid = Integer.parseInt(request.getParameter("id"));
		  bloodpressure.setId(0);
		  
		  Patient patient1 = patientRepo.getOne(patientid);
		  bloodpressure.setPatient(patient1);
		  
		  bloodpressure.setDate(new Date());	  
		  bloodpressureRepo.save(bloodpressure);
		  return "redirect:/getAll";
	  
	  }
	 

}
