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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.DataRecordTable.RecordTable;
import com.example.demo.DataRecordTable.RecordTableService;
import com.example.demo.login.LoginTable;
 
 
@RestController
public class RequestController {
 
    @Autowired
    RequestService RequestService;
    @Autowired
    RecordTableService recordService;
    
    
    
	  @RequestMapping(value = "/getrequests")
	  public @ResponseBody List<RequestTable> request() {
	  	
		  		return RequestService.getAll();
	  }
  
  
      
    
    @RequestMapping(value = "/searchByTrack", method = RequestMethod.GET)
    public ModelAndView createrequest2(@Valid @RequestParam("name") String name,@RequestParam("trackId") String trackingId,@RequestParam("id") long id) {
       // boolean a=RequestService.searchRecord(requestEntity);
    	RequestTable requestEntity=new RequestTable();
    	requestEntity.setName(name);
    	requestEntity.setId(id);
    	requestEntity.setTrackid(trackingId);
    	String returntrackid=RequestService.searchRecord(requestEntity);
    	//System.out.println("searchByName :: name :: "+name+" trackingId: "+trackingId+" id : "+id);
    	ModelAndView model=new ModelAndView("redirect:/table");
    	//model.addObject("returntrackid",returntrackid);
    	//model.addObject("recordlist", recordService.getAllRecord());
    	return model;
    }
    
    
    @RequestMapping(value = "/addRemark", method = RequestMethod.GET)
    public ModelAndView addrmrk(@Valid @RequestParam("id") long id,@RequestParam("remark") String remark ,RedirectAttributes redir){
       
    	boolean r=RequestService.addRemark(id,remark);
    	
    	ModelAndView model=new ModelAndView("redirect:/table");
    	if(!r)
    	{
    		redir.addFlashAttribute("noitem", "Item Number Not Found");
    	}
    		
    	//model.addObject("recordlist", recordService.getAllRecord());
    	return model;
    }
    
    
    
    
}