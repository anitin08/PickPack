package com.example.demo.AddUserEntry;
import com.example.demo.RequestTable.*;

import java.util.List;

import javax.validation.Valid;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
 
@RestController
public class AddUserEntryController {
 
    @Autowired
    AddUserEntryService requestService;
 
    /*@RequestMapping(value = "/sample")
    public List<SampleTable> sample() {
        return sampleService.getAll();
    }*/
 
    @RequestMapping(value = "/createrequest", method = RequestMethod.POST)
    public RequestTable createRequest(@Valid @RequestBody RequestTable requestEntity) {
        return requestService.createRequest(requestEntity);
    }
 
   /* @RequestMapping(value = "/deletesample/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSample(@PathVariable(value = "id") Long id) {
        return sampleService.deleteSample(id);
    }
 
    @RequestMapping(value = "/updatesample/{id}", method = RequestMethod.PUT)
    public SampleTable updateSample(@PathVariable(value = "id") Long id,
            @Valid @RequestBody SampleTable sampleEntity) {
        return sampleService.updateSample(id, sampleEntity);
    }*/
 
}