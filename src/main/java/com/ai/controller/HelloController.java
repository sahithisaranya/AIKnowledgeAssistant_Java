package com.ai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController{
    @GetMapping("/hello")
    public String helloAPI(){
        return "Hello World! AI Assistant is running!";
    }
}