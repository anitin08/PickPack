package com.example.demo.DataRecordTable;

import java.util.List;

import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.login.LoginTable;
 
 
@RestController
public class RecordTableController {
 
    @Autowired
    RecordTableService recordService;
    
    
//    @RequestMapping(value = "/table")
//    public List<RecordTable> record() {
//        return recordService.getAllRecord();
//    }
    
    
//    @RequestMapping(value = "/table")
//    public ModelAndView table() {
//    	List<RecordTable> datarecords = recordService.getAllRecord();
//		ModelAndView model = new ModelAndView("table");
//		model.addObject("recordlist", datarecords);
//		return model;
//	}
 
 
}