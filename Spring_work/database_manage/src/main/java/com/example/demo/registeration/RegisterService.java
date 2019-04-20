package com.example.demo.registeration;
import com.example.demo.login.*;

import java.util.List;
import java.util.Optional;
 
import javax.persistence.EntityNotFoundException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DataRecordTable.RecordTable;
 
 
@Service
public class RegisterService {
 
    @Autowired
    LoginRepository loginRepo;
 
 
    public int register(LoginTable loginentity) {;
    	if(loginentity.getSpecial().equals("abcdef") && loginRepo.findByusername(loginentity.getUsername())==null)
    	{
    		loginRepo.save(loginentity);
    		return 1;
    	}
    	else if(!(loginentity.getSpecial().equals("abcdef")))
    	{
    		return 2;
    	}
    	else if(loginRepo.findByusername(loginentity.getUsername())!=null)
    	{
    		return 3;
    	}
    	else
    		return 4;
    }
    
 
}