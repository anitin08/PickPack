package com.example.demo.login;

import java.util.List;

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

import com.example.demo.DataRecordTable.RecordTable;
import com.example.demo.DataRecordTable.RecordTableService;
 
 
@RestController
public class LoginController {
	
	private String adminname;
	
    public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	@Autowired
    LoginService loginService;
 
    @Autowired
    RecordTableService recordService;
    
    @RequestMapping(value = {"/login","/table"}, method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("login", "logintable", new LoginTable());
	}

    @RequestMapping(value = "/table", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("logintable") LoginTable loginEntity) {
		
    	adminname=loginService.validation(loginEntity);
    	//System.out.println(getAdminname());
    	ModelAndView model;
    	if(adminname!=null)
    	{
    		model = new ModelAndView("table","addrecordform",new RecordTable());
    		model.addObject("user", adminname);
    		model.addObject("recordlist", recordService.getAllRecord());
    	}
    	else
    	{
    		model= new ModelAndView("login", "logintable", new LoginTable());
    		model.addObject("nouser", "User Not Found");
    	}
		return model;
	}
 
}