package com.example.exceptionhandling.controllers;

import com.example.exceptionhandling.exceptions.BadNationalityException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/test")
public class MyController {

    @GetMapping(path = "/{id}")
    public String getId(@PathVariable Long id){
        if (id == null || id == 0) {
            BadNationalityException ex =  new BadNationalityException("error.badNationalCode");
            throw ex;

        }
        return "this is a test";
    }
}
