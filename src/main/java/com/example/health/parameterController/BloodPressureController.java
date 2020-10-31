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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.health.model.Patient;
import com.example.health.parameter.BloodPressure;
import com.example.health.parameterRepository.BloodPressureRepository;
import com.example.health.parameterservice.BloodPressureService;
import com.example.health.patientService.PatientService;
import com.example.health.patientrepository.PatientRepository;
import com.example.health.userrepository.UserRepository;
import com.mysql.cj.Session;

@Controller
public class BloodPressureController {

	@Autowired
	private BloodPressureService bloodpressureService;

	@Autowired
	private PatientService patientservice;;

	@Autowired
	private BloodPressureRepository bloodpressureRepo;

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private UserRepository userRepo;

	/*
	 * @GetMapping("/get") public List<BloodPressure> getAllBloodPressure(){ return
	 * bloodpressureService.findAll(); }
	 */

	@GetMapping("/get")
	public List<Patient> getallPatient() {
		return patientservice.findAll();
	}

	// To get the BP form {all ok working fine}

	@GetMapping("/bp/{id}")
	public ModelAndView showBPForm(ModelAndView modelAndView, @ModelAttribute Patient patient,@PathVariable int id) {
		 //patient = patientRepo.getOne(id);
		List<Patient> patientlist = patientRepo.findAll();
		modelAndView.addObject("bloodpressure", new BloodPressure());
		//this object(patientid) is used to link with thymleaf constraint key which is hidden
		modelAndView.addObject("patientid", id);
		modelAndView.addObject("patientlist", patientlist);
		// modelAndView.addObject("role", "ROLE_ADMIN");
		modelAndView.setViewName("parameters/BP");
		return modelAndView;
	}

	// save the and bloodpressure form {not posting}

	
	  @PostMapping("/bp/save") 
	  public String saveBP(@ModelAttribute BloodPressure bloodpressure1 ,HttpServletRequest request, Principal principle) { 
		  //Patient patient = patientRepo.getOne(id);
		  int patientid = Integer.parseInt(request.getParameter("id"));
		  bloodpressure1.setPatientid(patientid);
		  bloodpressure1.setDate(new Date());
		  //bloodpressure1.setPatientid(patient.getId());
		  bloodpressureRepo.save(bloodpressure1);
	  
		  return "redirect:/getAll";
	  
	  }
	 

		/*
		 * @PostMapping("/bp") public String register(@ModelAttribute("bloodpressure")
		 * BloodPressure bloodpressure, BindingResult bindingResult, Model model) {
		 * 
		 * if (bindingResult.hasErrors()) { model.addAttribute("error",
		 * "The form cannot be null"); return "redirect:/bp"; }
		 * 
		 * model.addAttribute("Success", true); model.addAttribute("message",
		 * "Data inserted successfully"); // bloodpressure.setDate(new Date());
		 * //bloodpressure.setDate(new Date()); bloodpressureRepo.save(bloodpressure);
		 * return "redirect:/getAll"; }
		 */
}
