package com.simplilearn.Project2Jenkins.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/bookzy")
    public String index(){
        return "Hello Welcome to Bookzy!";
    }    
}
