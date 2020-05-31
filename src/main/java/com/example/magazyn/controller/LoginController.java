package com.example.magazyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    @Autowired
    public LoginController(LoginControllerHelper helper) {
        this.helper = helper;
    }

    LoginControllerHelper helper;

    @PostMapping("/login")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000")
    public String handleLogin(HttpEntity<String> httpEntity){
        String json = httpEntity.getBody();
        System.out.println("Json: " + json);
        return helper.authorize(json);
    }
}
