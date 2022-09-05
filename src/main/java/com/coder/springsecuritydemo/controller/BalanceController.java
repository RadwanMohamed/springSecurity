package com.coder.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("myBalance")
    public String myCards(String input){
        return  "test in myCards";
    }
}
