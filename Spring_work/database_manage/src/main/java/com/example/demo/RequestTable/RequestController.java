package com.example.demo.RequestTable;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DataRecordTable.RecordTable;
import com.example.demo.login.LoginTable;
 
 
@RestController
public class RequestController {
 
    @Autowired
    RequestService RequestService;
 
    
    
  @RequestMapping(value = "/getrequests")
  public @ResponseBody List<RequestTable> request() {
  	
	  		return RequestService.getAll();
  }
  
  
      
    
    @RequestMapping(value = "/searchrequest", method = RequestMethod.POST)
    public void createrequest(@Valid @RequestBody RequestTable requestEntity) {
        boolean a=RequestService.searchRecord(requestEntity);
    }
    
    
    
}