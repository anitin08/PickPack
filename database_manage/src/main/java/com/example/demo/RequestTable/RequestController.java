package com.example.demo.RequestTable;

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
public class RequestController {
 
    @Autowired
    RequestService RequestService;
 
    @RequestMapping(value = "/request")
    public List<RequestTable> request() {
        return RequestService.getAll();
    }
 
    @RequestMapping(value = "/searchrequest", method = RequestMethod.POST)
    public boolean createrequest(@Valid @RequestBody RequestTable requestEntity) {
        return RequestService.searchRecord(requestEntity);
    }
 
   /* @RequestMapping(value = "/deleterequest/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleterequest(@PathVariable(value = "id") Long id) {
        return RequestService.deleteRequest(id);
    }*/
 
   /* @RequestMapping(value = "/updaterequest/{id}", method = RequestMethod.PUT)
    public RequestTable updaterequest(@PathVariable(value = "id") Long id,
            @Valid @RequestBody RequestTable requestEntity) {
        return RequestService.updateRequest(id, requestEntity);
    }*/
 
}