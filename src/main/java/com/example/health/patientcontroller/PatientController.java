package com.example.health.patientcontroller;

import com.example.health.patientrepository.PatientRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.health.model.Patient;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class PatientController {


    @Autowired
    public PatientRepository patientrepository;


    @GetMapping("/register")
    public ModelAndView showRegisterForm(ModelAndView modelAndView) {
        Patient patient = new Patient();
        modelAndView.addObject("patient", patient);
        modelAndView.setViewName("index");
        return modelAndView;
    }

    //save the users
    @PostMapping("/register")
    public String register(@ModelAttribute Patient patient) {
    	patientrepository.save(patient);
        return "redirect:getAll";
    }
    
	
	  @GetMapping("/getAll") 
	  public String getHome(Model model) {
	  List<Patient> findAll = patientrepository.findAll();
	  model.addAttribute("patient", findAll); 
	  System.out.println(findAll); 
	  return
	  "success"; }
	 
    
    @GetMapping("/")
    public String getFirstPage() {
    	return "AddPatient";
    	
    }
    
  
	/*
	 * @RequestMapping("/update") public String update(@ModelAttribute Patient
	 * patient) { patientrepository.save(patient); //
	 * System.out.println(studentModel.toString()); return "success"; }
	 * 
	 * // For deleting the hostel details
	 * 
	 * @RequestMapping("/delete/{id}") public String delete(@PathVariable int id) {
	 * patientrepository.deleteById(id); // System.out.println(); return "success";
	 * 
	 * }
	 */
}
