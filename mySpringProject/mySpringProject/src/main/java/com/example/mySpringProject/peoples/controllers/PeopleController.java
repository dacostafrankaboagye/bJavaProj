package com.example.mySpringProject.peoples.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PeopleController {

    @GetMapping(value = "/people")
    public String getPeople(){
        return "All the people are here";
    }
}
