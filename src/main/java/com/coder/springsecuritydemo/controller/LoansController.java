package com.coder.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoansController {
    @GetMapping("myLoans")
    public String myLoans(String input){
        return  "test in loans";
    }
}
