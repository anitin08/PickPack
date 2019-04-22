package com.example.demo.DataRecordTable;

import java.util.List;
import java.util.Optional;
 
import javax.persistence.EntityNotFoundException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
 
@Service
public class RecordTableService {
 
    @Autowired
    RecordTableRepository recordRepo;
 
    public List<RecordTable> getAllRecord() {
        return (List<RecordTable>) recordRepo.findAll();
    }
    
    
    public List<RecordTable> getUnpickedRecord() {
        return (List<RecordTable>) recordRepo.findUnpicked();
    }
 
}