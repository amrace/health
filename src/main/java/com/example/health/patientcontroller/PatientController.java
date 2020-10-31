package com.example.health.patientcontroller;

import com.example.health.patientrepository.PatientRepository;
import com.example.health.userrepository.UserRepository;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.health.UserModel.User;
import com.example.health.model.Patient;
import com.example.health.parameter.BloodPressure;
import com.example.health.patientService.PatientService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PatientController {


    @Autowired
    public PatientRepository patientrepository;
    
    @Autowired
    public UserRepository userRepository;
    
    @Autowired
    private PatientService service;
    
	
	  //To get the registeration form 	
		  @GetMapping("/register")
		  public ModelAndView showRegisterForm(ModelAndView
		  modelAndView) { Patient patient = new Patient();
		  modelAndView.addObject("patient", patient);
		  //modelAndView.addObject("role","ROLE_ADMIN");
		  modelAndView.setViewName("index");
		  return modelAndView;
		  }
		  
		  //save the and register form	  
		  @PostMapping("/register") 
		  public String register(@Valid @ModelAttribute("patient") Patient patient,BindingResult
		  bindingResult, Model model) {
		  
		  if(bindingResult.hasErrors()) { 
			  model.addAttribute("error", "The form is not submitted");
			  return "redirect:/register"; }
		  else {
		  
		  patientrepository.save(patient); 
		  } 
		  model.addAttribute("registrationSuccess",true);
		  model.addAttribute("message","Patient is successfully registered.");
		  patient.setDate(new Date());
		  return "redirect:/getAll"; 
		  }
			
		  
		  //Search and datatable
			  @GetMapping("/getAll") 
			  public String searchPatient(Model model, @RequestParam(required=false, name="keyword") String keyword) { 
				  List<Patient> list = service.listAll(keyword); 
				  model.addAttribute("patient", list);
				  model.addAttribute("keyword", keyword);
				  return "success";
				  //return "redirect:/getAll";
			  
			  }
			  
				 
	  
    @GetMapping("/")
    public String getFirstPage() {
    	return "AddPatient";
    	
    }
    
    
    @GetMapping(value="/delete/{id}")
    public String  processDeletePost(@PathVariable int id){
        patientrepository.deleteById(id);
        return "redirect:/getAll";
    	}
    
    
  
    
    @GetMapping(value="/update/{id}")
    public ModelAndView getEditItem(@PathVariable int id ){
    	Patient updatedPatient = patientrepository.getOne(id);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("editPatient");
        modelAndView.addObject("patient",updatedPatient);
        return modelAndView;
    }
    
    @PostMapping("/update/{id}")
	public String update(@ModelAttribute Patient updatePatient,HttpServletRequest request, @PathVariable int id) {
    	Patient patient1 = patientrepository.getOne(id);
    	patient1.setFirstName(updatePatient.getFirstName());
    	patient1.setLastName(updatePatient.getLastName());
    	patient1.setAge(updatePatient.getAge());
    	patient1.setAddress(updatePatient.getAddress());
    	patient1.setPhone(updatePatient.getPhone());
    	patient1.setHistoryOfPatient(updatePatient.getHistoryOfPatient());
    	patientrepository.save(patient1);
    	
		return "redirect:/getAll";
	}
    
    
    @GetMapping("/report")
    public ModelAndView getPatientReport( ModelAndView modelAndView ) {
		
		/*
		 * (List<Patient>) patientrepository.getPatientById(id);
		 * modelAndView.addObject("patient", findAll);
		 */
    	modelAndView.setViewName("report");
    	return modelAndView;
    }

}
