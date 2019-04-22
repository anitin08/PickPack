package com.example.demo.AddUserEntry;
import com.example.demo.RequestTable.*;

import java.util.List;
import java.util.Optional;
 
import javax.persistence.EntityNotFoundException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
 
@Service
public class AddUserEntryService {
 
    @Autowired
    RequestRepository requestRepo;
 
   /* public List<SampleTable> getAll() {
        return (List<SampleTable>) sampleRepo.findAll();
    }*/
 
    public String createRequest(RequestTable requestEntity) {
        RequestTable r= requestRepo.save(requestEntity);
        return r.getName();
    }
 
   /* public SampleTable updateSample(Long Id, SampleTable sampleEntity) {
        SampleTable updatedSample;
        Optional<SampleTable> searchEntity = sampleRepo.findById(Id);
        if (searchEntity.isPresent()) {
            SampleTable sample = searchEntity.get();
            sample.setAge(sampleEntity.getAge());
            sample.setName(sampleEntity.getName());
            updatedSample = sampleRepo.save(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedSample;
    }
 
    public ResponseEntity<Object> deleteSample(Long Id) {
        Optional<SampleTable> sampleEntity = sampleRepo.findById(Id);
        if (sampleEntity.isPresent()) {
            SampleTable sample = sampleEntity.get();
            sampleRepo.delete(sample);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }*/
}