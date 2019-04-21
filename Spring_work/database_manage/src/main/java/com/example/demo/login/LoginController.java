package com.example.demo.login;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.DataRecordTable.RecordTable;
import com.example.demo.DataRecordTable.RecordTableService;
import com.example.demo.RequestTable.RequestTable;
 
 
@RestController
public class LoginController {
	
	
	
   
	@Autowired
    LoginService loginService;
 
    @Autowired
    RecordTableService recordService;
    
    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
	public ModelAndView loginpage() {
		return new ModelAndView("login", "logintable", new LoginTable());
	}

    @RequestMapping(value = {"/table"}, method = RequestMethod.GET)
	public ModelAndView gettable() {
    	ModelAndView model = new ModelAndView("table","addrecordform",new RecordTable());
    	model.addObject("recordlist", recordService.getUnpickedRecord());
    	return model;
	}
    
    @RequestMapping(value = {"/fulltable"}, method = RequestMethod.GET)
	public ModelAndView fulltable() {
    	ModelAndView model = new ModelAndView("table","addrecordform",new RecordTable());
    	model.addObject("recordlist", recordService.getAllRecord());
    	return model;
	}
    
    
    @RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public ModelAndView welcome() {
		return new ModelAndView("index");
	}
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user", "usertable", new RequestTable());
	}
    
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerpage() {
		return new ModelAndView("register", "logintable", new LoginTable());
	}
    
    //----------------------------
    
    @RequestMapping(value = "/logincheck", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("logintable") LoginTable loginEntity ,RedirectAttributes redir ,HttpSession session) {
		
    	Boolean adminname=loginService.validation(loginEntity);
    	//System.out.println(getAdminname());
    	ModelAndView model;
    	if(adminname)
    	{
    		model = new ModelAndView("redirect:/table");
    		session.setAttribute("username", loginEntity.getUsername());
    	}
    	else
    	{
    		model= new ModelAndView("redirect:/login");
    		redir.addFlashAttribute("nouser", "User Not Found");
    	}
		return model;
	}
    
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session ,RedirectAttributes redir) {
    	
    	ModelAndView model;
    	model= new ModelAndView("redirect:/login");
    	redir.addFlashAttribute("successlogedout", "Sucessfully Loged Out!");
        session.invalidate();
       return model;
    }
 
}