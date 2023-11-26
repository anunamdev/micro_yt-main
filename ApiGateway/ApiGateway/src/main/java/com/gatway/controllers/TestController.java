package com.gatway.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping
public class TestController {

    @GetMapping
    public Map<String,String> output(){
        HashMap<String, String> hash = new HashMap<>();
        hash.put("Hi","Hello");
        System.out.println("Controller is called");
        return hash;
    }

}
