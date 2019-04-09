package com.example.demo.registeration;
import com.example.demo.login.*;

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
public class RegisterController {
 
    @Autowired
    RegisterService registerService;
 
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@Valid @RequestBody LoginTable registerEntity) {
        return registerService.register(registerEntity);
    }
 
 
}