package com.example.demo.AddRecord;
import com.example.demo.DataRecordTable.*;
import com.example.demo.login.LoginController;
import com.example.demo.login.LoginTable;

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
public class AddRecordController {
 
    @Autowired
    AddRecordService addrecordService;
    
    @Autowired
    RecordTableService recordService;
    
    @Autowired
    RecordTableRepository recordRepo;
    
    @Autowired
    LoginController lc;
 
    @RequestMapping(value = "/createrecord", method = RequestMethod.POST)
	public ModelAndView createaddrecord(@ModelAttribute("addrecordform") RecordTable recordEntity) {
    	
    	ModelAndView model=new ModelAndView("table","addrecordform",new RecordTable());
    	List<RecordTable>reslist=recordRepo.findBytracking_id(recordEntity.getTrack_id());
    	//System.out.println(reslist.size());
    	if(reslist.size()>0)
    	{
    		model.addObject("ans", "Record Already Exists");
    		
    	}
    	else
    	{
    		RecordTable rec=addrecordService.createaddrecord(recordEntity);
    		
    	}
    	//System.out.println(lc.getAdminname());
    	model.addObject("user", lc.getAdminname());
    	model.addObject("recordlist", recordService.getAllRecord());
    	return model;
    	
 
    	
	}
 
}