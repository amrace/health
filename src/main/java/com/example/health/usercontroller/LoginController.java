package com.example.health.usercontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@GetMapping("/login")
    public ModelAndView getLoginPage(ModelAndView modelAndView){
    modelAndView.setViewName("login");
    return modelAndView;
    
	}

}
