package com.example.exceptionhandling.controllers;

import com.example.exceptionhandling.entity.Account;
import com.example.exceptionhandling.exceptions.BadNationalityException;
import com.example.exceptionhandling.exceptions.EntityNotFoundException;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/save")
    public String saveAccount(@RequestBody Account account){
        if (account.getNationalCode()==0) {
            throw new BadNationalityException("error.badNationalCode");
        }else if(account.getUsername()==null){
            throw new EntityNotFoundException("error.entityNotFound");
        }
        return "حساب کاربری با موفقیت ذخیره شد";
    }


}
