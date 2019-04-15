package com.example.demo.RequestTable;

import java.util.List;

import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.DataRecordTable.RecordTable;
import com.example.demo.login.LoginTable;
 
 
@RestController
public class RequestController {
 
    @Autowired
    RequestService RequestService;
 
//    @RequestMapping(value = "/requests")
//    public ModelAndView request() {
//    	ModelAndView model=new ModelAndView("table","addrecordform",new RecordTable());
//    	model.addObject("returnedlist",RequestService.getAll());
//    	return model;
//    }
 
    
    
    
    
//    @RequestMapping(value = "/searchrequest", method = RequestMethod.POST)
//    public Model createrequest(@Valid @RequestBody RequestTable requestEntity) {
//        return RequestService.searchRecord(requestEntity);
//    }
    
    
    
}