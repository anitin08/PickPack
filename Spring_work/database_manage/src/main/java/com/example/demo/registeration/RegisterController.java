package com.example.demo.registeration;

import com.example.demo.login.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController{
 
    @Autowired
    RegisterService registerService;
    
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
    
      
    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("register", "logintable", new LoginTable());
	}

    @RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("logintable") LoginTable registerEntity) {
    	ModelAndView model;
    	if(registerService.register(registerEntity))
    	{
    		model = new ModelAndView("register","logintable", new LoginTable());
   		 	model.addObject("sussesswritten","AddedSussessfully");
    	}
    	else 
    	{
    		model = new ModelAndView("register","logintable", new LoginTable());
   		 	model.addObject("wrongroot","Incorrect Root Password");
    		
    	}
    	return model;
			 
	}
    
    
    
    

    
}