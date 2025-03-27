package com.springrest.springrest.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class MyController {
    
    @GetMapping("/home")
    public String home() {
        return "Welcome to course application ";
    }
    
}   
