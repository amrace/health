package com.example.health.doctorcontroller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.health.UserModel.User;
import com.example.health.patientrepository.PatientRepository;
import com.example.health.userrepository.UserRepository;


@Controller
@RequestMapping("/doctor")
public class DoctorController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("")
	public ModelAndView getDoctorDashboard(Principal principal) {
		 String email = principal.getName();
	        User appUser = userRepository.findByEmail(email);
	        //List<User> listOfItem = userRepository.findById(appUser.getId());
		 ModelAndView modelAndView = new ModelAndView();
		 modelAndView.setViewName("doctor/doctor-dashboard");
		 //modelAndView.addObject("appUser", new User());
	 		modelAndView.addObject("role","ROLE_DOCTOR");
				return modelAndView;
		
	}

}
