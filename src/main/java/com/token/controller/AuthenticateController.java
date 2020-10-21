package com.token.controller;

import com.token.Service.AuthenticateService;
import com.token.dao.AuthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
public class AuthenticateController {

    @Autowired
    AuthenticateService authenticateService;

    @PostMapping(value = "/auth")
    @ResponseBody
    public String getAuthenticateToken(@RequestBody AuthUser authUser){
        System.out.println("Inside getAuthenticateToken() ::");
        String token = authenticateService.authenticateUser(authUser.getUsername(),authUser.getPassword());
        System.out.println("Token ::"+token);
        return token;
    }
}
