package com.example.health.usercontroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.health.UserModel.User;
import com.example.health.userrepository.UserRepository;

@Controller
@RequestMapping("/signup")
public class RegisterController {
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	 
	 @Autowired
	 private UserRepository userRepo;
	 
	 @GetMapping("/user")
	 public ModelAndView processUsers(ModelAndView modelAndView){
	 modelAndView.setViewName("register");
	 modelAndView.addObject("appUser", new User());
	 modelAndView.addObject("role","ROLE_USER");
	 return  modelAndView;
	 
	 }
	 
	 	@GetMapping("/doctor")
	 	public ModelAndView processSeller(ModelAndView modelAndView){
	 		modelAndView.setViewName("register");
	 		modelAndView.addObject("appUser", new User());
	 		modelAndView.addObject("role","ROLE_DOCTOR");
	 		return  modelAndView;

	    }
	 
	 	@PostMapping(value = "")
	    public String processPostForm(@ModelAttribute User appUser, HttpServletRequest request){
	        String role=request.getParameter("role_user");
	        String clearPassword=request.getParameter("password");
	        String hasPassword=bCryptPasswordEncoder.encode(clearPassword);
	        appUser.setPassword(hasPassword);
	        appUser.setEnabled(true);
	        appUser.setRole(role);
	        userRepo.save(appUser);
	        return  "redirect:/   ";
	    }
	
}
