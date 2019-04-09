package com.example.demo.RequestTable;
import com.example.demo.DataRecordTable.*;

import java.util.List;
import java.util.Optional;
 
import javax.persistence.EntityNotFoundException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
 
 
@Service
public class RequestService {
 
    @Autowired
    RequestRepository requestRepo;
    
    @Autowired
    RecordTableRepository recordRepo;
 
    public List<RequestTable> getAll() {
        return (List<RequestTable>) requestRepo.findAll();
    }
 
    public boolean searchRecord(RequestTable requestEntity) {
    	
    
    	                 //SEARCH IN RECORD REPO ON THE BASIS OF request entity
    	
    	List<RecordTable>result=recordRepo.findBytracking_idAndname(requestEntity.trackid, requestEntity.name);
    	if(result.size()>0)
    	{
    		while(result.size()!=0)
    		{
    			RecordTable temp=result.remove(0);
    			temp.setStatus("Picked");
    			//temp.getItem_no()
    			recordRepo.save(temp);
    		}
    		requestRepo.delete(requestEntity);
    		return true;
    	 
    		
    	}
    	

    	return false;
    }
 
    /*public RequestTable updateRequest(Long Id, RequestTable requestEntity) {
        RequestTable updatedRequest;
        Optional<RequestTable> searchEntity = requestRepo.findById(Id);
        if (searchEntity.isPresent()) {
            RequestTable Request = searchEntity.get();
            Request.setTrackid(requestEntity.getTrackid());
            Request.setName(requestEntity.getName());
            updatedRequest = requestRepo.save(Request);
        } else {
            throw new EntityNotFoundException();
        }
        return updatedRequest;
    }*/
 
    /*public ResponseEntity<Object> deleteRequest(Long Id) {
        Optional<RequestTable> requestEntity = requestRepo.findById(Id);
        if (requestEntity.isPresent()) {
            RequestTable Request = requestEntity.get();
            requestRepo.delete(Request);
        } else {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }*/
}