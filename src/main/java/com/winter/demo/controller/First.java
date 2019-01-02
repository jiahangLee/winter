package com.winter.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class First {

    @RequestMapping(value = "hello")
    public String hello(){
        System.out.println("Hello World");
        return "Hello World";
    }

}
