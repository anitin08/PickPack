package com.example.demo.AddRecord;
import com.example.demo.DataRecordTable.*;
import java.util.List;
import java.util.Optional;
 
import javax.persistence.EntityNotFoundException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
 
@Service
public class AddRecordService {
 
    @Autowired
    RecordTableRepository RecordRepo;
 
    /*public List<RecordTable> getAll() {
        return (List<RecordTable>) RecordRepo.findAll();
    }*/
 
    public RecordTable createaddrecord(RecordTable RecordEntity) {
        return RecordRepo.save(RecordEntity);
    }
 
   /* public RecordTable updateRecord(Long Id, RecordTable RecordEntity) {
        RecordTable updatedRecord;
        Optional<RecordTable> searchEntity = RecordRepo.findById(Id);
        if (searchEntity.isPresent()) {
            RecordTable Record = searchEntity.get();
            Record.setAge(RecordEntity.getAge());
            Record.setName(RecordEntity.getName());
            updatedRecord = RecordRepo.save(Record);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedRecord;
    }
 
    public ResponseEntity<Object> deleteRecord(Long Id) {
        Optional<RecordTable> RecordEntity = RecordRepo.findById(Id);
        if (RecordEntity.isPresent()) {
            RecordTable Record = RecordEntity.get();
            RecordRepo.delete(Record);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }*/
}