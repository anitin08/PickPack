package com.example.demo.AddUserEntry;
import com.example.demo.RequestTable.*;

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
 
 
@RestController
public class AddUserEntryController {
 
    @Autowired
    AddUserEntryService requestService;
 
 
//    @RequestMapping(value = "/createrequest", method = RequestMethod.POST)
//    public RequestTable createRequest(@Valid @RequestBody RequestTable requestEntity) {
//        return requestService.createRequest(requestEntity);
//    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
	public ModelAndView user() {
		return new ModelAndView("user", "usertable", new RequestTable());
	}
    
     @RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("usertable") RequestTable requestEntity) {
		
    	String a=requestService.createRequest(requestEntity);
    	ModelAndView model=new ModelAndView("user", "usertable", new RequestTable());
    	
    	model.addObject("success","Successfully Requested "+ a +"'s Entry");
		return model;
     }
    
 
}