package com.token.controller;

import com.token.Service.AuthenticateService;
import com.token.dao.AuthUser;
import com.token.repository.UserJbdcRepository;
import com.token.service.MyRunnable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/login")
public class AuthenticateController {

    @Autowired
    AuthenticateService authenticateService;
    
    @Autowired
    TaskExecutor taskExecutor;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserJbdcRepository userJbdcRepository;
    
    @PostMapping(value = "/auth")
    @ResponseBody
    public String getAuthenticateToken(@RequestBody AuthUser authUser){
        System.out.println("Inside getAuthenticateToken() ::");
        String token = authenticateService.authenticateUser(authUser.getUsername(),authUser.getPassword());
        System.out.println("Token ::"+token);
        
        taskExecutor.execute(new MyRunnable(jdbcTemplate,userJbdcRepository));
        return token;
    }
}
