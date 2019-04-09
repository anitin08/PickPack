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
 
 
    public boolean register(LoginTable loginentity) {
    	if(loginentity.getSpecial().equals("abcdef"))
    	{
    		loginRepo.save(loginentity);
    		return true;
    	}
    return false;
    }
    
 
}