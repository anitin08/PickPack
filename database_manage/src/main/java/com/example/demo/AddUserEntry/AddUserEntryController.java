package com.example.demo.AddUserEntry;
import com.example.demo.DataRecordTable.RecordTable;
import com.example.demo.DataRecordTable.RecordTableRepository;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
 
 
@RestController
public class AddUserEntryController {
 
    @Autowired
    AddUserEntryService requestService;
 
    
    @Autowired
    RecordTableRepository recordRepo;
 
//    @RequestMapping(value = "/createrequest", method = RequestMethod.POST)
//    public RequestTable createRequest(@Valid @RequestBody RequestTable requestEntity) {
//        return requestService.createRequest(requestEntity);
//    }
    
    
     @RequestMapping(value = "/user", method = RequestMethod.POST)
	public ModelAndView processRequest(@ModelAttribute("usertable") RequestTable requestEntity,RedirectAttributes redir) {
    	ModelAndView model;
    	model=new ModelAndView("redirect:/user");
    	
    	
    	List<RecordTable>reslist=recordRepo.findBytracking_id(requestEntity.getTrackid());
    	//System.out.println(reslist.size());
    	if(reslist.size()>0)
    	{
    		String a=requestService.createRequest(requestEntity);
    		redir.addFlashAttribute("success","Successfully Requested "+ a +"'s Entry");
    	}
    	else
    	{
    		redir.addFlashAttribute("failure","Order Not Recieved Yet!");
    	}
    	
    	
		return model;
     }
    
 
}