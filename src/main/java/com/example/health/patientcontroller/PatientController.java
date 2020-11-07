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

import com.example.health.model.Patient;
import com.example.health.parameter.BloodPressure;
import com.example.health.parameter.BodyWeight;
import com.example.health.parameter.PulseRate;
import com.example.health.parameter.RespiratoryRate;
import com.example.health.parameter.SPO2;
import com.example.health.parameter.Temperature;
import com.example.health.parameterRepository.BloodPressureRepository;
import com.example.health.parameterRepository.BodyWeightRepository;
import com.example.health.parameterRepository.PulseRateRepository;
import com.example.health.parameterRepository.RespiratoryRateRepository;
import com.example.health.parameterRepository.SPO2Repository;
import com.example.health.parameterRepository.TemperatureRepository;
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
    public BloodPressureRepository bloodpressureRepo;
    
    @Autowired
    public BodyWeightRepository bodyweightRepo;
    
    @Autowired
    private PulseRateRepository pulserateRepo;
    
    @Autowired
    private RespiratoryRateRepository respiratoryrateRepo;
    
    @Autowired
    private SPO2Repository spo2Repo;
    
    @Autowired
    private TemperatureRepository temperatureRepo;
    
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
			  patient.setDate(new Date());
			  patientrepository.save(patient);
		  if(bindingResult.hasErrors()) { 
			  model.addAttribute("error", "The form is not submitted");
			  return "redirect:/register"; }
		  else if(patientrepository.save(patient)==null){
			  model.addAttribute("message", "Registeration Failed");
			  return "redirect:/register";
		  }
		  else {
			  
			 
			  model.addAttribute("registrationSuccess",true);
			  model.addAttribute("message","Patient is successfully registered.");
			  return "redirect:/getAll"; 
		  } 
		  
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
    	patient1.setGender(updatePatient.getGender());
    	patient1.setPhone(updatePatient.getPhone());
    	patient1.setHistoryOfPatient(updatePatient.getHistoryOfPatient());
    	patientrepository.save(patient1);
    	
		return "redirect:/getAll";
	}
    
    
    @GetMapping("/report/{id}")
    public ModelAndView getPatientReport( ModelAndView modelAndView ,@PathVariable int id) {
		Patient patient = patientrepository.getOne(id);
		
		List<BloodPressure> bloodpressure = bloodpressureRepo.findAllByPatient(patient);
		modelAndView.addObject("bloodpressure", bloodpressure);
		
		List <BodyWeight> bodyweight = bodyweightRepo.findAllByPatient(patient);
		modelAndView.addObject("bodyweight", bodyweight);
		
		List <PulseRate> pulserate = pulserateRepo.findAllByPatient(patient);
		modelAndView.addObject("pulserate", pulserate);
		
		List <RespiratoryRate> respiratoryrate = respiratoryrateRepo.findAllByPatient(patient);
		modelAndView.addObject("respiratoryrate", respiratoryrate);
		
		List <SPO2> spo2 = spo2Repo.findAllByPatient(patient);
		modelAndView.addObject("spo2", spo2);
		
		List <Temperature> temperature = temperatureRepo.findAllByPatient(patient);
		modelAndView.addObject("temperature", temperature);
		
		
		modelAndView.addObject("patient", patient);
    	modelAndView.setViewName("report");
    	return modelAndView;
    }

}
