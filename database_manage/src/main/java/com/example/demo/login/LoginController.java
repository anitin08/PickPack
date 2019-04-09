package com.example.demo.login;

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
public class LoginController {
 
    @Autowired
    LoginService loginService;
 
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean validation(@Valid @RequestBody LoginTable loginEntity) {
        return loginService.validation(loginEntity);
    }
 
 
}