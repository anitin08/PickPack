package com.example.demo.login;

import java.util.List;
import java.util.Optional;
 
import javax.persistence.EntityNotFoundException;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.DataRecordTable.RecordTable;
 
 
@Service
public class LoginService {
 
    @Autowired
    LoginRepository loginRepo;
 
 
    public boolean validation(LoginTable loginentity) {
    	
    	LoginTable result=loginRepo.findByusernameAndpassword(loginentity.username, loginentity.password);
    	if(result!=null)
    	{
    		return true;
    	}
        return false;
    }
    
 
}