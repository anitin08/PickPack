package com.example.demo.AddRecord;
import com.example.demo.DataRecordTable.*;

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
public class AddRecordController {
 
    @Autowired
    AddRecordService addrecordService;
 
    /*@RequestMapping(value = "/addrecord")
    public List<RecordTable> addrecord() {
        return addrecordService.getAll();
    }*/
 
    @RequestMapping(value = "/createrecord", method = RequestMethod.POST)
    public RecordTable createaddrecord(@Valid @RequestBody RecordTable recordEntity) {
        return addrecordService.createaddrecord(recordEntity);
    }
 
    /*@RequestMapping(value = "/deleteaddrecord/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteaddrecord(@PathVariable(value = "id") Long id) {
        return addrecordService.deleteaddrecord(id);
    }*/
 
    /*@RequestMapping(value = "/updateaddrecord/{id}", method = RequestMethod.PUT)
    public RecordTable updateaddrecord(@PathVariable(value = "id") Long id,
            @Valid @RequestBody RecordTable addrecordEntity) {
        return addrecordService.updateaddrecord(id, addrecordEntity);
    }*/
 
}