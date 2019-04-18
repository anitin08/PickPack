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
 
    public String searchRecord(RequestTable requestEntity) {
    	
    
    	                 //SEARCH IN RECORD REPO ON THE BASIS OF request entity
    	
    	List<RecordTable>result=recordRepo.findBytracking_idAndname(requestEntity.trackid, requestEntity.name);
    	if(result.size()>0)
    	{
    		String returntrackid=null;
    		while(result.size()!=0)
    		{
    			RecordTable temp=result.remove(0);
    			temp.setStatus("Picked");
    			//temp.setPickedTime(new Date())
    			//temp.getItem_no()
    			returntrackid=temp.getTrack_id();   ////this tid should be sent to ajax call
    			recordRepo.save(temp);
    		}
    		requestRepo.delete(requestEntity);
    		return returntrackid;
    	 
    		
    	}
    	

    	return null;
    }
 
}